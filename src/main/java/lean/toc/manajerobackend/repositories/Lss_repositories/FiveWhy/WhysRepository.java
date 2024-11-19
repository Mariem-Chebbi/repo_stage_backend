package lean.toc.manajerobackend.repositories.Lss_repositories.FiveWhy;

import lean.toc.manajerobackend.models.Lss_models.Fivewhys.Why;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WhysRepository extends MongoRepository<Why,String> {
}
