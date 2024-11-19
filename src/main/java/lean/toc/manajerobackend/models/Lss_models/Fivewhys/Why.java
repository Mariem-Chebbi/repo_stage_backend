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
@Document(collection ="why")
@ToString
public class Why implements Serializable {
    @Id
    String id_why;
   String answer_why;

   @JsonIgnore
    @DBRef
    private Fivewhys fivewhys;

    public Why(String number, String why2) {
        this.id_why=number;
        this.answer_why=why2;

    }
}
