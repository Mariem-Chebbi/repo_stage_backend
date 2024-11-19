package lean.toc.manajerobackend.services.safe_services.ServicesImp;

import lean.toc.manajerobackend.models.safe_models.Sprint;
import lean.toc.manajerobackend.models.safe_models.UserStory;
import lean.toc.manajerobackend.repositories.safe_repositories.ISprintRepository;
import lean.toc.manajerobackend.repositories.safe_repositories.IUserStoryRepository;
import lean.toc.manajerobackend.services.safe_services.IServices.ISprintService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class SprintServicesImpl implements ISprintService {

    @Autowired
    private final ISprintRepository sprintRepository;

    @Autowired
    private final IUserStoryRepository userStoryRepository;
    @Override
    public Sprint createSprint(Sprint sprint) {
        if (sprint == null) {
            throw new IllegalArgumentException("Sprint cannot be null");
        }

        List<UserStory> userStories = sprint.getUserStory() != null ?
                sprint.getUserStory().stream()
                        .map(userStory -> {
                            if (userStory == null || userStory.getId() == null) {
                                return null;
                            }
                            return userStoryRepository.findById(userStory.getId()).orElseThrow(() ->
                                    new IllegalArgumentException("UserStory with ID " + userStory.getId() + " not found"));
                        })
                        .filter(Objects::nonNull)
                        .collect(Collectors.toList())
                : Collections.emptyList();

        sprint.setUserStory(userStories);
        return sprintRepository.save(sprint);
    }


    @Override
    public List<Sprint> createSprint(List<Sprint> sprints) {
        return null;
    }


    @Override
    public Sprint getSprintById(String id) {
        return sprintRepository.findById(id).orElse(null);
    }

    @Override
    public List<Sprint> getAllSprints() {
        return sprintRepository.findAll();
    }

    @Override
    public Sprint updateSprint(String id, Sprint newSprintData) {
        // Check if the sprint exists
        Sprint existingSprint = sprintRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Sprint not found with id: " + id));

        // Update fields if provided
        if (newSprintData.getName() != null) {
            existingSprint.setName(newSprintData.getName());
        }
        if (newSprintData.getGoal() != null) {
            existingSprint.setGoal(newSprintData.getGoal());
        }
        if (newSprintData.getStartDate() != null) {
            existingSprint.setStartDate(newSprintData.getStartDate());
        }
        if (newSprintData.getEndDate() != null) {
            existingSprint.setEndDate(newSprintData.getEndDate());
        }
        if (newSprintData.getUserStory() != null) {
            List<UserStory> userStories = newSprintData.getUserStory().stream()
                    .map(userStory -> {
                        if (userStory.getId() != null) {
                            return userStoryRepository.findById(userStory.getId()).orElse(null);
                        }
                        return null;
                    })
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList());
            existingSprint.setUserStory(userStories);
        }

        // Save and return the updated Sprint
        return sprintRepository.save(existingSprint);
    }



    @Override
    public void deleteSprint(String id) {
        sprintRepository.deleteById(id);
    }

    public Map<String, Integer> getSprintStats() {
        long totalSprints = sprintRepository.count(); // Count all sprints
        Map<String, Integer> stats = new HashMap<>();
        stats.put("Total Sprints", (int) totalSprints); // Add total sprints to the stats map
        return stats;
    }

}