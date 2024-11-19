package lean.toc.manajerobackend.models.FDDG2_Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Project")
public class Project {
    @Id
    private String codeProject ;
    private String Name ;
    private String Description;
    private String StartDate;
    private String EndDate;
    private LocalDate createdAt;
    @DBRef
    private WorkSpace workSpace;

}
