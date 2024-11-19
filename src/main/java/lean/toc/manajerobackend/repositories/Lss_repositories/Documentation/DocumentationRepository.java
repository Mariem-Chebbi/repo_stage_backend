package lean.toc.manajerobackend.repositories.Lss_repositories.Documentation;

import lean.toc.manajerobackend.models.Lss_models.Documentation;
import lean.toc.manajerobackend.models.Lss_models.Image;
import lean.toc.manajerobackend.models.Lss_models.Section;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DocumentationRepository extends MongoRepository<Documentation,String> {

    Documentation findBySectiondocu(Section section);
    Optional<Documentation> findByImagesContaining(Image image);
}
