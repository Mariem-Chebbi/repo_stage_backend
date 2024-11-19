package lean.toc.manajerobackend.models.Lss_models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Data
@Document(collection ="projectcharter")
@ToString
public class ProjectCharter implements Serializable {
    @Id
    String id;
    String title;
}
