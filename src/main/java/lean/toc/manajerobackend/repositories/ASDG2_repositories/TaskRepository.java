package lean.toc.manajerobackend.repositories.ASDG2_repositories;

import lean.toc.manajerobackend.models.ASDG2_models.Task;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends MongoRepository <Task, String> {
    long countByProjectId(String projectId);
    long countByStatus(String status);

    List<Task> findByProjectId(String projectId);

    long countByProjectIdAndStatus(String projectId, String status);
}
