package lean.toc.manajerobackend.models.FDDG2_Entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "features")
public class Feature {
    @Id
    private String id; // Use String type for MongoDB ObjectIds
    private String name;
    private String description;
    private int progress;
    private Status state;
    @DBRef
    private List<Tasks> subFeatures;
    @DBRef
    private Project project;
}
