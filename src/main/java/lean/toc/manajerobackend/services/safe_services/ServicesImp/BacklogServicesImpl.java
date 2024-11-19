package lean.toc.manajerobackend.services.safe_services.ServicesImp;

import lean.toc.manajerobackend.models.safe_models.Backlog;
import lean.toc.manajerobackend.models.safe_models.Sprint;
import lean.toc.manajerobackend.models.safe_models.Task;
import lean.toc.manajerobackend.repositories.safe_repositories.IBacklogRepository;
import lean.toc.manajerobackend.repositories.safe_repositories.ISprintRepository;
import lean.toc.manajerobackend.repositories.safe_repositories.ITaskRepository;
import lean.toc.manajerobackend.services.safe_services.IServices.IBacklogService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class BacklogServicesImpl implements IBacklogService {

  private final ITaskRepository taskRepository;
  private final IBacklogRepository backlogRepository;
  private final ISprintRepository sprintRepository;

  @Override
  @Transactional
  public Backlog addBacklog(Backlog backlog) {
    // Sauvegarder les tâches
    if(backlog.getProjectId()!=null){
      backlog.setProjectId(backlog.getProjectId());
    }
    List<Task> tasks = backlog.getTasks();
    if (tasks != null) {
      for (Task task : tasks) {
        if (task.get_id() == null) {

      taskRepository.save(task); // Sauvegarder la tâche pour obtenir un ID
        }

      }
    }

    // Sauvegarder les sprints
    List<Sprint> sprints = backlog.getSprints();
    if (sprints != null) {
      for (Sprint sprint : sprints) {
        if (sprint.getId() == null) {
         sprintRepository.save(sprint); // Sauvegarder le sprint pour obtenir un ID
        }
      }
    }

    // Associer les tâches et les sprints au backlog
    backlog.setTasks(tasks);
    backlog.setSprints(sprints);

    // Sauvegarder le backlog
    return backlogRepository.save(backlog);
  }


  public boolean isValidObjectId(String id) {
    try {
      return ObjectId.isValid(id);
    } catch (Exception e) {
      return false;
    }
  }
  @Override
  @Transactional
  public Backlog updateBacklog(Backlog updatedBacklog) {
    Optional<Backlog> backlogOptional = backlogRepository.findById(updatedBacklog.get_id());
    if (backlogOptional.isPresent()) {
      Backlog backlog = backlogOptional.get();
      backlog.setProjectId(updatedBacklog.getProjectId());

      // Mettre à jour les tâches associées
      for (Task updatedTask : updatedBacklog.getTasks()) {
        Optional<Task> taskOptional = taskRepository.findById(updatedTask.get_id());
        if (taskOptional.isPresent()) {
          Task existingTask = taskOptional.get();
          existingTask.setTitle(updatedTask.getTitle());
          existingTask.setDescription(updatedTask.getDescription());
          existingTask.setStatus(updatedTask.getStatus());
          existingTask.setStartDate(updatedTask.getStartDate());
          existingTask.setEndDate(updatedTask.getEndDate());
          existingTask.setAssignee(updatedTask.getAssignee());
          taskRepository.save(existingTask);
        } else {
          taskRepository.save(updatedTask);
        }
      }

      backlog.setTasks(updatedBacklog.getTasks());
      backlog.setSprints(updatedBacklog.getSprints());
      return backlogRepository.save(backlog);
    } else {
      throw new RuntimeException("Backlog not found with id " + updatedBacklog.get_id());
    }
  }


  @Override
  @Transactional
  public Backlog getBacklogById(String id) {
    Optional<Backlog> backlogOptional = backlogRepository.findById(isValidObjectId(id) ? id : null);
    if (backlogOptional.isPresent()) {
      Backlog backlog = backlogOptional.get();

      // Eagerly fetch associated tasks
      List<Task> tasks = taskRepository.findByBacklog(backlog);
      backlog.setTasks(tasks);

      return backlog;
    } else {
      throw new EmptyResultDataAccessException("Backlog not found with id " + id, 1);
    }
  }

  @Override
  public void deleteBacklog(String id) {

  }

  @Override
  public List<Backlog> AllBacklog() {
    return null;
  }



}
