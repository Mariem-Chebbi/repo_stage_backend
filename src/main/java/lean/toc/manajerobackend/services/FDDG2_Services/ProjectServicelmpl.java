package lean.toc.manajerobackend.services.FDDG2_Services;

import lean.toc.manajerobackend.models.FDDG2_Entities.Project;
import lean.toc.manajerobackend.models.FDDG2_Entities.WorkSpace;
import lean.toc.manajerobackend.repositories.FDDG2_Repositories.IProjectRepository;
import lean.toc.manajerobackend.repositories.FDDG2_Repositories.IWorkSpaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service

public class ProjectServicelmpl implements ProjectService {
    @Autowired
    IProjectRepository iProjectRepository;
    @Autowired
    IWorkSpaceRepository iWorkSpaceRepository;

    @Override
    public List<Project> getAllProject() {
        return iProjectRepository.findAll() ;
    }

    @Override
    public Project AddProject(Project project) {
        return iProjectRepository.save(project);
    }

    @Override
    public Project EditProject(Project project, String codeProject) {
        Project newProject = iProjectRepository.findProjectByCodeProject(codeProject);
        newProject.setName(newProject.getName());
        newProject.setDescription(newProject.getDescription());
        newProject.setStartDate(newProject.getStartDate());
        newProject.setEndDate(newProject.getEndDate());
        return iProjectRepository.save(newProject);
    }

    @Override
    public void deleteProject(String codeProject) {

    }

    @Override
    public Project getOneProject(String codeProject) {
        return iProjectRepository.findProjectByCodeProject(codeProject);
    }

    @Override
    public Project addProjectToWorkspace(String id, Project project) {
        WorkSpace workspace = iWorkSpaceRepository.findWorkSpaceByCodeWS(id);
        project.setCreatedAt(LocalDate.now());
        project.setWorkSpace(workspace);

        return iProjectRepository.save(project);
    }

    @Override
    public List<Project> getWSProjects(String id) {

        return iProjectRepository.findProjectByWorkSpaceCodeWS(id);
    }


}