package lean.toc.manajerobackend.repositories.safe_repositories;

import lean.toc.manajerobackend.models.safe_models.AgileReleaseTrain;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IAgileReleaseTrainRepository extends MongoRepository<AgileReleaseTrain, String> {
}
