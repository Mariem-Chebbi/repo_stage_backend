package lean.toc.manajerobackend.controllers.Lss_controllers.FMEA;

import lean.toc.manajerobackend.models.Lss_models.FMEA.Fmea;
import lean.toc.manajerobackend.services.Lss_services.FMEA.FmeaServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/fmea")

@AllArgsConstructor
public class FmeaController {

    @Autowired
    FmeaServiceImpl fmeaService;

    @PostMapping("/{projectCharterId}")
    public ResponseEntity<Fmea> addFmea(@RequestBody Fmea fmea, @PathVariable String projectCharterId) {
        Fmea createdFmea = fmeaService.createFmea(fmea, projectCharterId);
        return ResponseEntity.ok(createdFmea);
    }
    @GetMapping("/byProjectCharter/{projectCharterId}")
    public List<Fmea> getFmeasByProjectCharterId(@PathVariable String projectCharterId) {
        return fmeaService.getFmeasByProjectCharterId(projectCharterId);
    }
    @GetMapping("/Byarchive/{projectCharterId}")
    public List<Fmea> getarchiveFmeasByProjectCharterId(@PathVariable String projectCharterId) {
        return fmeaService.getarchivedFmeas(projectCharterId);
    }
    @DeleteMapping("/{FmeaId}")
    public void deleteFmea(@PathVariable String FmeaId) {
        fmeaService.deleteFmea(FmeaId);
    }

    @PutMapping("/update/{FmeaId}")
    public Fmea updateRequirement(@PathVariable String FmeaId, @RequestBody Fmea fmea) {
        fmea.setId(FmeaId);
        return fmeaService.updateFmea(fmea);
    }
    @PutMapping("/archive/{Id}")
    public Fmea archive(
            @PathVariable String Id) {
        return fmeaService.archiveFMEA(Id);
    }
    @PutMapping("/unarchive/{Id}")
    public Fmea unarchive(
            @PathVariable String Id) {
        return fmeaService.unarchiveFMEA(Id);
    }
    ///for dashboard sprint3 //
    @GetMapping("/{projectCharterId}/actionItemCounts")
    public Map<String, Map<String, Long>> getActionItemCounts(@PathVariable String projectCharterId) {
        return fmeaService.countActionItemsPerFailureMode(projectCharterId);
    }

}
