package lean.toc.manajerobackend.controllers.FDDG2_Controllers;

import lean.toc.manajerobackend.models.FDDG2_Entities.Status;
import lean.toc.manajerobackend.repositories.FDDG2_Repositories.FeatureRepo;
import lean.toc.manajerobackend.repositories.FDDG2_Repositories.ITasksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kpis")
public class KpiController {

    @Autowired
    private FeatureRepo featureRepo;
    @Autowired
    private ITasksRepository iTasksRepository;

    @GetMapping("/completion-rate")
    public double getFeatureCompletionRate() {
        long totalTasks = iTasksRepository.count();
        long completedTasks = iTasksRepository.countByStatus(Status.Completed);
        long notCompletedTasks = iTasksRepository.countByStatus(Status.NotCompleted);
        long TodoTasks = iTasksRepository.countByStatus(Status.ToDo);
        long pendingTasks= iTasksRepository.countByStatus(Status.Pending);
        if (totalTasks == 0) return 0;

        return (double) completedTasks / totalTasks * 100;
    }
}
