package lean.toc.manajerobackend.repositories.ASDG2_repositories;

import lean.toc.manajerobackend.models.ASDG2_models.Feedback;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("ASDFeedback")
public interface FeedbackRepository extends MongoRepository <Feedback, String>{
    long countByProjectId(String projectId);

    List<Feedback> findByProjectId(String projectId);
}
