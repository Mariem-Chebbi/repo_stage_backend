package lean.toc.manajerobackend.models.FDDG2_Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "tasks")
public class Tasks {
    @Id
    private String taskId;
    private String taskName;
    private String Description;
    private LocalDate createdAt;
    private LocalDate deadline;
    private Status status;
    private String Assignment;
    private String AssignemntUrl;
    private Integer Responsivity;
    private Integer Ergonomics;
    private Integer DeadlineC;
    private Integer DescriptionC;
    private Integer TechUse;

    @DBRef
    private User user;
    @JsonIgnore
    @DBRef
    private Feature feature;

}
