package lean.toc.manajerobackend.services.Lss_services.Prototype;

import lean.toc.manajerobackend.models.Lss_models.Prototype.Feedback;
import lean.toc.manajerobackend.models.Lss_models.Prototype.Prototype;
import lean.toc.manajerobackend.models.Lss_models.User;
import lean.toc.manajerobackend.repositories.Lss_repositories.Prototype.FeedbackRepository;
import lean.toc.manajerobackend.repositories.Lss_repositories.Prototype.PrototypeRepository;
import lean.toc.manajerobackend.repositories.Lss_repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@AllArgsConstructor
public class FeedbackServiceImpl {
    @Autowired
    FeedbackRepository feedbackRepository;
    @Autowired
    PrototypeRepository prototypeRepository;
    @Autowired
    UserRepository userRepository;
    public Feedback addFeedback(String idprototype, String userId, Feedback feedback) {
        Optional<Prototype> optionalPrototype = prototypeRepository.findById(idprototype);
        User user=userRepository.findById(userId).orElse(null);
        if (optionalPrototype.isPresent()) {
            Prototype prototype = optionalPrototype.get();
            List<Feedback> feedbacks = prototype.getFeedbacks();
            if (feedbacks == null) {
                feedbacks = new ArrayList<>();
                prototype.setFeedbacks(feedbacks);

            }
            feedback.setPrototype(prototype);
            feedback.setDate_add(new Date());
            feedback.setUser(user);
            feedbacks.add(feedback);

            if (feedback.getId() == null || feedback.getId().isEmpty()) {
                feedback.setId(UUID.randomUUID().toString());
            }

            prototypeRepository.save(prototype);
            return feedbackRepository.save(feedback);
        } else {
            throw new NoSuchElementException("prot not found with id: " + idprototype);
        }
    }

    public List<Feedback> getFeedbackByPrototypeId(String prototypeId) {
        return feedbackRepository.findByPrototypeId(prototypeId);
    }




}
