package lean.toc.manajerobackend.services.FDDG2_Services;

import lean.toc.manajerobackend.models.FDDG2_Entities.Project;
import lean.toc.manajerobackend.models.FDDG2_Entities.User;
import lean.toc.manajerobackend.models.FDDG2_Entities.Feature;
import lean.toc.manajerobackend.repositories.FDDG2_Repositories.FeatureRepo;
import lean.toc.manajerobackend.repositories.FDDG2_Repositories.IProjectRepository;
import lean.toc.manajerobackend.repositories.FDDG2_Repositories.ITasksRepository;
import lean.toc.manajerobackend.repositories.FDDG2_Repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("FeatureServiceFDDG2")
@AllArgsConstructor
@NoArgsConstructor
public class FeatureService implements IFeatureService{

    @Autowired
    FeatureRepo featureRepo;
    @Autowired
    ITasksRepository subFeatureRepo;
    @Autowired
    UserRepository userRepo;
    @Autowired
    IProjectRepository iProjectRepository;
    @Override
    public Feature addFeature(Feature feature, String id) {
        Project project = iProjectRepository.findProjectByCodeProject(id);
        feature.setProject(project);
        return featureRepo.save(feature);
    }

    @Override
    public Feature updateFeature(Feature feature) {
        return featureRepo.save(feature);
    }

    @Override
    public Feature retreiveFeature(String id) {
        return featureRepo.findFeatureById(id);
    }

    @Override
    public void deleteFeature(String id) {
         featureRepo.deleteById(id);
    }

    @Override
    public List<Feature> retreiveFeatures() {
        return featureRepo.findAll();
    }

    @Override
    public User addUser(User user) {
        return userRepo.save(user); }
    @Override
    public List<User> getUsers() {
        return userRepo.findAll(); }

    @Override
    public List<Feature> getProjectFeatures(String id) {
        return featureRepo.findFeatureByProjectCodeProject(id);
    }

}
