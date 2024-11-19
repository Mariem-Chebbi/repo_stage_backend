package lean.toc.manajerobackend.services.FDDG2_Services;

import lean.toc.manajerobackend.models.FDDG2_Entities.Tasks;

import java.util.List;

public interface ISubFeatureService {
    public Tasks addSubFeature(Tasks subFeature, String featureId);
    public Tasks updateSubFeature(Tasks subFeature);
    public Tasks retreiveSubFeature(String id);
    public void deleteSubFeature(String id);
    List<Tasks> retreiveSubFeatures();
    public List<Tasks> retreiveSubFeaturebyFeatureId(String id);
}
