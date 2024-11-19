package lean.toc.manajerobackend.repositories.safe_repositories;

import lean.toc.manajerobackend.models.safe_models.Sprint;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ISprintRepository extends MongoRepository<Sprint,String> {
}
