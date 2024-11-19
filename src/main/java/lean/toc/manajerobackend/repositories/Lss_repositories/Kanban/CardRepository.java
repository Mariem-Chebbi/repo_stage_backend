package lean.toc.manajerobackend.repositories.Lss_repositories.Kanban;

import lean.toc.manajerobackend.models.Lss_models.Kanbanboard.Card;
import lean.toc.manajerobackend.models.Lss_models.Kanbanboard.Status;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface CardRepository extends MongoRepository<Card,String> {

    List<Card> findCardsByKanbanIdkanbanAndStatus(String kanbanId, Status statusCard);

    List<Card> findCardsByKanbanIdkanban(String kanbanId);
    List<Card> findByKanbanIdkanban(String kanbanId); // Method to find cards by Kanban ID



}
