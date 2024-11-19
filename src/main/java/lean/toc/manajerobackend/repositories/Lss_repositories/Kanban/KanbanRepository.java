package lean.toc.manajerobackend.repositories.Lss_repositories.Kanban;


import lean.toc.manajerobackend.models.Lss_models.Kanbanboard.Kanban;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KanbanRepository extends MongoRepository<Kanban,String> {
    @Query("{ 'id_project': ?0 }")
    List<Kanban> findById_project(String projectCharterId);


}
