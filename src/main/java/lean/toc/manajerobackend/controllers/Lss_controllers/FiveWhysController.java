package lean.toc.manajerobackend.controllers.Lss_controllers;


import lean.toc.manajerobackend.models.Lss_models.Fivewhys.Fivewhys;
import lean.toc.manajerobackend.models.Lss_models.Fivewhys.ParetoData;
import lean.toc.manajerobackend.models.Lss_models.Fivewhys.Solution;
import lean.toc.manajerobackend.services.Lss_services.FiveWhysServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/fivewhys")
@AllArgsConstructor

public class FiveWhysController {
    @Autowired
    private FiveWhysServiceImpl fiveWhysService;

    @PostMapping("/{projectCharterId}")
    public ResponseEntity<Fivewhys> addFivewhys(@RequestBody Fivewhys fivewhys, @PathVariable String projectCharterId) {
        Fivewhys createdFivewhys = fiveWhysService.addFivewhys(fivewhys, projectCharterId);
        return ResponseEntity.ok(createdFivewhys);
    }
    @GetMapping("/byProjectCharter/{projectCharterId}")
    public List<Fivewhys> getFivewhysByProjectCharterId(@PathVariable String projectCharterId) {
        return fiveWhysService.getFivewhysByProjectCharterId(projectCharterId);
    }
    @DeleteMapping("/{fivewhysId}")
    public void deleteFivewhys(@PathVariable String fivewhysId) {
        fiveWhysService.deleteFivewhys(fivewhysId);
    }

    @PutMapping("/{fivewhysId}")
    public Fivewhys updateFivewhys(@PathVariable String fivewhysId, @RequestBody Fivewhys fivewhys) {
        fivewhys.setId_fivewhys(fivewhysId);
        return fiveWhysService.updateFivewhys(fivewhys);
    }
    @PostMapping("/{id}/addsolution")
    public Fivewhys addSolution(@PathVariable String id, @RequestBody Solution solution) {
        return fiveWhysService.addSolution(id, solution);
    }
    @PutMapping("/updateSolution/{solutionId}")
    public Solution updateSolution(@PathVariable String solutionId, @RequestBody Solution solution) {
        return fiveWhysService.updateSolution(solutionId, solution);
    }
    @GetMapping("/pareto-data")
    public ResponseEntity<List<ParetoData>> getParetoData() {
        List<ParetoData> paretoData = fiveWhysService.getParetoData();
        return ResponseEntity.ok(paretoData);
    }

    //sprint3//
    @GetMapping("/countByProject/{projectId}")
    public long getCountByProject(@PathVariable String projectId) {
        return fiveWhysService.countFivewhysByProject(projectId);
    }

    @GetMapping("/countWithoutSolution/{projectId}")
    public long getCountWithoutSolution(@PathVariable String projectId) {
        return fiveWhysService.countFivewhysWithoutSolutionByProject(projectId);
    }
    @GetMapping("/radar-data/{idproject}")
    public Map<String, Object> getRadarChartData(@PathVariable String idproject) {
        return fiveWhysService.getRadarChartData(idproject);
    }
    }



