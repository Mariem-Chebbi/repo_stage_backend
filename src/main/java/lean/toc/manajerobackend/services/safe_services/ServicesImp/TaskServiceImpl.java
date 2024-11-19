package lean.toc.manajerobackend.services.safe_services.ServicesImp;

import lean.toc.manajerobackend.models.safe_models.Task;
import lean.toc.manajerobackend.models.safe_models.TaskStatus;
import lean.toc.manajerobackend.repositories.safe_repositories.ITaskRepository;
import lean.toc.manajerobackend.services.safe_services.IServices.ITaskService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class TaskServiceImpl implements ITaskService {
    private final ITaskRepository taskRepository;

    @Override
    public Task createTask(Task task) {
        log.info("Creating task: {}", task);
        return taskRepository.save(task);
    }

    @Override
    public Optional<Task> getTaskById(String id) {
        log.info("Fetching task with ID: {}", id);
        return taskRepository.findById(id);
    }

    @Override
    public List<Task> getAllTasks() {
        log.info("Fetching all tasks");
        return taskRepository.findAll();
    }

    @Override
    public Task updateTask(String id, Task task) {
        log.info("Updating task with ID: {}", id);
        if (taskRepository.existsById(id)) {
            task.set_id(id);
            return taskRepository.save(task);
        } else {
            log.error("Task with ID: {} not found", id);
            return null; // Or throw an exception
        }
    }

    @Override
    public void deleteTask(String id) {
        log.info("Deleting task with ID: {}", id);
        taskRepository.deleteById(id);
    }

    @Override
    public Map<TaskStatus, Long> calculateTaskStats() {
        log.info("Calculating task statistics");
        List<Task> tasks = taskRepository.findAll(); // Retrieve all tasks
        Map<TaskStatus, Long> statusCounts = new HashMap<>();

        for (TaskStatus status : TaskStatus.values()) {
            long count = tasks.stream()
                    .filter(task -> task.getStatus() == status)
                    .count();
            statusCounts.put(status, count);
        }

        return statusCounts;
    }
    public Map<String, Integer> getTaskStats() {
        long totaltasks = taskRepository.count(); // Count all sprints
        Map<String, Integer> stats = new HashMap<>();
        stats.put("Total Tasks", (int) totaltasks); // Add total sprints to the stats map
        return stats;
    }
}
