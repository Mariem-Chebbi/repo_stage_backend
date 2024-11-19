package lean.toc.manajerobackend.repositories.ASDG2_repositories;

import lean.toc.manajerobackend.models.ASDG2_models.Introduction;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IntroductionRepository extends MongoRepository<Introduction, String> {}
