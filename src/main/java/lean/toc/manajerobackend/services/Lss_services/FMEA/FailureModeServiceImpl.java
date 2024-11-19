package lean.toc.manajerobackend.services.Lss_services.FMEA;

import lean.toc.manajerobackend.models.Lss_models.FMEA.ActionItem;
import lean.toc.manajerobackend.models.Lss_models.FMEA.FailureMode;
import lean.toc.manajerobackend.models.Lss_models.FMEA.Fmea;
import lean.toc.manajerobackend.repositories.Lss_repositories.FMEA.ActionItemRepository;
import lean.toc.manajerobackend.repositories.Lss_repositories.FMEA.FailureModeRepository;
import lean.toc.manajerobackend.repositories.Lss_repositories.FMEA.FmeaRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class FailureModeServiceImpl {
    @Autowired
    FailureModeRepository failureModeRepository;
    @Autowired
    FmeaRepository fmeaRepository;
    @Autowired
    ActionItemRepository actionItemRepository;
    public List<FailureMode> getFailuresByFmea(String id) {
        return failureModeRepository.findByFmea_IdAndArchive(id,false);
    }


    public Fmea addFailureMode(String id, FailureMode failureMode) {
        Fmea fmea=fmeaRepository.findById(id).orElse(null);
        Optional<Fmea> FmeaOptional = fmeaRepository.findById(id);
        if (FmeaOptional.isPresent()) {
            Fmea existingFmea = FmeaOptional.get();
            failureMode.setId(null);
            failureMode.setFmea(fmea);
            failureMode.setRpn(failureMode.getRpn());
            failureMode.setActionItems(new ArrayList<>());
            failureModeRepository.save(failureMode);
            existingFmea.getFailureModes().add(failureMode);
            return  fmeaRepository.save(existingFmea);
        }
        return null;
    }
    public FailureMode updateFailureMode(String FailureModeId, FailureMode updatedFailureMode) {
        Optional<FailureMode> FailureModeOptional = failureModeRepository.findById(FailureModeId);
        if (FailureModeOptional.isPresent()) {
            FailureMode existingFailureMode = FailureModeOptional.get();
            existingFailureMode.setDescription(updatedFailureMode.getDescription());
            existingFailureMode.setSeverity(updatedFailureMode.getSeverity());
            existingFailureMode.setOccurrence(updatedFailureMode.getOccurrence());
            existingFailureMode.setDetection(updatedFailureMode.getDetection());
            existingFailureMode.setTitle(updatedFailureMode.getTitle());
            existingFailureMode.setRpn(existingFailureMode.getRpn()); // Calculate RPN if needed
            return failureModeRepository.save(existingFailureMode);
        }
        return null;
    }
    public Fmea removeFailureMode(String fmeaId, String failureModeId) {
        Optional<Fmea> fmeaOptional = fmeaRepository.findById(fmeaId);
        if (!fmeaOptional.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "FMEA not found");
        }

        Fmea existingFmea = fmeaOptional.get();
        FailureMode failureModeToRemove = failureModeRepository.findById(failureModeId).orElse(null);
        if (failureModeToRemove == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Failure Mode not found");
        }

        boolean removed = existingFmea.getFailureModes().removeIf(failureMode -> failureMode.getId().equals(failureModeId));
        if (removed) {
            // If the FailureMode was removed, delete its associated ActionItems
            List<ActionItem> actions = new ArrayList<>(failureModeToRemove.getActionItems());
            for (ActionItem actionItem : actions) {
                actionItemRepository.deleteById(actionItem.getId());
            }

            // Finally, delete the FailureMode itself
            failureModeRepository.deleteById(failureModeId);

            // Save the updated Fmea without the removed FailureMode
            fmeaRepository.save(existingFmea);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Failure Mode not found in the FMEA");
        }

        return existingFmea;
    }




}
