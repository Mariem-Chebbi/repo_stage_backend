package lean.toc.manajerobackend.models.Lss_models.CTQ;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Data
@Document(collection ="ctq")
@ToString
public class Ctq implements Serializable {
    @Id
    private String id;
    private String description;
    private boolean isMet;

    @JsonIgnore
    @DBRef
    private Requirement requirement;

    // Constructor for testing purposes
    public Ctq(String id, String description, boolean isMet) {
        this.id = id;
        this.description = description;
        this.isMet = isMet;
    }
}
