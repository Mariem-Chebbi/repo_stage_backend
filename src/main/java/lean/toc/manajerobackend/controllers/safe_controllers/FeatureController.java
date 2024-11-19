package lean.toc.manajerobackend.controllers.safe_controllers;
import lean.toc.manajerobackend.models.safe_models.Feature;
import lean.toc.manajerobackend.services.safe_services.ServicesImp.FeatureService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/feature")
@RequiredArgsConstructor
@Slf4j
public class FeatureController {
    private final FeatureService featureService;

    @GetMapping
    public ResponseEntity<List<Feature>> getAllFeatures() {
        List<Feature> features = featureService.getAllFeatures();
        return new ResponseEntity<>(features, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Feature> getFeatureById(@PathVariable("id") String id) {
        Optional<Feature> feature = featureService.getFeatureById(id);
        return feature.map(ResponseEntity::ok)
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Feature> createOrUpdateFeature(@RequestBody Feature feature) {
        try {
            Feature savedFeature = featureService.createOrUpdateFeature(feature);
            return new ResponseEntity<>(savedFeature, HttpStatus.CREATED);
        } catch (ResourceNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFeature(@PathVariable("id") String id) {
        featureService.deleteFeature(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/count")
    public Map<String, Integer> getfeaturescount() {
        return featureService.getfeaturescount();
    }
}
