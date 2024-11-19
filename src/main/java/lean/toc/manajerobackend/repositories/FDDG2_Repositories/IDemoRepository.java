package lean.toc.manajerobackend.repositories.FDDG2_Repositories;

import lean.toc.manajerobackend.models.FDDG2_Entities.Demo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository("IDemoRepositoryFDDG2")
public interface IDemoRepository extends MongoRepository<Demo,String> {
    Demo findDemoByCodeDemo(String id);
}
