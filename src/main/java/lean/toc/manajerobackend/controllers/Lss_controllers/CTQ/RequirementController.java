package lean.toc.manajerobackend.controllers.Lss_controllers.CTQ;


import lean.toc.manajerobackend.models.Lss_models.CTQ.Requirement;
import lean.toc.manajerobackend.services.Lss_services.CTQ.RequirementServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/requirement")

@AllArgsConstructor
public class RequirementController {
    @Autowired
    RequirementServiceImpl requirementService;

    @PostMapping("/{projectCharterId}")
    public ResponseEntity<Requirement> addRequirement(@RequestBody Requirement requirement, @PathVariable String projectCharterId) {
        Requirement createdRequirement = requirementService.addRequirement(requirement, projectCharterId);
        return ResponseEntity.ok(createdRequirement);
    }
    @GetMapping("/byProjectCharter/{projectCharterId}")
    public List<Requirement> getRequirementsByProjectCharterId(@PathVariable String projectCharterId) {
        return requirementService.getRequirementsByProjectId(projectCharterId);
    }
    @DeleteMapping("/{requirementId}")
    public void deleterequirement(@PathVariable String requirementId) {
        requirementService.deleteRequirement(requirementId);
    }
    @PutMapping("/update/{requirementId}")
    public Requirement updateRequirement(@PathVariable String requirementId, @RequestBody Requirement requirement) {
        requirement.setId(requirementId);
        return requirementService.updateRequirement(requirement);
    }

}
