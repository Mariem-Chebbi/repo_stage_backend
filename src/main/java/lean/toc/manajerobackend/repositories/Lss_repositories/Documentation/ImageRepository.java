package lean.toc.manajerobackend.repositories.Lss_repositories.Documentation;

import lean.toc.manajerobackend.models.Lss_models.Image;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface ImageRepository extends MongoRepository<Image,String> {
    List<Image> findByDocumentationIddocu(String iddocu);

}
