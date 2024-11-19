package lean.toc.manajerobackend.repositories.pokerPlanning_grp2_repositories;

import lean.toc.manajerobackend.models.pokerPlanning_grp2_models.Session;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionRepository  extends MongoRepository<Session, String> {
    // Méthode personnalisée pour compter les utilisateurs dans une session
}
