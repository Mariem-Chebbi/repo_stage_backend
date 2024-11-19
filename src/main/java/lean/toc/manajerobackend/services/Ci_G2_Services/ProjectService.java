package lean.toc.manajerobackend.services.Ci_G2_Services;



import lean.toc.manajerobackend.models.CI_g2.model.Project;
import lean.toc.manajerobackend.repositories.Ci_G2_repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("ciG2ProjectService")
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    // GET all projects
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    // GET project by ID
    public Optional<Project> getProjectById(String id) {
        return projectRepository.findById(id);
    }

    // POST create a new project
    public Project createProject(Project project) {

        return projectRepository.save(project);
    }

    // PUT update an existing project
    public Project updateProject(String id, Project project) {
        if (projectRepository.existsById(id)) {
            project.setId(id);
            project.setGitUrl(project.getGitUrl());
            return projectRepository.save(project);
        } else {
            return null;
        }
    }

    // DELETE a project
    public void deleteProject(String id) {
        projectRepository.deleteById(id);
    }
}
