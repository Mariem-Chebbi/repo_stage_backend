package lean.toc.manajerobackend.models.Lss_models.FMEA;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Data
@Document(collection ="failuremode")
@ToString
public class FailureMode implements Serializable {
    @Id
    private String id;
    private String title;
    private String description;
    private int severity;
    private int occurrence;
    private int detection;
    private int rpn;
    private  Boolean archive;

    @DBRef
    private List<ActionItem> actionItems;

    @JsonIgnore
    @DBRef
    private Fmea fmea;

    public FailureMode(String id, String title, List<ActionItem> actionItems) {
        this.id = id;
        this.title = title;
        this.actionItems = actionItems;
    }

    public FailureMode(String fmId1) {
    }


    public int getRpn() {
        return severity * occurrence * detection;
    }
}
