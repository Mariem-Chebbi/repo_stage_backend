package lean.toc.manajerobackend.repositories.safe_repositories;

import lean.toc.manajerobackend.models.safe_models.Project;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IProjetRepository extends MongoRepository<Project,String> {
}
