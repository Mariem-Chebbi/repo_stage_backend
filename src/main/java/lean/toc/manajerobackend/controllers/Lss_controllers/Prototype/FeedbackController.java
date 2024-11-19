package lean.toc.manajerobackend.controllers.Lss_controllers.Prototype;

import lean.toc.manajerobackend.models.Lss_models.Prototype.Feedback;
import lean.toc.manajerobackend.services.Lss_services.Prototype.FeedbackServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/feedback")
@AllArgsConstructor
public class FeedbackController {

    @Autowired
    FeedbackServiceImpl feedbackService;

    @PostMapping("/add/{prototypeId}/{userId}")
    public Feedback addFeedback(@PathVariable String prototypeId, @PathVariable String userId, @RequestBody Feedback feedback) {
        return feedbackService.addFeedback(prototypeId, userId, feedback);
    }

    @GetMapping("/Get/{prototypeId}")
    public List<Feedback> getFeedbackByPrototypeId(@PathVariable String prototypeId) {
        return feedbackService.getFeedbackByPrototypeId(prototypeId);
    }





}
