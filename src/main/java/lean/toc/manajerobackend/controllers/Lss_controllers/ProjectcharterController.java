package lean.toc.manajerobackend.controllers.Lss_controllers;

import lean.toc.manajerobackend.models.Lss_models.ProjectCharter;
import lean.toc.manajerobackend.services.Lss_services.ProjectcharterServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projectcharter")

@AllArgsConstructor
public class ProjectcharterController {
    @Autowired
    ProjectcharterServiceImpl projectcharterService;
    @PostMapping
    public ProjectCharter addProject(@RequestBody ProjectCharter projectCharter) {
        return projectcharterService.addProject(projectCharter);
    }
    @GetMapping("/allProjects")
    public ResponseEntity<List<ProjectCharter>> getAllProjects() {
        List<ProjectCharter> projects = projectcharterService.getProjects();
        return ResponseEntity.ok(projects);
    }

}
