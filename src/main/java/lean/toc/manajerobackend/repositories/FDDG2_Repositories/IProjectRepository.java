package lean.toc.manajerobackend.repositories.FDDG2_Repositories;

import lean.toc.manajerobackend.models.FDDG2_Entities.Project;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProjectRepository extends MongoRepository<Project,String> {
    Project findProjectByCodeProject(String CODE);
    List<Project> findProjectByWorkSpaceCodeWS(String id);
}
