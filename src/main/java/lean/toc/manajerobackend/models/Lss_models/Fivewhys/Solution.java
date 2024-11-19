package lean.toc.manajerobackend.models.Lss_models.Fivewhys;

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
@Document(collection ="solution")
@ToString
public class Solution implements Serializable {
    @Id
    String id_solution ;
    String description_solution;


    @JsonIgnore
    @DBRef
    private Fivewhys fivewhys;

    public Solution(String number, String solution2) {
        this.id_solution=number;
        this.description_solution=solution2;
    }
}
