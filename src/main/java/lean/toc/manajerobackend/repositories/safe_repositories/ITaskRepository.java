package lean.toc.manajerobackend.repositories.safe_repositories;


import lean.toc.manajerobackend.models.safe_models.Backlog;
import lean.toc.manajerobackend.models.safe_models.Task;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ITaskRepository extends MongoRepository<Task,String> {
  List<Task> findByBacklog(Backlog backlog);
}
