package lean.toc.manajerobackend.controllers.pokerPlanning_grp2_controllers;

import lean.toc.manajerobackend.models.pokerPlanning_grp2_models.Benefits;
import lean.toc.manajerobackend.services.pokerPlanning_grp2_services.BenefitsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class BenefitsController {

     BenefitsService benefitsService;

    @PostMapping("/addBenefits")
    Benefits addBenefits(@RequestBody Benefits benefits) {
        return  benefitsService.addBenefits(benefits);
    }


    @GetMapping("/getBenefits")
    List<Benefits> getBenefits(){
        return benefitsService.getAllBenefits();
    }

    @GetMapping("/getBenefits/{id}")
    public Benefits getBenefitById(@PathVariable String id) {
        return benefitsService.getBenefitById(id);
    }

    @DeleteMapping("/deletebenefit/{id}")
    public void deletebenefit(@PathVariable String id) {
        benefitsService.deleteBenefit(id);
    }

    @PutMapping("/updateBenefit/{id}")
    public Benefits updateBenefit(@PathVariable String id, @RequestBody Benefits benefit) {
        return benefitsService.updateBenefit(benefit, id);

    }

}
