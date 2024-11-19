package lean.toc.manajerobackend.models.Lss_models.Prototype;

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
@Document(collection ="prototype")
@ToString
public class Prototype implements Serializable {
    @Id
    private String id;
    private String idproject;
    private String name;
    private String description;
    private Date date_creation;
    private Date last_modif;
    private Boolean archive;


    @DBRef
    private List<PrototypeImg> images;

    @DBRef
    private List<Feedback> feedbacks;
}
