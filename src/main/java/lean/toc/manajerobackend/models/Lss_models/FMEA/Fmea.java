package lean.toc.manajerobackend.models.Lss_models.FMEA;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Data
@Document(collection ="fmea")
@ToString
public class Fmea implements Serializable {
    @Id
    private String id;
    private String title;
    private String description;
    private String projectCharterId;
    private Date createdDate;
    private Date updatedDate;
    private Boolean archive;
    @DBRef
    private List<FailureMode> failureModes;

    public Fmea(String id, String projectCharterId, String title, List<FailureMode> failureModes, boolean archive) {
        this.id = id;
        this.projectCharterId = projectCharterId;
        this.title = title;
        this.failureModes = failureModes;
        this.archive = archive;
    }
}
