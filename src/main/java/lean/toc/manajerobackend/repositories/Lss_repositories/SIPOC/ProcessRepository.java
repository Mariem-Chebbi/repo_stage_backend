package lean.toc.manajerobackend.repositories.Lss_repositories.SIPOC;

import lean.toc.manajerobackend.models.Lss_models.Sipoc.Processsipoc;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProcessRepository extends MongoRepository<Processsipoc,String> {
}
