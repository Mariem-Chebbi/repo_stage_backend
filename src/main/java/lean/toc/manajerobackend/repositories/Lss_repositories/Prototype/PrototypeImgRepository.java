package lean.toc.manajerobackend.repositories.Lss_repositories.Prototype;

import lean.toc.manajerobackend.models.Lss_models.Prototype.PrototypeImg;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface PrototypeImgRepository extends MongoRepository<PrototypeImg,String> {
   List<PrototypeImg> findByPrototypeId(String idprototype);
}
