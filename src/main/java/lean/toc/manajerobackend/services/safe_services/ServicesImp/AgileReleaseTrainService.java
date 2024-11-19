package lean.toc.manajerobackend.services.safe_services.ServicesImp;


import lean.toc.manajerobackend.models.safe_models.AgileReleaseTrain;
import lean.toc.manajerobackend.models.safe_models.ProgramIncrement;
import lean.toc.manajerobackend.models.safe_models.Sprint;
import lean.toc.manajerobackend.repositories.safe_repositories.IAgileReleaseTrainRepository;
import lean.toc.manajerobackend.repositories.safe_repositories.IProgramIncrementRepository;
import lean.toc.manajerobackend.repositories.safe_repositories.ISprintRepository;
import lean.toc.manajerobackend.services.safe_services.IServices.IAgileReleaseTrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AgileReleaseTrainService implements IAgileReleaseTrainService {

    @Autowired
    private IAgileReleaseTrainRepository agileReleaseTrainRepository;

    @Autowired
    private IProgramIncrementRepository programIncrementRepository;

    @Autowired
    private ISprintRepository sprintRepository;

    @Override
    public AgileReleaseTrain createOrUpdateAgileReleaseTrain(AgileReleaseTrain agileReleaseTrain) {
        // Resolve ProgramIncrement references
        List<ProgramIncrement> resolvedPIs = agileReleaseTrain.getProgramIncrements().stream()
                .map(pi -> programIncrementRepository.findById(pi.getId()).orElse(null))
                .collect(Collectors.toList());

        // Resolve Sprint references
        List<Sprint> resolvedSprints = agileReleaseTrain.getSprints().stream()
                .map(sprint -> sprintRepository.findById(sprint.getId()).orElse(null))
                .collect(Collectors.toList());

        // Set resolved references back to AgileReleaseTrain
        agileReleaseTrain.setProgramIncrements(resolvedPIs);
        agileReleaseTrain.setSprints(resolvedSprints);

        return agileReleaseTrainRepository.save(agileReleaseTrain);
    }

    @Override
    public Optional<AgileReleaseTrain> getAgileReleaseTrainById(String id) {
        return agileReleaseTrainRepository.findById(id);
    }

    @Override
    public List<AgileReleaseTrain> getAllAgileReleaseTrains() {
        return agileReleaseTrainRepository.findAll();
    }

    @Override
    public void deleteAgileReleaseTrainById(String id) {
        agileReleaseTrainRepository.deleteById(id);
    }
}