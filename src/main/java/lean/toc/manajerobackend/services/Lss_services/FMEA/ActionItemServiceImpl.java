package lean.toc.manajerobackend.services.Lss_services.FMEA;
import lean.toc.manajerobackend.models.Lss_models.FMEA.ActionItem;
import lean.toc.manajerobackend.models.Lss_models.FMEA.FailureMode;
import lean.toc.manajerobackend.models.Lss_models.FMEA.Status_Action;
import lean.toc.manajerobackend.repositories.Lss_repositories.FMEA.ActionItemRepository;
import lean.toc.manajerobackend.repositories.Lss_repositories.FMEA.FailureModeRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ActionItemServiceImpl {
    @Autowired
    ActionItemRepository actionItemRepository;
    @Autowired
    FailureModeRepository failureModeRepository;
    public FailureMode addActionItem(String id, ActionItem actionItem) {
        FailureMode fm=failureModeRepository.findById(id).orElse(null);
        Optional<FailureMode> FmOptional = failureModeRepository.findById(id);
        if (FmOptional.isPresent()) {
            FailureMode existingFm = FmOptional.get();
            actionItem.setId(null);
            actionItem.setStatus(Status_Action.TODO);
            actionItem.setArchive(false);
            actionItem.setFailureMode(fm);
            actionItemRepository.save(actionItem);
            existingFm.getActionItems().add(actionItem);
            return  failureModeRepository.save(existingFm);
        }
        return null;
    }
    public List<ActionItem> getActionsByFm(String id) {
        return actionItemRepository.findByFailureModeIdAndArchive(id,false);
    }
    public List<ActionItem> getArchivedActionsByFm(String id) {
        return actionItemRepository.findByFailureModeIdAndArchive(id,true);
    }

    public ActionItem archiveActionItem(String actionItemId) {
        // Fetch the ActionItem from the repository
        Optional<ActionItem> actionItemOptional = actionItemRepository.findById(actionItemId);

        // Check if the ActionItem exists
        if (actionItemOptional.isPresent()) {
            ActionItem existingActionItem = actionItemOptional.get();

            // Set the archive flag to true
            existingActionItem.setArchive(true);

            // Save the updated ActionItem and return it
            return actionItemRepository.save(existingActionItem);
        }

return null;
    }
    public ActionItem unarchiveActionItem(String actionItemId) {
        // Fetch the ActionItem from the repository
        Optional<ActionItem> actionItemOptional = actionItemRepository.findById(actionItemId);

        // Check if the ActionItem exists
        if (actionItemOptional.isPresent()) {
            ActionItem existingActionItem = actionItemOptional.get();

            // Set the archive flag to true
            existingActionItem.setArchive(false);

            // Save the updated ActionItem and return it
            return actionItemRepository.save(existingActionItem);
        }

        return null;
    }

    public ActionItem updateActionItem(String ActionItemId, ActionItem updatedActionItem) {
        Optional<ActionItem> ActionItemOptional = actionItemRepository.findById(ActionItemId);
        if (ActionItemOptional.isPresent()) {
            ActionItem existinActionItem = ActionItemOptional.get();
            existinActionItem.setDescription(updatedActionItem.getDescription());
            existinActionItem.setDueDate(updatedActionItem.getDueDate());
            existinActionItem.setTitle(updatedActionItem.getTitle());
            existinActionItem.setStatus(updatedActionItem.getStatus());

            return actionItemRepository.save(existinActionItem);
        }
        return null;
    }
    public FailureMode removeActionItem(String failureModeIdId, String ActionItemId) {
        Optional<FailureMode> fmOptional = failureModeRepository.findById(failureModeIdId);
        if (!fmOptional.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "fm not found");
        }

        FailureMode existingFm = fmOptional.get();
        ActionItem ActionItemToRemove = actionItemRepository.findById(ActionItemId).orElse(null);
        if (ActionItemToRemove == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "action not found");
        }

        boolean removed = existingFm.getActionItems().removeIf(ai -> ai.getId().equals(ActionItemId));
         actionItemRepository.deleteById(ActionItemId);

            failureModeRepository.save(existingFm);

        return existingFm;
    }


}
