package lean.toc.manajerobackend.controllers.FDDG2_Controllers;

import lean.toc.manajerobackend.models.FDDG2_Entities.User;
import lean.toc.manajerobackend.models.FDDG2_Entities.Feature;
import lean.toc.manajerobackend.services.FDDG2_Services.FeatureService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController("FeatureControllerFDDG2")
@RequestMapping("/Feature")
public class FeatureController {
     FeatureService featureService;

    @PostMapping("/add/{id}")
    public Feature addFeature(@RequestBody Feature feature, @PathVariable("id") String id){
        return featureService.addFeature(feature,id);
    }
    @PostMapping("/adduser")
    public User addUser(@RequestBody User user){
        return featureService.addUser(user);
    }

    @GetMapping("/get/{id}")
    public Feature retrieveFeature(@PathVariable String id){
        return featureService.retreiveFeature(id);
    }

    @PutMapping("/update")
    public Feature updateFeature(@RequestBody Feature feature){
        return featureService.updateFeature(feature);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteFeature(@PathVariable String id){
        featureService.deleteFeature(id);
    }

    @GetMapping("/get")
    public List<Feature> retrieveFeatures(){
        return featureService.retreiveFeatures();
    }

    @GetMapping("/getuserrs")
    public List<User> retrieveUsers(){
        return featureService.getUsers();
    }
    @GetMapping("getProjectFeature/{id}")
    public List<Feature> fetchProjectFeatures(@PathVariable("id") String id){
        return featureService.getProjectFeatures(id);
    }

}
