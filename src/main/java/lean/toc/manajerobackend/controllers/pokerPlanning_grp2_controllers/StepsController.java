package lean.toc.manajerobackend.controllers.pokerPlanning_grp2_controllers;


import lean.toc.manajerobackend.models.pokerPlanning_grp2_models.Steps;
import lean.toc.manajerobackend.services.pokerPlanning_grp2_services.StepService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class StepsController {

       StepService stepService;


    @PostMapping("/addSteps")
    Steps addSteps(@RequestBody Steps steps) {
        return  stepService.addSteps(steps);
    }


    @GetMapping("/getSteps")
    List<Steps> getSteps(){
        return stepService.getAllSteps();
    }

    @GetMapping("/getSteps/{id}")
    public Steps getStepById(@PathVariable String id) {
        return stepService.getStepById(id);
    }

    @PutMapping("/updateStep/{id}")
    public Steps updateStep(@PathVariable String id, @RequestBody Steps steps) {
        return stepService.updateStep(steps, id);

    }

    @DeleteMapping("/deleteStep/{id}")
    void deleteStep(@PathVariable String id) {
        stepService.deleteStep(id);
    }


}
