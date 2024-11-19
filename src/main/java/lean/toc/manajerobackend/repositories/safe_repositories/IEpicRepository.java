package lean.toc.manajerobackend.repositories.safe_repositories;

import lean.toc.manajerobackend.models.safe_models.Epic;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IEpicRepository extends MongoRepository<Epic,String> {
}
