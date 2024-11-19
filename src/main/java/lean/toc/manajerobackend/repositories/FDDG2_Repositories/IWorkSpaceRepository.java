package lean.toc.manajerobackend.repositories.FDDG2_Repositories;

import lean.toc.manajerobackend.models.FDDG2_Entities.WorkSpace;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IWorkSpaceRepository extends MongoRepository<WorkSpace,String> {
    public WorkSpace findWorkSpaceByCodeWS(String codeSW);
    public List<WorkSpace> findWorkSpaceByUserId(String id);
}
