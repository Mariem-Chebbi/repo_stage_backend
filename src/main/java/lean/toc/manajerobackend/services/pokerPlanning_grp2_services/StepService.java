package lean.toc.manajerobackend.services.pokerPlanning_grp2_services;




import jakarta.persistence.EntityNotFoundException;
import lean.toc.manajerobackend.models.pokerPlanning_grp2_models.Steps;
import lean.toc.manajerobackend.repositories.pokerPlanning_grp2_repositories.StepRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StepService {

    StepRepository stepRepo;
    public Steps addSteps(Steps steps) {
        return stepRepo.save(steps);
    }

    public List<Steps> getAllSteps() {
        return stepRepo.findAll();
    }

    public Steps getStepById(String id) {
        return stepRepo.findById(id).orElse(null);
    }

    public Steps updateStep (Steps steps, String id) {
        Steps existingStep = stepRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Entity with id " + id + " not found"));
        existingStep.setTitle(steps.getTitle());
        existingStep.setStepDescription(steps.getStepDescription());
        return stepRepo.save(existingStep);
    }
    public void deleteStep(String id) {
        stepRepo.deleteById(id);
    }


}
