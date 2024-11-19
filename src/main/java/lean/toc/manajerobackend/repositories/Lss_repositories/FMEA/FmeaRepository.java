package lean.toc.manajerobackend.repositories.Lss_repositories.FMEA;

import lean.toc.manajerobackend.models.Lss_models.FMEA.Fmea;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FmeaRepository extends MongoRepository<Fmea,String> {
    List<Fmea> findByProjectCharterId(String projectCharterId);
    List<Fmea> findByProjectCharterIdAndArchive(String id,Boolean t);
    long countByProjectCharterIdAndArchive(String projectCharterId, Boolean archive);

}
