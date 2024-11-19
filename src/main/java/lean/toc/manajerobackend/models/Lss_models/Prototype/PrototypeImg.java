package lean.toc.manajerobackend.models.Lss_models.Prototype;


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
@Document(collection ="prototypeImg")
@ToString
public class PrototypeImg implements Serializable {
    @Id
    private String id;

    private String imageUrl;

    @JsonIgnore
    @DBRef
    private Prototype prototype;

}
