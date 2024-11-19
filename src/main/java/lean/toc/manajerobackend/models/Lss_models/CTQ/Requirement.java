package lean.toc.manajerobackend.models.Lss_models.CTQ;

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
@Document(collection ="requirement")
@ToString
public class Requirement implements Serializable {
    @Id
    private String id;
    private String description;
    private String projectid;
    @DBRef
    private List<Ctq> ctqs;
    // Constructor for testing purposes

}
