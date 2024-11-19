package lean.toc.manajerobackend.repositories.dad_repositories;

import lean.toc.manajerobackend.models.dad_models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("dadUserRepository")
public interface UserRepository extends MongoRepository<User,String> {
    Optional<User> findUserByEmail(String email);
}
