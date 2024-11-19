package lean.toc.manajerobackend.services.ASDG2_services;


import lean.toc.manajerobackend.models.ASDG2_models.Project;
import lean.toc.manajerobackend.models.ASDG2_models.Task;
import lean.toc.manajerobackend.repositories.ASDG2_repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    public Project createProject(Project project) {
        return projectRepository.save(project);
    }

  /*  public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }*/

    public Project getProjectById(String id) {
        return projectRepository.findById(id).orElse(null);
    }

    public void deleteProject(String id) {
        projectRepository.deleteById(id);
    }

    public Project addTaskToProject(String projectId, Task task) {
        Project project = getProjectById(projectId);
        List<Task> tasks = project.getTasks();
        if (tasks == null) {
            tasks = new ArrayList<>();
        }
        tasks.add(task);
        project.setTasks(tasks);
        return projectRepository.save(project);  // Utilisation directe de save pour enregistrer les changements
    }

    public Project updateProject(Project project) {
        return projectRepository.save(project);
    }

    public List<Project> getAllProjects() {
        return projectRepository.findAll().stream()
                .filter(feedback -> !feedback.isArchived())
                .collect(Collectors.toList());
    }
    public List<Project> getAllArchivedProjects() {
        return projectRepository.findAll().stream()
                .filter(Project::isArchived)  // Only return feedbacks that are archived
                .collect(Collectors.toList());
    }


}
