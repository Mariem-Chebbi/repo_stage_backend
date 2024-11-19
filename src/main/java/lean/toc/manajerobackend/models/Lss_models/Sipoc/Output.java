package lean.toc.manajerobackend.models.Lss_models.Sipoc;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Data
@Document(collection ="output")
@ToString
public class Output implements Serializable {
    @Id
    String id_output;
    String name;

}
