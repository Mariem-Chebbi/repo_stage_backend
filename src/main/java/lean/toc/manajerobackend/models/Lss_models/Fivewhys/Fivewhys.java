package lean.toc.manajerobackend.models.Lss_models.Fivewhys;

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
@Document(collection ="fivewhys")
@ToString
public class Fivewhys implements Serializable {
    @Id
    String id_fivewhys ;
    String idproject;
    String problem_statement;
    String  root_cause_fivewhys;
  Date addDate;
  CategorieProblem categorieProblem;

    @DBRef
    private List<Why> whys;
    @DBRef
    private List<Solution> solution_fivewhys;

}
