package lean.toc.manajerobackend.models.safe_models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@Data
@Document(collection = "agileReleaseTrains")
public class AgileReleaseTrain {
    @Id
    private String id;

    private String name; // Name of the ART
    private String description; // Description of the ART
    @DBRef
    private List<ProgramIncrement> programIncrements; // List of Program Increments this ART is involved in
    @DBRef
    private List<Sprint> sprints; // List of Sprints associated with this ART
}
