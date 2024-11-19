// ASDStepController.java

package lean.toc.manajerobackend.controllers.ASDG2_controller;


import lean.toc.manajerobackend.models.ASDG2_models.ASDStep;
import lean.toc.manajerobackend.services.ASDG2_services.ASDStepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/asd-steps")
public class ASDStepController {

    @Autowired
    private ASDStepService service;

    @GetMapping
    public List<ASDStep> getAllSteps() {
        return service.getAllSteps();
    }

    @PostMapping
    public ASDStep createStep(@RequestBody ASDStep step) {
        return service.createStep(step);
    }

    @PutMapping("/{id}")
    public ASDStep updateStep(@PathVariable String id, @RequestBody ASDStep step) {
        return service.updateStep(id, step);
    }

    @DeleteMapping("/{id}")
    public void deleteStep(@PathVariable String id) {
        service.deleteStep(id);
    }
}
