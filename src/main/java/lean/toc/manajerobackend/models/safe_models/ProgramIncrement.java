package lean.toc.manajerobackend.models.safe_models;

import lean.toc.manajerobackend.models.safe_models.Sprint;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Data
@Document(collection = "programIncrements")
public class ProgramIncrement {
    @Id
    private String id;

    private String name; // E.g., Q1 2024
    private Date startDate;
    private Date endDate;
    private String objectives; // Objectives for the PI

    @DBRef
    private List<Sprint> sprints;

}
