package lean.toc.manajerobackend.repositories.safe_repositories;

import lean.toc.manajerobackend.models.safe_models.ProgramIncrement;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IProgramIncrementRepository extends MongoRepository<ProgramIncrement,String> {
}
