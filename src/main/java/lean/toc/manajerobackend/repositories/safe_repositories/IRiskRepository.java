package lean.toc.manajerobackend.repositories.safe_repositories;

import lean.toc.manajerobackend.models.safe_models.Risk;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IRiskRepository extends MongoRepository<Risk,String> {
}
