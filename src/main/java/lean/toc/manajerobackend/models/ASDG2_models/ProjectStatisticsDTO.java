package lean.toc.manajerobackend.models.ASDG2_models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProjectStatisticsDTO {
    private String projectId;
    private String name;
    private long numberOfTasks;
    private long numberOfFeedbacks;
    private double averageRating;
    private double averageTaskCompletionTime;
    private double percentageOfCompletedTasks;
}
