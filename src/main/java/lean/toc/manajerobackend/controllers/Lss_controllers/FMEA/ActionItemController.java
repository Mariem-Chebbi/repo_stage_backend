package lean.toc.manajerobackend.controllers.Lss_controllers.FMEA;

import lean.toc.manajerobackend.models.Lss_models.FMEA.ActionItem;
import lean.toc.manajerobackend.models.Lss_models.FMEA.FailureMode;
import lean.toc.manajerobackend.services.Lss_services.FMEA.ActionItemServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/actionitem")
@AllArgsConstructor

public class ActionItemController {
    @Autowired
    ActionItemServiceImpl actionItemService;

    @GetMapping("/{fmid}/get")
    public List<ActionItem> getActions(@PathVariable String fmid) {
        return   actionItemService.getActionsByFm(fmid);
    }
    @GetMapping("/{fmid}/getArchive")
    public List<ActionItem> getActionsarchived(@PathVariable String fmid) {
        return   actionItemService.getArchivedActionsByFm(fmid);
    }

    @PostMapping("/{id}/add")
    public FailureMode addAction(@PathVariable String id, @RequestBody ActionItem actionItem) {
        return actionItemService.addActionItem(id, actionItem);
    }
    @PutMapping("/update/{actionsId}")
    public ActionItem updateActions(
            @PathVariable String actionsId,
            @RequestBody ActionItem updatedActions) {
        return actionItemService.updateActionItem(actionsId, updatedActions);
    }
    @PutMapping("/archive/{actionsId}")
    public ActionItem archiveActions(
            @PathVariable String actionsId) {
        return actionItemService.archiveActionItem(actionsId);
    }
    @PutMapping("/unarchive/{actionsId}")
    public ActionItem unarchiveActions(
            @PathVariable String actionsId) {
        return actionItemService.unarchiveActionItem(actionsId); }
    @DeleteMapping("/{id}/remove/{actionId}")
    public FailureMode removeActions(@PathVariable String id, @PathVariable String actionId) {
        return actionItemService.removeActionItem(id, actionId);
    }

}
