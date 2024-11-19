package lean.toc.manajerobackend.repositories.safe_repositories;

import lean.toc.manajerobackend.models.safe_models.UserStory;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IUserStoryRepository extends MongoRepository<UserStory,String> {
}
