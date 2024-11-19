package lean.toc.manajerobackend.models.Lss_models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
@Builder

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Data
@Document(collection = "images")
@ToString(exclude = "documentation") // Exclude the reference to Documentation
public class Image implements Serializable {
    @Id
    private String id;
    private String url;


    @DBRef
    @JsonIgnore
    private Documentation documentation;
    // Manually added constructor
    public Image(String id, String url) {
        this.id = id;
        this.url = url;
    }


}
