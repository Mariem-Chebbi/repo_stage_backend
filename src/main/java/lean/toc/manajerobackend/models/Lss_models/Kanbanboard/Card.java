package lean.toc.manajerobackend.models.Lss_models.Kanbanboard;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Document(collection ="card")
@ToString
public class Card implements Serializable {
    @Id
    String id_card;
    String title_card;
    String desciption_card;
    Date creation_card;
    Priority priority_card;
    Status status;


    @JsonIgnore
    @DBRef
     Kanban kanban;



}
