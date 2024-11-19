package lean.toc.manajerobackend.controllers.FDDG2_Controllers;

import lean.toc.manajerobackend.models.FDDG2_Entities.Tasks;
import lean.toc.manajerobackend.services.FDDG2_Services.SubFeatureService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/subFeature")  // Adjusted endpoint for clarity and specificity
public class SubFeatureController {
     SubFeatureService subFeatureService;

    @PostMapping("/add/{featureId}")
    public Tasks addSubFeature(@RequestBody Tasks subFeature, @PathVariable String featureId){
        return subFeatureService.addSubFeature(subFeature,featureId);
    }

    @GetMapping("/get/{id}")
    public Tasks retrieveSubFeature(@PathVariable String id){
        return subFeatureService.retreiveSubFeature(id);
    }

    @PutMapping("/update")
    public Tasks updateSubFeature(@RequestBody Tasks subFeature){
        return subFeatureService.updateSubFeature(subFeature);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteSubFeature(@PathVariable String id){
        subFeatureService.deleteSubFeature(id);
    }

    @GetMapping("/get")
    public List<Tasks> retrieveSubFeatures(){
        return subFeatureService.retreiveSubFeatures();
    }

    @GetMapping("/subFeatures/byFeature/{featureId}")
    public List<Tasks> retrieveSubFeatureByFeatureId(@PathVariable String featureId) {
        return subFeatureService.retreiveSubFeaturebyFeatureId(featureId);
    }
}

