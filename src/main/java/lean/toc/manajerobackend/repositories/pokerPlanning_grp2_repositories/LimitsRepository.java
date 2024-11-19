package lean.toc.manajerobackend.repositories.pokerPlanning_grp2_repositories;

import lean.toc.manajerobackend.models.pokerPlanning_grp2_models.Limits;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LimitsRepository  extends MongoRepository<Limits, String> {
}