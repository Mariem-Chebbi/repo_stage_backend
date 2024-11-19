package lean.toc.manajerobackend.controllers.pokerPlanning_grp2_controllers;


import lean.toc.manajerobackend.models.pokerPlanning_grp2_models.Issues;
import lean.toc.manajerobackend.models.pokerPlanning_grp2_models.IssuesRequest;
import lean.toc.manajerobackend.services.pokerPlanning_grp2_services.IssuesServices;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@AllArgsConstructor
public class IssuesController {
    IssuesServices issuesServices;
      @PostMapping("/session/{sessionId}")
      public Issues addIssue(@PathVariable String sessionId, @RequestBody Issues issue) {
          return issuesServices.addIssue(sessionId, issue);
      }

    @GetMapping("/getIssues")
    List<Issues> getIssues(){
        return issuesServices.getAllIssues();
    }

    @GetMapping("/session/{sessionId}")
    public List<Issues> getIssuesBySessionId(@PathVariable String sessionId) {
        return issuesServices.getIssuesBySessionId(sessionId);
    }

    @PutMapping("/updateIssue/{id}")
    public Issues updateIssue(@PathVariable String id, @RequestBody Issues issues) {
        return issuesServices.updateIssues(issues, id);

    }

    @DeleteMapping("/deleteIssue/{id}")
    void deleteIssue(@PathVariable String id) {
        issuesServices.deleteIssues(id);
    }
    @PostMapping("/insert/session/{sessionId}")
    public void insertIssues1(@RequestBody List<IssuesRequest> issues, @PathVariable String sessionId) {
        issuesServices.insertIssues1(issues, sessionId);
    }

    @PostMapping("/importedAzure/{ids}")
    public void insertIssuesAzure(@PathVariable Integer ids) {

    }


    @PostMapping(value = "/upload/{sessionId}", consumes = {"multipart/form-data"})
    public Integer uploadIssues(@RequestPart("file") MultipartFile file, @PathVariable String sessionId) throws IOException {
        return issuesServices.uploadIssues(file,sessionId);
    }

    @GetMapping("/{id}")
    public Issues getIssuesById(@PathVariable String id) {
        return issuesServices.getIssuesById(id);
    }
    @GetMapping("/{sessionId}/issues/total")
    public ResponseEntity<Long> countUsersInSession(@PathVariable String sessionId) {
        long userCount = issuesServices.countIsuuesInSession(sessionId);
        return ResponseEntity.ok(userCount);
    }




}
