package lean.toc.manajerobackend.services.Lss_services.CTQ;


import lean.toc.manajerobackend.models.Lss_models.CTQ.Ctq;
import lean.toc.manajerobackend.models.Lss_models.CTQ.Requirement;
import lean.toc.manajerobackend.repositories.Lss_repositories.CTQ.CtqRepository;
import lean.toc.manajerobackend.repositories.Lss_repositories.CTQ.RequirementRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RequirementServiceImpl {
    @Autowired
    private RequirementRepository requirementRepository;

    @Autowired
    CtqRepository ctqRepository;

    public List<Requirement> getRequirementsByProjectId(String projectCharterId) {
        return requirementRepository.findByProjectid(projectCharterId);
    }


    public void deleteRequirement(String id) {
        // Retrieve the Requirement
        Requirement requirement = requirementRepository.findById(id).orElse(null);
        if (requirement != null) {
            // Iterate over each Ctq associated with the Requirement
            for (Ctq ctq : requirement.getCtqs()) {

                // Delete the Ctq
                ctqRepository.deleteById(ctq.getId());
            }
            // Delete the Requirement
            requirementRepository.deleteById(requirement.getId());
        }
    }
    public Requirement addRequirement(Requirement requirement, String projectCharterId) {
        requirement.setProjectid(projectCharterId);

        requirement.setId(null);
        Requirement savedRequirement = requirementRepository.save(requirement);

        List<Ctq> ctqs = requirement.getCtqs();
        for (Ctq ctq : ctqs) {
            ctq.setId(null);
            ctq.setMet(false);
            ctq.setRequirement(savedRequirement);
            ctqRepository.save(ctq);
        }

        return requirementRepository.save(savedRequirement);
    }

    public Requirement updateRequirement(Requirement updatedRequirement) {

        Requirement existingRequirement = requirementRepository.findById(updatedRequirement.getId()).orElse(null);

        if (existingRequirement != null) {
            existingRequirement.setDescription(updatedRequirement.getDescription());

            List<Ctq> newCtqs = updatedRequirement.getCtqs();
            for (Ctq updatedCtq : newCtqs) {
                updatedCtq.setRequirement(existingRequirement);
                ctqRepository.save(updatedCtq);
            }

            existingRequirement.setCtqs(newCtqs);
            return requirementRepository.save(existingRequirement);
        } else {
            throw new RuntimeException("not found with ID: " + updatedRequirement.getId());
        }
    }
}
