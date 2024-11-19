package lean.toc.manajerobackend.models.FDDG2_Entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DBRef;

@Data
@Document(collection = "sub-features")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SubFeature {
    @Id
    private String id; // MongoDB typically uses String for IDs
    private String name;
    private String description;

    @DBRef
    private Feature feature;
    @DBRef
    private User user;// Use DBRef for relationships in MongoDB
}
