package lean.toc.manajerobackend.services.pokerPlanning_grp2_services;


import jakarta.persistence.EntityNotFoundException;
import lean.toc.manajerobackend.models.pokerPlanning_grp2_models.Benefits;
import lean.toc.manajerobackend.repositories.pokerPlanning_grp2_repositories.BenefitsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BenefitsService {

    BenefitsRepository benefitsRepository;
    public Benefits addBenefits(Benefits benefits) {
        return benefitsRepository.save(benefits);
    }

    public List<Benefits> getAllBenefits() {
        return benefitsRepository.findAll();
    }

    public Benefits getBenefitById(String id) {
        return benefitsRepository.findById(id).orElse(null);
    }

    public void deleteBenefit(String id) {
        benefitsRepository.deleteById(id);
    }


    public Benefits updateBenefit(Benefits benefits, String id) {
        Benefits existingBenefit = benefitsRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Entity with id " + id + " not found"));
        existingBenefit.setBenefDescription(benefits.getBenefDescription());
        existingBenefit.setTitle(benefits.getTitle());
        return benefitsRepository.save(existingBenefit);
    }

}
