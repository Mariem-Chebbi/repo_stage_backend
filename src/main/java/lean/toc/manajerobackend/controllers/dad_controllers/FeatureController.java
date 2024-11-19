package lean.toc.manajerobackend.controllers.dad_controllers;


import lean.toc.manajerobackend.dto.dad_dto.StatusPercentage;
import lean.toc.manajerobackend.models.dad_models.Feature;
import lean.toc.manajerobackend.services.dad_services.IFeatureService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("FeatureControllerDad")
@AllArgsConstructor
@RequestMapping("/dad/features")
public class FeatureController {
    private IFeatureService iFeatureService;

    @GetMapping("/getAll/{id}")
    public List<Feature> getAllFeatures(@PathVariable String id){
        return iFeatureService.getAllFeatures(id);
    }

    @PostMapping("/add")
    public Feature addFeature (@RequestBody Feature feature,@RequestParam String idProject){
        return iFeatureService.addFeature(feature,idProject);
    }

    @PutMapping ("/edit")
    public Feature editFeature (@RequestBody Feature feature){
        return iFeatureService.editFeature(feature);
    }

    @DeleteMapping  ("/delete/{id}")
    public void deleteFeature (@PathVariable String id){
        iFeatureService.deleteFeature(id);
    }

    @GetMapping("/get/release/{id}")
    public List<Feature> getFeaturesByRelease(@PathVariable String id){
        return iFeatureService.getFeaturesByRelease(id);
    }

    @GetMapping("/status-percentages/{projectId}")
    public List<StatusPercentage> getStatusPercentages(@PathVariable String projectId) {
        return iFeatureService.calculateStatusPercentages(projectId);
    }

    @PutMapping ("/assign/{iterationId}")
    public void assignFeaturesToIteration (@RequestBody List<Feature> features,@PathVariable String iterationId){
         iFeatureService.assignFeaturesToIteration(features,iterationId);
    }

    @PutMapping ("/Unassign")
    public void UnassignFeaturesToIteration (@RequestBody Feature feature){
        iFeatureService.UnassignFeaturesToIteration(feature);
    }

    @GetMapping("/get/iteration/{id}")
    public List<Feature> getFeaturesByIteration(@PathVariable String id){
        return iFeatureService.getFeaturesByIteration(id);
    }

    @PutMapping("/archive/{id}")
    public void archive(@PathVariable String id) {
        this.iFeatureService.archiveFeature(id);
    }

    @PutMapping("/restore/{id}")
    public void restore(@PathVariable String id) {
        this.iFeatureService.restoreFeature(id);
    }

}
