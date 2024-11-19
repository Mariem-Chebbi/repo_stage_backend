package lean.toc.manajerobackend.models.safe_models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Getter
@Setter

@Data
@Document(collection = "tasks")
public class Task {
  @Id

  private String _id;

  private String sprintId;


  private String title;

  private String description;


  private TaskStatus status;


  private Date startDate;


  private Date endDate;

  private String assignee;
 private String estimatedHours;
private  String actualHours;
  @DBRef
  private Backlog backlog;


}
