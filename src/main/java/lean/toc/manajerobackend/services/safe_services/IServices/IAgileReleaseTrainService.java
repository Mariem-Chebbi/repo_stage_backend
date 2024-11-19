package lean.toc.manajerobackend.services.safe_services.IServices;


import lean.toc.manajerobackend.models.safe_models.AgileReleaseTrain;

import java.util.List;
import java.util.Optional;

public interface IAgileReleaseTrainService {
    AgileReleaseTrain createOrUpdateAgileReleaseTrain(AgileReleaseTrain agileReleaseTrain);
    Optional<AgileReleaseTrain> getAgileReleaseTrainById(String id);
    List<AgileReleaseTrain> getAllAgileReleaseTrains();
    void deleteAgileReleaseTrainById(String id);
}
