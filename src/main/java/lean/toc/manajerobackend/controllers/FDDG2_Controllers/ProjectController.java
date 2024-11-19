package lean.toc.manajerobackend.controllers.FDDG2_Controllers;

import lean.toc.manajerobackend.models.FDDG2_Entities.Project;
import lean.toc.manajerobackend.services.FDDG2_Services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("ProjectControllerFDDG2")
@RequestMapping("/project")
public class ProjectController {
    @Autowired
    ProjectService projectService;
    @GetMapping("/getAllProjects")
    public List<Project> ProjectList (){
        return projectService.getAllProject();
    }
    @PostMapping("/addProject")
    public Project addWS(@RequestBody Project project){
        return projectService.AddProject(project);
    }
    @PostMapping("/editProject/{id}")
    public Project EditProject(@RequestBody Project project,@PathVariable ("id") String codeProject){
        return projectService.EditProject(project,codeProject);
    }
    @GetMapping("/getProject/{id}")
    public Project getOneProject(@PathVariable("id") String codeProject){
        return projectService.getOneProject(codeProject);
    }
    @DeleteMapping("/deleteProject/{id}")
    public String deleteProject(@PathVariable("id") String codeProject){
        projectService.deleteProject(codeProject);
        return "Project deleted successfully";
    }
    @PostMapping("/addProjectToWS/{id}")
    public Project createProject(@PathVariable("id") String id,@RequestBody Project project){
        return projectService.addProjectToWorkspace(id,project);
    }
    @GetMapping("/getWSProject/{id}")
    public List<Project> fetchWSProject(@PathVariable("id") String id){
        return projectService.getWSProjects(id);
    }

}
