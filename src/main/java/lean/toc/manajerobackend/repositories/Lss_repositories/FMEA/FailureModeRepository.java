package lean.toc.manajerobackend.repositories.Lss_repositories.FMEA;

import lean.toc.manajerobackend.models.Lss_models.FMEA.FailureMode;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FailureModeRepository extends MongoRepository<FailureMode,String> {
    List<FailureMode> findByFmea_Id(String id);
    List<FailureMode> findByFmea_IdAndArchive(String id,Boolean t);
}
