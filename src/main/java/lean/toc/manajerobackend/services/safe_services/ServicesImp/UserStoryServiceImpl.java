package lean.toc.manajerobackend.services.safe_services.ServicesImp;

import lean.toc.manajerobackend.models.safe_models.Task;
import lean.toc.manajerobackend.models.safe_models.UserStory;
import lean.toc.manajerobackend.repositories.safe_repositories.ITaskRepository;
import lean.toc.manajerobackend.repositories.safe_repositories.IUserStoryRepository;
import lean.toc.manajerobackend.services.safe_services.IServices.IUserStoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserStoryServiceImpl implements IUserStoryService {

    @Autowired
    private IUserStoryRepository userStoryRepository;

    @Autowired
    private ITaskRepository taskRepository;
    @Override
    public UserStory createUserStory(UserStory userStory) {
        if (userStory == null) {
            throw new IllegalArgumentException("UserStory cannot be null");
        }

        // Handle the tasks, allowing null tasks or missing tasks
        List<Task> tasks = userStory.getTasks() != null ?
                userStory.getTasks().stream()
                        .map(task -> {
                            if (task == null || task.get_id() == null) {
                                return null;
                            }
                            // Fetch the existing task from the repository by its ID
                            return taskRepository.findById(task.get_id()).orElse(null);
                        })
                        .filter(Objects::nonNull) // Only keep tasks that exist
                        .collect(Collectors.toList())
                : Collections.emptyList(); // Default to an empty list if tasks are null

        // Set the valid tasks in the UserStory
        userStory.setTasks(tasks);

        // Save the UserStory to the repository
        return userStoryRepository.save(userStory);
    }

    @Override
    public List<UserStory> createUserStories(List<UserStory> userStories) {
        for (UserStory userStory : userStories) {
            createUserStory(userStory);
        }
        return userStories;
    }

    @Override
    public UserStory getUserStoryById(String id) {
        return userStoryRepository.findById(id).orElse(null);
    }


    @Override
    public List<UserStory> getAllUserStories() {
        return userStoryRepository.findAll();
    }

    @Override
    public UserStory updateUserStory(String id, UserStory userStory) {
        if (userStoryRepository.existsById(id)) {
            userStory.setId(id);
            return userStoryRepository.save(userStory);
        } else {
            return null;
        }
    }

    @Override
    public void deleteUserStory(String id) {
        userStoryRepository.deleteById(id);
    }

    public Map<String, Integer> getuscout() {
        long totalus = userStoryRepository.count(); // Count all sprints
        Map<String, Integer> stats = new HashMap<>();
        stats.put("Total US", (int) totalus); // Add total sprints to the stats map
        return stats;
    }

}
