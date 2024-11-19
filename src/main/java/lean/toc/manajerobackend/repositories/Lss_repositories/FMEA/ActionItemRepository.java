package lean.toc.manajerobackend.repositories.Lss_repositories.FMEA;

import lean.toc.manajerobackend.models.Lss_models.FMEA.ActionItem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActionItemRepository extends MongoRepository<ActionItem,String> {
    List<ActionItem> findByFailureModeIdAndArchive(String id,Boolean t);

}
