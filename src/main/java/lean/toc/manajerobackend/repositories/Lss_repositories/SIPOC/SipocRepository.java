package lean.toc.manajerobackend.repositories.Lss_repositories.SIPOC;

import lean.toc.manajerobackend.models.Lss_models.Sipoc.Sipoc;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SipocRepository extends MongoRepository<Sipoc,String> {
    Optional<Sipoc> findByIdproject(String projectCharterId);


}
