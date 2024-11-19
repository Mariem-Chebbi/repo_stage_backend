package lean.toc.manajerobackend.repositories.Lss_repositories.CTQ;

import lean.toc.manajerobackend.models.Lss_models.CTQ.Ctq;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CtqRepository extends MongoRepository<Ctq,String> {
    List<Ctq> findByRequirementId(String id);
}
