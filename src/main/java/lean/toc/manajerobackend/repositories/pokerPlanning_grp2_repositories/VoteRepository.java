package lean.toc.manajerobackend.repositories.pokerPlanning_grp2_repositories;

import lean.toc.manajerobackend.models.pokerPlanning_grp2_models.Vote;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VoteRepository extends MongoRepository<Vote, String> {
    List<Vote> findBySessionIdAndIssueId(String sessionId, String issueId);
    List<Vote> findByIssueId(String issueId);
    List<Vote> findBySessionId(String sessionId);


}
