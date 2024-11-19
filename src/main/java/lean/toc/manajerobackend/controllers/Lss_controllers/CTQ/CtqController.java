package lean.toc.manajerobackend.controllers.Lss_controllers.CTQ;

import lean.toc.manajerobackend.models.Lss_models.CTQ.Ctq;
import lean.toc.manajerobackend.models.Lss_models.CTQ.Requirement;
import lean.toc.manajerobackend.services.Lss_services.CTQ.CtqServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/ctq")

@AllArgsConstructor
public class CtqController {
    @Autowired
    CtqServiceImpl ctqService;

    @PostMapping("/{id}/addctq")
    public Requirement addCtq(@PathVariable String id, @RequestBody Ctq ctq) {
        return ctqService.addCtq(id, ctq);
    }

    @PutMapping("/updateCtq/{CtqId}")
    public Ctq updateCtq(@PathVariable String CtqId, @RequestBody Ctq ctq) {
        return ctqService.updateCtq(CtqId, ctq);
    }

    @DeleteMapping("/{id}/remove/{ctqId}")
    public Requirement removeCtq(@PathVariable String id, @PathVariable String ctqId) {
        return ctqService.removeCtq(id, ctqId);
    }


    @GetMapping("/{id}/get")
    public List<Ctq> get(@PathVariable String id) {
        return ctqService.getCtqByReq(id);
    }

    @PutMapping("/valid/{id}")
    public Ctq validctq(
            @PathVariable String id) {
        return ctqService.ValidateCtq(id);
    }
    @PutMapping("/unvalid/{id}")
    public Ctq unvalidctq(
            @PathVariable String id) {
        return ctqService.UnvalidateCtq(id);
    }
//sprint3//
    @GetMapping("/{projectCharterId}/isMetPercentage")
    public Map<String, Double> getIsMetPercentageByProjectCharterId(@PathVariable String projectCharterId) {
        return ctqService.calculateIsMetPercentageByProjectCharterId(projectCharterId);
    }
    @GetMapping("/{projectCharterId}/defectRate")
    public double getDefectRateByProjectCharterId(@PathVariable String projectCharterId) {
        return ctqService.calculateDefectRateByProjectCharterId(projectCharterId);
    }
}
