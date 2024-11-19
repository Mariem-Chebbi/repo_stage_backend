package lean.toc.manajerobackend.models.Lss_models.FMEA;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Data
@Document(collection ="actionitem")
@ToString
public class ActionItem implements Serializable {
    @Id
    private String id;
    private String title;
    private String description;
    private Date dueDate;
    private Date completionDate;
    private Status_Action status;
    //for archive
    private Boolean archive;
    @JsonIgnore
    @DBRef
    private FailureMode failureMode;

    public ActionItem(String id, Boolean archive) {
        this.id = id;
        this.archive = archive;
    }
}
