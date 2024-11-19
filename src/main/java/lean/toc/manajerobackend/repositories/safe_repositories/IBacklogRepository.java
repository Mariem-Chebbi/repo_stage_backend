package lean.toc.manajerobackend.repositories.safe_repositories;

import lean.toc.manajerobackend.models.safe_models.Backlog;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface IBacklogRepository extends MongoRepository<Backlog,String> {
  Optional<Backlog> findById(String id);
}
