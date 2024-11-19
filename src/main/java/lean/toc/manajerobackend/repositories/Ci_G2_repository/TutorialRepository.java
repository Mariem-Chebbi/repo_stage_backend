package lean.toc.manajerobackend.repositories.Ci_G2_repository;

import lean.toc.manajerobackend.models.CI_g2.model.Tutorial;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TutorialRepository extends MongoRepository<Tutorial, String> {
}
