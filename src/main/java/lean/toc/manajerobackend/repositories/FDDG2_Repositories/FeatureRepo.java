package lean.toc.manajerobackend.repositories.FDDG2_Repositories;

import lean.toc.manajerobackend.models.FDDG2_Entities.Status;
import lean.toc.manajerobackend.models.FDDG2_Entities.Feature;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeatureRepo extends MongoRepository<Feature,String> {
    Feature findFeatureById(String id);
    List<Feature> findFeatureByProjectCodeProject(String id);
    long countByState(Status status);
}
