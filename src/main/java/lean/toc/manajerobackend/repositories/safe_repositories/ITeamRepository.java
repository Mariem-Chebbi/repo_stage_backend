package lean.toc.manajerobackend.repositories.safe_repositories;

import lean.toc.manajerobackend.models.safe_models.Team;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ITeamRepository extends MongoRepository<Team,String> {
}
