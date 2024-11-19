package lean.toc.manajerobackend.services.Lss_services.CTQ;

import lean.toc.manajerobackend.models.Lss_models.CTQ.Ctq;
import lean.toc.manajerobackend.models.Lss_models.CTQ.Requirement;
import lean.toc.manajerobackend.repositories.Lss_repositories.CTQ.CtqRepository;
import lean.toc.manajerobackend.repositories.Lss_repositories.CTQ.RequirementRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CtqServiceImpl {
    @Autowired
    CtqRepository ctqRepository;


    @Autowired
    RequirementRepository requirementRepository;


    public Requirement addCtq(String id, Ctq ctq) {
        Requirement requirement=requirementRepository.findById(id).orElse(null);
        Optional<Requirement> RequirementOptional = requirementRepository.findById(id);
        if (RequirementOptional.isPresent()) {
            Requirement existingRequ = RequirementOptional.get();
            ctq.setId(null);
            ctq.setRequirement(requirement);
            ctq.setMet(false);
            ctqRepository.save(ctq);
            existingRequ.getCtqs().add(ctq);
            return  requirementRepository.save(existingRequ);
        }
        return null;
    }
    public Ctq updateCtq(String CtqId, Ctq updatedCtq) {
        Optional<Ctq> CtqOptional = ctqRepository.findById(CtqId);
        if (CtqOptional.isPresent()) {
            Ctq existingCtq = CtqOptional.get();
            existingCtq.setDescription(updatedCtq.getDescription());
            return ctqRepository.save(existingCtq);
        }
        return null;
    }
    public Requirement removeCtq(String requirementId, String ctqId) {
        // Retrieve the Requirement
        Optional<Requirement> requirementOptional = requirementRepository.findById(requirementId);
        if (!requirementOptional.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Requirement not found");
        }

        Requirement existingRequirement = requirementOptional.get();

        // Retrieve the Ctq to be removed
        Ctq ctqToRemove = ctqRepository.findById(ctqId).orElse(null);
        if (ctqToRemove == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Ctq not found");
        }

        // Remove the Ctq from the Requirement's list
        existingRequirement.getCtqs().removeIf(ctq -> ctq.getId().equals(ctqId));

        // Save the updated Requirement
        requirementRepository.save(existingRequirement);

        // Delete the Ctq
        ctqRepository.deleteById(ctqId);

        return existingRequirement;
    }


    public double calculateDefectRateByProjectCharterId(String projectCharterId) {
        // Retrieve all Requirements associated with the project charter ID
        List<Requirement> requirements = requirementRepository.findByProjectid(projectCharterId);
        if (requirements != null && !requirements.isEmpty()) {
            // Retrieve all CTQs from the Requirements
            List<Ctq> ctqs = requirements.stream()
                    .flatMap(requirement -> requirement.getCtqs().stream())
                    .collect(Collectors.toList());

            if (!ctqs.isEmpty()) {
                long totalCtqs = ctqs.size();
                long defectiveCtqs = ctqs.stream().filter(ctq -> !ctq.isMet()).count();
                return (double) defectiveCtqs / totalCtqs;  // Compute defect rate

            }
        }
        return 0.0;  // Return 0 if no CTQs available
    }
    public List<Ctq> getCtqByReq(String id) {
        return ctqRepository.findByRequirementId(id);
    }
    public Ctq ValidateCtq(String id) {
        Optional<Ctq> ctqOptional = ctqRepository.findById(id);

        if (ctqOptional.isPresent()) {
            Ctq existingCtq = ctqOptional.get();

            existingCtq.setMet(true);

            return ctqRepository.save(existingCtq);
        }

        return null;
    }
    public Ctq UnvalidateCtq(String id) {
        Optional<Ctq> ctqOptional = ctqRepository.findById(id);

        if (ctqOptional.isPresent()) {
            Ctq existingCtq = ctqOptional.get();

            existingCtq.setMet(false);

            return ctqRepository.save(existingCtq);
        }

        return null;
    }
    public Map<String, Double> calculateIsMetPercentageByProjectCharterId(String projectCharterId) {
        List<Requirement> requirements = requirementRepository.findByProjectid(projectCharterId);

        return requirements.stream().collect(Collectors.toMap(
                Requirement::getDescription,
                requirement -> {
                    List<Ctq> ctqs = requirement.getCtqs();
                    if (ctqs.isEmpty()) {
                        return 0.0;
                    }
                    long totalCtqs = ctqs.size();
                    long metCtqs = ctqs.stream().filter(Ctq::isMet).count();
                    double percentage = (double) metCtqs / totalCtqs * 100;
                    return Math.round(percentage * 100.0) / 100.0; // Round to two decimal places
                }
        ));
    }
}
