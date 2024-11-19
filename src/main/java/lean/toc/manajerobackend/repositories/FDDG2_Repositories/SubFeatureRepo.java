package lean.toc.manajerobackend.repositories.FDDG2_Repositories;

import lean.toc.manajerobackend.models.FDDG2_Entities.SubFeature;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubFeatureRepo extends MongoRepository<SubFeature,String> {
    List<SubFeature> findByFeatureId(String id);

}
