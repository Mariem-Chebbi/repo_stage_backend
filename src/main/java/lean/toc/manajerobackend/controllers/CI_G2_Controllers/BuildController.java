package lean.toc.manajerobackend.controllers.CI_G2_Controllers;


import lean.toc.manajerobackend.models.CI_g2.model.Project;
import lean.toc.manajerobackend.services.Ci_G2_Services.GitHubActionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/build")
public class BuildController {

    private final GitHubActionsService gitHubActionsService;

    @Autowired
    public BuildController(GitHubActionsService gitHubActionsService) {
        this.gitHubActionsService = gitHubActionsService;
    }

    @PostMapping("/trigger")
    public ResponseEntity<String> triggerBuild(@RequestBody Project project, @RequestParam String workflowFile) {
        return gitHubActionsService.triggerBuild(project.getGitUrl(), project.getToken(), workflowFile);
    }

}