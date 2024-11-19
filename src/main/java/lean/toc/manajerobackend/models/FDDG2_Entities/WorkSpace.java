package lean.toc.manajerobackend.models.FDDG2_Entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "WS")


public class WorkSpace {
    @Id
    private String codeWS ;
    private String Name ;

    private String domain;
    private LocalDate Date;
    @DBRef
    private User user;
}
