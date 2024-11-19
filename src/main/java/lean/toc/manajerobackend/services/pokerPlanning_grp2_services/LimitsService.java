package lean.toc.manajerobackend.services.pokerPlanning_grp2_services;


import jakarta.persistence.EntityNotFoundException;
import lean.toc.manajerobackend.models.pokerPlanning_grp2_models.Limits;
import lean.toc.manajerobackend.repositories.pokerPlanning_grp2_repositories.LimitsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LimitsService {
    LimitsRepository limitsRepository;
    public Limits addLimits(Limits limits) {
        return limitsRepository.save(limits);
    }

    public List<Limits> getAllLimits() {
        return limitsRepository.findAll();
    }

    public Limits getLimitById(String id) {
        return limitsRepository.findById(id).orElse(null);
    }

    public void deleteLimits(String id) {
        limitsRepository.deleteById(id);
    }

    public Limits updateLimit(Limits limits, String id) {
        Limits existingLimit = limitsRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Entity with id " + id + " not found"));
        existingLimit.setLimitDescription(limits.getLimitDescription());
        existingLimit.setTitle(limits.getTitle());
        return limitsRepository.save(existingLimit);
    }
}
