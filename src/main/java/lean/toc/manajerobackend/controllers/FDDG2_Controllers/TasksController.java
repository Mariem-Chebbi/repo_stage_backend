package lean.toc.manajerobackend.controllers.FDDG2_Controllers;

import lean.toc.manajerobackend.models.FDDG2_Entities.Tasks;
import lean.toc.manajerobackend.services.FDDG2_Services.TasksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TasksController {
    @Autowired
    TasksService tasksService;

    @PostMapping("/addTask")
    public Tasks createTask(@RequestBody Tasks task) {
        return tasksService.AddTasks(task);
    }


    @PutMapping("/updateRatings/{taskId}")
    public ResponseEntity<Tasks> updateTaskRatings(@PathVariable String taskId, @RequestBody Tasks task) {
        Tasks updatedTask = tasksService.updateTasksRating(task, taskId);
        return ResponseEntity.ok(updatedTask);
    }
    @GetMapping("/getAllTasks")
    public List<Tasks> getAllTasks() {
        return tasksService.getAllTasks();
    }

    @GetMapping("/getTask/{id}")
    public Tasks getOneTask(@PathVariable String id) {
        return tasksService.getOneTasks(id);
    }

    @DeleteMapping("/deleteTask/{id}")
    public String deleteTask(@PathVariable String id) {
        tasksService.deleteTasks(id);
        return "Task deleted successfully";
    }

    @PutMapping("/editTask/{id}")
    public Tasks editTask(@RequestBody Tasks task, @PathVariable String id) {
        return tasksService.EditTasks(task, id);
    }

    @GetMapping("/getUserTasks/{id}")
    public List<Tasks> getUserTasks(@PathVariable("id") String id) {
        return tasksService.getUserTasks(id);
    }

    @PostMapping("/upload/{taskId}")
    public ResponseEntity<String> uploadFile(@PathVariable("taskId") String taskId, @RequestParam("file") MultipartFile file) {
        try {
            tasksService.saveFile(taskId, file);
            return ResponseEntity.ok("File uploaded successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error uploading file");
        }
    }

    @GetMapping("/getPendingTasks")
    public List<Tasks> getPendingTasks() {
        return tasksService.getPendingTasks();
    }
    @PutMapping("/confirm/{id}")
    public ResponseEntity<Void> Confirme(@PathVariable("id") String id) {
        tasksService.confirmStatus(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/reject/{id}")
    public ResponseEntity<Void> Reject(@PathVariable("id") String id) {
        tasksService.rejectStatus(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/download/{fileName}")
    public ResponseEntity<Resource> downloadFile(@PathVariable("fileName") String fileName) {
        Resource resource = tasksService.loadFileAsResource(fileName);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }
}
