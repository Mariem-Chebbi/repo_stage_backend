package lean.toc.manajerobackend.services.Lss_services;

import lean.toc.manajerobackend.models.Lss_models.ProjectCharter;
import lean.toc.manajerobackend.repositories.Lss_repositories.ProjectcharterRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProjectcharterServiceImpl {
    @Autowired
    ProjectcharterRepository projectcharterRepository;
    public ProjectCharter addProject(ProjectCharter projectCharter) {
        return projectcharterRepository.save(projectCharter);
    }
    public List<ProjectCharter> getProjects() {
        return projectcharterRepository.findAll();
    }
}
