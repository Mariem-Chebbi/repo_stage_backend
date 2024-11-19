package lean.toc.manajerobackend.models.safe_models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document(collection = "projects")
@Getter
@Setter

public class Project {

  @Id

  private String id;

  @Field("name")
  private String name;

  @Field("description")
  private String description;


}
