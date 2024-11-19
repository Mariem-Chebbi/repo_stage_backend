package lean.toc.manajerobackend.repositories.safe_repositories;

import lean.toc.manajerobackend.models.safe_models.Demo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IDemoRepository extends MongoRepository<Demo, String> {

}
