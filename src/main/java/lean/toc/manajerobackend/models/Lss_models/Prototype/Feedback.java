package lean.toc.manajerobackend.models.Lss_models.Prototype;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lean.toc.manajerobackend.models.Lss_models.User;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Data
@Document(collection ="feedback")
@ToString(exclude = {"prototype", "user"})  // Avoid recursion
public class Feedback implements Serializable {
    @Id
    private String id;
    private String content;
    private Date date_add;
    @JsonIgnore
    @DBRef
    private Prototype prototype;
    @JsonIgnore
    @DBRef
    private User user;

}
