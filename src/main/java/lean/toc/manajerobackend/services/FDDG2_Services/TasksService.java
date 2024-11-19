package lean.toc.manajerobackend.services.FDDG2_Services;

import lean.toc.manajerobackend.models.FDDG2_Entities.Tasks;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface TasksService {
    public List<Tasks> getAllTasks();
    public Tasks AddTasks(Tasks tasks);
    public Tasks EditTasks(Tasks tasks, String codeTasks);
    public String deleteTasks(String taskId);
    public Tasks getOneTasks(String taskId);
    public List<Tasks> getUserTasks(String id);
    public List<Tasks> getPendingTasks();
    public String saveFile(String taskId, MultipartFile file) throws IOException;
    public void confirmStatus(String id);
    public void rejectStatus (String id);
    public Resource loadFileAsResource(String fileName);
    public Tasks updateTasksRating(Tasks tasks, String codeTasks);

}

