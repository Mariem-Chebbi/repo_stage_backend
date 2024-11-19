package lean.toc.manajerobackend.repositories.Lss_repositories;

import lean.toc.manajerobackend.models.Lss_models.ProjectCharter;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectcharterRepository extends MongoRepository<ProjectCharter,String> {
}
