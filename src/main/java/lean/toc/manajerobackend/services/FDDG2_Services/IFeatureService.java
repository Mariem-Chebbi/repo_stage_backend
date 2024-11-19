package lean.toc.manajerobackend.services.FDDG2_Services;

import lean.toc.manajerobackend.models.FDDG2_Entities.Feature;
import lean.toc.manajerobackend.models.FDDG2_Entities.User;

import java.util.List;

public interface IFeatureService {
    public Feature addFeature(Feature feature,String id);
    public Feature updateFeature(Feature feature);
    public Feature retreiveFeature(String id);
    public void deleteFeature(String id);
    List<Feature> retreiveFeatures();
    User addUser(User user);
    public List<User> getUsers();
    public List<Feature> getProjectFeatures(String id);
}
