package lean.toc.manajerobackend.services.FDDG2_Services;

import lean.toc.manajerobackend.models.FDDG2_Entities.Project;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProjectService {
    public List<Project> getAllProject();
    public Project AddProject(Project project);
    public Project EditProject(Project project, String codeProject);
    public void deleteProject(String codeProject);
    public Project getOneProject(String codeProject);
    public Project addProjectToWorkspace(String id,Project project);
    public List<Project> getWSProjects(String id);
}
