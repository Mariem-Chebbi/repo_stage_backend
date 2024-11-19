package lean.toc.manajerobackend.repositories.pokerPlanning_grp2_repositories;

import lean.toc.manajerobackend.models.pokerPlanning_grp2_models.Issues;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IssuesRepository extends MongoRepository<Issues, String> {
    List<Issues> findBySessionId(String sessionId);
    long countBySessionId(String sessionId);
}
