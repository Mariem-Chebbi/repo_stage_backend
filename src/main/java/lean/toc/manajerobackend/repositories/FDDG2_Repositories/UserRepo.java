package lean.toc.manajerobackend.repositories.FDDG2_Repositories;

import lean.toc.manajerobackend.models.FDDG2_Entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends MongoRepository<User, String> {
}