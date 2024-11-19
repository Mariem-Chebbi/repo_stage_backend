package lean.toc.manajerobackend.controllers.safe_controllers;

import lean.toc.manajerobackend.models.safe_models.Sprint;
import lean.toc.manajerobackend.services.safe_services.IServices.ISprintService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/sprints")
@Slf4j
@RequiredArgsConstructor

public class SprintController {

    @Autowired
    private ISprintService sprintService;

    @PostMapping
    public ResponseEntity<Sprint> createSprint(@RequestBody Sprint sprint) {
        Sprint savedSprint = sprintService.createSprint(sprint);
        return ResponseEntity.ok(savedSprint);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sprint> getSprintById(@PathVariable String id) {
        Sprint sprint = sprintService.getSprintById(id);
        return sprint != null ? ResponseEntity.ok(sprint) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<Sprint>> getAllSprints() {
        List<Sprint> sprints = sprintService.getAllSprints();
        return ResponseEntity.ok(sprints);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Sprint> updateSprint(@PathVariable("id") String id, @RequestBody Sprint sprint) {
        try {
            Sprint updatedSprint = sprintService.updateSprint(id, sprint);
            return ResponseEntity.ok(updatedSprint);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSprint(@PathVariable String id) {
        sprintService.deleteSprint(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/stats")
    public Map<String, Integer> getSprintStats() {
        return sprintService.getSprintStats();
    }

}