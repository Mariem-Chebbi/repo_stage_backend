package lean.toc.manajerobackend.services.Lss_services.FMEA;

import lean.toc.manajerobackend.models.Lss_models.FMEA.ActionItem;
import lean.toc.manajerobackend.models.Lss_models.FMEA.FailureMode;
import lean.toc.manajerobackend.models.Lss_models.FMEA.Fmea;
import lean.toc.manajerobackend.repositories.Lss_repositories.FMEA.ActionItemRepository;
import lean.toc.manajerobackend.repositories.Lss_repositories.FMEA.FailureModeRepository;
import lean.toc.manajerobackend.repositories.Lss_repositories.FMEA.FmeaRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@AllArgsConstructor
public class FmeaServiceImpl {
    @Autowired
    private FmeaRepository fmeaRepository;
    @Autowired
    FailureModeRepository failureModeRepository;

    @Autowired
    ActionItemRepository actionItemRepository;
    public Fmea createFmea(Fmea fmea, String projectCharterId) {
        fmea.setProjectCharterId(projectCharterId);
        fmea.setId(null);
        fmea.setArchive(false);
        fmea.setCreatedDate(new Date());
        fmea.setFailureModes(new ArrayList<>());
        return fmeaRepository.save(fmea);
    }



    public List<Fmea> getFmeasByProjectCharterId(String projectCharterId) {
        return fmeaRepository.findByProjectCharterIdAndArchive(projectCharterId,false);
    }
    public List<Fmea> getarchivedFmeas(String projectCharterId) {
        return fmeaRepository.findByProjectCharterIdAndArchive(projectCharterId,true);
    }


    public void deleteFmea(String id) {
        Fmea fmea = fmeaRepository.findById(id).orElse(null);
        if (fmea != null) {
            for (FailureMode fm : fmea.getFailureModes()) {
                for (ActionItem ai : fm.getActionItems()) {
                    actionItemRepository.deleteById(ai.getId());
                }
                failureModeRepository.deleteById(fm.getId());
            }
            fmeaRepository.deleteById(fmea.getId());
        }
    }
    public Fmea updateFmea(Fmea updatedFmea) {

        Fmea existingFmea = fmeaRepository.findById(updatedFmea.getId()).orElse(null);

        if (existingFmea != null) {
            existingFmea.setTitle(updatedFmea.getTitle());
            existingFmea.setUpdatedDate(new Date());
            existingFmea.setDescription(updatedFmea.getDescription());
            return fmeaRepository.save(existingFmea);
        } else {
            throw new RuntimeException("not found with ID: " + updatedFmea.getId());
        }
    }
    public Map<String, Map<String, Long>> countActionItemsPerFailureMode(String projectCharterId) {
        List<Fmea> fmeas = fmeaRepository.findByProjectCharterIdAndArchive(projectCharterId,false);

        Map<String, Map<String, Long>> actionItemsCount = new HashMap<>();

        for (Fmea fmea : fmeas) {
            if (fmea.getFailureModes() != null) {
                for (FailureMode failureMode : fmea.getFailureModes()) {
                    String failureModeId = failureMode.getId();
                    String name = failureMode.getTitle();
                    long count = failureMode.getActionItems().stream()
                            .filter(actionItem -> actionItem.getArchive() == null || !actionItem.getArchive())
                            .count();

                    actionItemsCount.computeIfAbsent(fmea.getId(), k -> new HashMap<>())
                            .put(name, count);
                }
            }
        }

        return actionItemsCount;
    }


    public Fmea archiveFMEA(String id) {
        Optional<Fmea> FmeaOptional = fmeaRepository.findById(id);

            Fmea existingFmea = FmeaOptional.get();

            existingFmea.setArchive(true);

                for (FailureMode fm : existingFmea.getFailureModes()) {
                    for (ActionItem ai : fm.getActionItems()) {
                        ai.setArchive(true);
                        actionItemRepository.save(ai);
                    }
                        fm.setArchive(true);
                    failureModeRepository.save(fm);
                }

                return fmeaRepository.save(existingFmea);
        }
    public Fmea unarchiveFMEA(String id) {
        Optional<Fmea> FmeaOptional = fmeaRepository.findById(id);
        Fmea existingFmea = FmeaOptional.get();
        existingFmea.setArchive(false);

        for (FailureMode fm : existingFmea.getFailureModes()) {
            for (ActionItem ai : fm.getActionItems()) {
                ai.setArchive(false);
                actionItemRepository.save(ai);
            }
            fm.setArchive(false);
            failureModeRepository.save(fm);
        }

        return fmeaRepository.save(existingFmea);
    }



}
