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
@Document(collection ="supplier")
@ToString
public class Supplier implements Serializable {
    @Id
    String id_supplier;
    String name;

}
