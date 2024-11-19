package lean.toc.manajerobackend.repositories.Lss_repositories.Prototype;

import lean.toc.manajerobackend.models.Lss_models.Prototype.Feedback;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeedbackRepository extends MongoRepository<Feedback,String> {
    List<Feedback> findByPrototypeId(String protoypeId);
}
