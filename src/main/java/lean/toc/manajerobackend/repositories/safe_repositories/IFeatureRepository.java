package lean.toc.manajerobackend.repositories.safe_repositories;

import lean.toc.manajerobackend.models.safe_models.Feature;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IFeatureRepository extends MongoRepository<Feature, String> {
}
