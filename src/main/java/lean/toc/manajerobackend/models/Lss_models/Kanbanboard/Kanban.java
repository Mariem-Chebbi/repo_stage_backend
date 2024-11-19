package lean.toc.manajerobackend.models.Lss_models.Kanbanboard;

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
@Document(collection ="kanban")
@ToString
public class Kanban implements Serializable {
    @Id
    String idkanban;
    String id_project;
    String title_kanban;
   Date creation_date;


    @DBRef
    List<Card> cards;

}
