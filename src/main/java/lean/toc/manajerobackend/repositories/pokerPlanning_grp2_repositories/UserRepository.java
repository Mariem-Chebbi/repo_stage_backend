package lean.toc.manajerobackend.repositories.pokerPlanning_grp2_repositories;


import lean.toc.manajerobackend.models.pokerPlanning_grp2_models.Session;
import lean.toc.manajerobackend.models.pokerPlanning_grp2_models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("pokerPlanningUserRepository")
public interface UserRepository extends MongoRepository<User, String> {
    List<User> findBySession(Session session);
    User findByEmail(String email);
    // Méthode pour compter les utilisateurs d'une session donnée
    long countBySessionId(String sessionId);
}
