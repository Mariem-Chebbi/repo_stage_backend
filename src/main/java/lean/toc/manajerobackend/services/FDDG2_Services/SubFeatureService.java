package lean.toc.manajerobackend.services.FDDG2_Services;

import lean.toc.manajerobackend.models.FDDG2_Entities.Feature;
import lean.toc.manajerobackend.models.FDDG2_Entities.Status;
import lean.toc.manajerobackend.models.FDDG2_Entities.Tasks;
import lean.toc.manajerobackend.repositories.FDDG2_Repositories.FeatureRepo;
import lean.toc.manajerobackend.repositories.FDDG2_Repositories.ITasksRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class SubFeatureService implements ISubFeatureService{

    @Autowired
    ITasksRepository subFeatureRepo;
    @Autowired
    FeatureRepo featureRepo;

    public Tasks addSubFeature(Tasks subFeature, String featureId) {
        // Ensure feature exists and is saved
        Feature feature = featureRepo.findFeatureById(featureId);
        if (feature == null) {
            throw new RuntimeException("Feature not found");
        }
        subFeature.setCreatedAt(LocalDate.now());
        subFeature.setStatus(Status.ToDo);
        // Set the feature for the subFeature
        subFeature.setFeature(feature);

        // Save subFeature and return
        return subFeatureRepo.save(subFeature);
    }
    @Override
    public Tasks updateSubFeature(Tasks subFeature) {
        return subFeatureRepo.save(subFeature);
    }

    @Override
    public Tasks retreiveSubFeature(String id) {
        return subFeatureRepo.findById(id).orElse(null);
    }

    @Override
    public void deleteSubFeature(String id) {
        subFeatureRepo.deleteById(id);
    }

    @Override
    public List<Tasks> retreiveSubFeatures() {
        return subFeatureRepo.findAll();
    }

    @Override
    public List<Tasks> retreiveSubFeaturebyFeatureId(String id) {
        return subFeatureRepo.findByFeatureId(id);
    }
}
