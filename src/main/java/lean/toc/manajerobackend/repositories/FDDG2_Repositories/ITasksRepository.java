package lean.toc.manajerobackend.repositories.FDDG2_Repositories;

import lean.toc.manajerobackend.models.FDDG2_Entities.Status;
import lean.toc.manajerobackend.models.FDDG2_Entities.Tasks;
import lean.toc.manajerobackend.models.FDDG2_Entities.Tasks;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITasksRepository extends MongoRepository<Tasks, String> {
    Tasks findTasksByTaskId(String taskId);
    List<Tasks> findTasksByUserId(String user);
    List<Tasks> findTasksByStatus(Status status);
    List<Tasks> findByFeatureId(String id);
    long countByStatus(Status status);
}
