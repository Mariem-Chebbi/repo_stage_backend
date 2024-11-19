package lean.toc.manajerobackend.repositories.Ci_G2_repository;

import lean.toc.manajerobackend.models.CI_g2.model.Project;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("CI_G2_ProjectRepository")
public interface ProjectRepository extends MongoRepository<Project, String> {
    Optional<Project> findByGitUrl(String gitUrl);
}
