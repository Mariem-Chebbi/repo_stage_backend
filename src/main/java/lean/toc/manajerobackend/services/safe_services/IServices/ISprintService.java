package lean.toc.manajerobackend.services.safe_services.IServices;


import lean.toc.manajerobackend.models.safe_models.Sprint;

import java.util.List;
import java.util.Map;

public interface ISprintService {
    Sprint createSprint(Sprint sprint);
    List<Sprint> createSprint(List<Sprint> sprints);
    Sprint getSprintById(String id);
    List<Sprint> getAllSprints();
    Sprint updateSprint(String id, Sprint sprint);
    void deleteSprint(String id);

    Map<String, Integer> getSprintStats();

}
