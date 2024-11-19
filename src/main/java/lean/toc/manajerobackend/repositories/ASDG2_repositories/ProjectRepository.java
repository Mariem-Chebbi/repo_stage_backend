package lean.toc.manajerobackend.repositories.ASDG2_repositories;

import lean.toc.manajerobackend.models.ASDG2_models.Project;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends MongoRepository<Project, String> {
    long countByStatus(String status);
}
