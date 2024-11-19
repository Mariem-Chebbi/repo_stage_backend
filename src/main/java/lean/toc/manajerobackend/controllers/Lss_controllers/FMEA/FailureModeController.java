package lean.toc.manajerobackend.controllers.Lss_controllers.FMEA;

import lean.toc.manajerobackend.models.Lss_models.FMEA.FailureMode;
import lean.toc.manajerobackend.models.Lss_models.FMEA.Fmea;
import lean.toc.manajerobackend.services.Lss_services.FMEA.FailureModeServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/failuremode")

@AllArgsConstructor
public class FailureModeController {
    @Autowired
    FailureModeServiceImpl failureModeService;
    @GetMapping("/{fmeaid}/get")
    public List<FailureMode> getfailuremodes(@PathVariable String fmeaid) {
        return   failureModeService.getFailuresByFmea(fmeaid);
    }


    @PostMapping("/{id}/add")
    public Fmea addFailuremode(@PathVariable String id, @RequestBody FailureMode failureMode) {
        return failureModeService.addFailureMode(id, failureMode);
    }
    @PutMapping("/update/{failureModeId}")
    public FailureMode updateFailureMode(
            @PathVariable String failureModeId,
            @RequestBody FailureMode updatedFailureMode) {
        return failureModeService.updateFailureMode(failureModeId, updatedFailureMode);
    }
    @DeleteMapping("/{id}/remove/{FailuremodeId}")
    public Fmea removeFailureMode(@PathVariable String id, @PathVariable String FailuremodeId) {
        return failureModeService.removeFailureMode(id, FailuremodeId);
    }


}
