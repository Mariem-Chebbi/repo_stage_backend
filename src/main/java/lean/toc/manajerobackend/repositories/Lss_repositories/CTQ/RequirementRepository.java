package lean.toc.manajerobackend.repositories.Lss_repositories.CTQ;

import lean.toc.manajerobackend.models.Lss_models.CTQ.Requirement;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RequirementRepository extends MongoRepository<Requirement,String> {
    List<Requirement> findByProjectid(String projectCharterId);

}
