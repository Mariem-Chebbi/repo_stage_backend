package lean.toc.manajerobackend.services.FDDG2_Services;

import lean.toc.manajerobackend.models.FDDG2_Entities.Status;
import lean.toc.manajerobackend.models.FDDG2_Entities.Tasks;
import lean.toc.manajerobackend.repositories.FDDG2_Repositories.ITasksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class TasksServiceImpl implements TasksService{
    @Autowired
    ITasksRepository iTasksRepository;
    @Override
    public List<Tasks> getAllTasks() {
        return iTasksRepository.findAll();
    }

    @Override
    public Tasks AddTasks(Tasks tasks) {
        tasks.setCreatedAt(LocalDate.now());
        return iTasksRepository.save(tasks);
    }

    @Override
    public Tasks EditTasks(Tasks tasks, String taskId) {
        System.out.println("Incoming Task: " + tasks);

        // Fetch the existing task from the database
        Tasks existingTask = iTasksRepository.findTasksByTaskId(taskId);

        if (existingTask == null) {
            throw new IllegalArgumentException("Task with ID " + taskId + " not found");
        }

        // Preserve the old values if new values are not provided
        if (tasks.getTaskName() != null) {
            existingTask.setTaskName(tasks.getTaskName());
        }
        if (tasks.getDescription() != null) {
            existingTask.setDescription(tasks.getDescription());
        }
        if (tasks.getDeadline() != null) {
            existingTask.setDeadline(tasks.getDeadline());
        }
        if (tasks.getStatus() != null) {
            existingTask.setStatus(tasks.getStatus());
        }
        // Preserve the old user if the new user is not provided
        if (tasks.getUser() != null) {
            existingTask.setUser(tasks.getUser());
        } else {
            System.out.println("User is null in the incoming task data, preserving old user.");
        }

        System.out.println("Existing Task after update: " + existingTask);

        return iTasksRepository.save(existingTask);
    }



    @Override
    public String deleteTasks(String codeTasks) {
        iTasksRepository.deleteById(codeTasks);
        return "task deleted successfully";
    }

    @Override
    public Tasks getOneTasks(String codeTasks) {
        return iTasksRepository.findTasksByTaskId(codeTasks);
    }

    @Override
    public List<Tasks> getUserTasks(String id) {

        return iTasksRepository.findTasksByUserId(id);
    }

    @Override
    public List<Tasks> getPendingTasks() {
        return iTasksRepository.findTasksByStatus(Status.Pending);
    }

    @Override
    public String saveFile(String taskId, MultipartFile file) throws IOException {
        Tasks task = iTasksRepository.findById(taskId).orElseThrow(() -> new RuntimeException("Task not found"));

        // Generate a unique file name
        String originalFileName = file.getOriginalFilename();
        String uniqueFileName = UUID.randomUUID().toString() + "_" + originalFileName;

        // Define the directory to save files
        Path uploadDir = Paths.get("uploads/assignments");
        if (!Files.exists(uploadDir)) {
            Files.createDirectories(uploadDir);
        }

        // Define the full file path
        Path filePath = uploadDir.resolve(uniqueFileName);

        // Save the file to the directory
        Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

        // Update the task with file information
        task.setAssignment(originalFileName);
        task.setAssignemntUrl(uniqueFileName);
        task.setStatus(Status.Pending);
        iTasksRepository.save(task);

        return uniqueFileName;
    }

    @Override
    public Resource loadFileAsResource(String fileName) {
        try {
            Path filePath = Paths.get("uploads/assignments").resolve(fileName).normalize();
            Resource resource = new UrlResource(filePath.toUri());

            if (resource.exists()) {
                return resource;
            } else {
                throw new RuntimeException("File not found: " + fileName);
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("File not found: " + fileName, e);
        }
    }

    @Override
    public Tasks updateTasksRating(Tasks tasks, String codeTasks) {
        // Fetch the existing task from the database
        Tasks existingTask = iTasksRepository.findTasksByTaskId(codeTasks);

        if (existingTask == null) {
            throw new IllegalArgumentException("Task with ID " + codeTasks + " not found");
        }

        // Update ratings if new values are provided
        if (tasks.getResponsivity() != null) {
            existingTask.setResponsivity(tasks.getResponsivity());
        }
        if (tasks.getErgonomics() != null) {
            existingTask.setErgonomics(tasks.getErgonomics());
        }
        if (tasks.getDeadlineC() != null) {
            existingTask.setDeadlineC(tasks.getDeadlineC());
        }
        if (tasks.getDescriptionC() != null) {
            existingTask.setDescriptionC(tasks.getDescriptionC());
        }
        if (tasks.getTechUse() != null) {
            existingTask.setTechUse(tasks.getTechUse());
        }

        return iTasksRepository.save(existingTask);
    }


    @Override
    public void confirmStatus(String id) {
        Tasks task = iTasksRepository.findTasksByTaskId(id);

        task.setStatus(Status.Completed);
        iTasksRepository.save(task);
    }
    @Override
    public void rejectStatus(String id) {
        Tasks task = iTasksRepository.findTasksByTaskId(id);

        task.setStatus(Status.NotCompleted);
        iTasksRepository.save(task);
    }


}
