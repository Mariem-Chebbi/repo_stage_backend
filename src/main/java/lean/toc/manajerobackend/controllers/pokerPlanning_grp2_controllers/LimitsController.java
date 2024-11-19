package lean.toc.manajerobackend.controllers.pokerPlanning_grp2_controllers;


import lean.toc.manajerobackend.models.pokerPlanning_grp2_models.Limits;
import lean.toc.manajerobackend.services.pokerPlanning_grp2_services.LimitsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class LimitsController {
    LimitsService limitsService;


    @PostMapping("/addLimits")
    Limits addLimits(@RequestBody Limits limits) {
        return  limitsService.addLimits(limits);
    }


    @GetMapping("/getLimits")
    List<Limits> getLimits(){
        return limitsService.getAllLimits();
    }

    @GetMapping("/getLimits/{id}")
    public Limits getLimitById(@PathVariable String id) {
        return limitsService.getLimitById(id);
    }

    @DeleteMapping("/deletelimit/{id}")
    public void deletelimit(@PathVariable String id ){
        limitsService.deleteLimits(id);
    }

    @PutMapping("/updateLimit/{id}")
    public Limits updateBenefit(@PathVariable String id, @RequestBody Limits limit) {
        return limitsService.updateLimit(limit, id);

    }
}
