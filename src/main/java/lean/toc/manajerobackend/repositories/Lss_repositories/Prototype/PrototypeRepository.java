package lean.toc.manajerobackend.repositories.Lss_repositories.Prototype;

import lean.toc.manajerobackend.models.Lss_models.Prototype.Prototype;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface PrototypeRepository extends MongoRepository<Prototype,String> {
    List<Prototype> findByIdprojectAndArchive(String projectCharterId, Boolean t);
    long countByIdprojectAndArchive(String idproject, Boolean archive);
}
