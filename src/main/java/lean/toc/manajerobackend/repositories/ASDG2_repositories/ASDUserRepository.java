package lean.toc.manajerobackend.repositories.ASDG2_repositories;

import lean.toc.manajerobackend.models.ASDG2_models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ASDUserRepository extends MongoRepository<User, String> {

}
