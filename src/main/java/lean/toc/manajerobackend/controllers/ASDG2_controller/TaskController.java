package lean.toc.manajerobackend.controllers.ASDG2_controller;

import lean.toc.manajerobackend.models.ASDG2_models.Task;
import lean.toc.manajerobackend.services.ASDG2_services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

   /* @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }*/

    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable String id) {
        return taskService.getTask(id);
    }

    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return taskService.createTask(task);
    }

    @PutMapping("/{id}")
    public Task updateTask(@RequestBody Task task) {
        return taskService.updateTask(task);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable String id) {
        taskService.deleteTask(id);
    }

    @PutMapping("/{taskId}/assign-project/{projectId}")
    public Task assignTaskToProject(@PathVariable String taskId, @PathVariable String projectId) {
        return taskService.assignTaskToProject(taskId, projectId);
    }

    @PutMapping("/{id}/archive")
    public ResponseEntity<Task> archiveFeedback(@PathVariable String id) {
        Task task = taskService.getTask(id);
        if (task != null) {
            task.setArchived(true);
            taskService.updateTask(task);
            return ResponseEntity.ok(task);
        }
        return ResponseEntity.notFound().build();
    }
    @PutMapping("/{id}/restore")
    public ResponseEntity<Task> restoreFeedback(@PathVariable String id) {
        Task task = taskService.getTask(id);
        if (task != null && task.isArchived()) {
            task.setArchived(false);
            taskService.updateTask(task);
            return ResponseEntity.ok(task);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/archived")
    public List<Task> getAllArchivedFeedbacks() {
        return taskService.getAllArchivedTasks();
    }
}
