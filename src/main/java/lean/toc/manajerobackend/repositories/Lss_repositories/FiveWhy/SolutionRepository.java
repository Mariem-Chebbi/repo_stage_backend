package lean.toc.manajerobackend.repositories.Lss_repositories.FiveWhy;

import lean.toc.manajerobackend.models.Lss_models.Fivewhys.Solution;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SolutionRepository extends MongoRepository<Solution,String> {
}
