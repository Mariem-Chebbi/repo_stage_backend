package lean.toc.manajerobackend.models.Lss_models.Fivewhys;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Data
@Document(collection ="CategoryCount")
@ToString
public class CategoryCount implements Serializable {
    @Id
    private CategorieProblem _id;
    private long count;

    // Getters and setters
}

