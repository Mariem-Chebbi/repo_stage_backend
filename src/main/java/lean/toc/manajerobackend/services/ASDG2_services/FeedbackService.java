package lean.toc.manajerobackend.services.ASDG2_services;


import lean.toc.manajerobackend.models.ASDG2_models.Feedback;
import lean.toc.manajerobackend.models.ASDG2_models.Project;
import lean.toc.manajerobackend.repositories.ASDG2_repositories.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FeedbackService {
    @Autowired
    private FeedbackRepository feedbackRepository;
    @Autowired
    private lean.toc.manajerobackend.services.ASDG2_services.TaskService taskService;
    @Autowired
    private lean.toc.manajerobackend.services.ASDG2_services.UserService userService;
    @Autowired
    private lean.toc.manajerobackend.services.ASDG2_services.ProjectService projectService;
    public Feedback createFeedback(Feedback feedback) {
        return feedbackRepository.save(feedback);
    }

    public Feedback getFeedback(String id) {
        return feedbackRepository.findById(id).orElseThrow();
    }

   /* public List<Feedback> getAllFeedbacks() {
        return feedbackRepository.findAll();
    }*/

    public Feedback updateFeedback(Feedback feedback) {
        return feedbackRepository.save(feedback);
    }

    public void deleteFeedback(String id) {
        feedbackRepository.deleteById(id);
    }

    public Feedback assignFeedbackToProject(String feedbackId, String projectId) {
        Feedback feedback = getFeedback(feedbackId);
        Project project = projectService.getProjectById(projectId);
        feedback.setProject(project);
        return updateFeedback(feedback);
    }
    public List<Feedback> getAllFeedbacks() {
        return feedbackRepository.findAll().stream()
                .filter(feedback -> !feedback.isArchived())
                .collect(Collectors.toList());
    }
    public List<Feedback> getAllArchivedFeedbacks() {
        return feedbackRepository.findAll().stream()
                .filter(Feedback::isArchived)  // Only return feedbacks that are archived
                .collect(Collectors.toList());
    }


}
