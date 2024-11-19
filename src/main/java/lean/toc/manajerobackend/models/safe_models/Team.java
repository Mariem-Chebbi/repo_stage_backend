package lean.toc.manajerobackend.models.safe_models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@Data
@Document(collection = "teams")
public class Team {
    @Id
    private String id;

    private String name; // Name of the team
    private String capacity; // Capacity in hours or story points
    private String constraints; // Constraints or notes
    @DBRef
    private List<UserStory> userStories; // List of User Stories assigned to the team
    @DBRef
    private List<Task> tasks; // List of Tasks assigned to the team
}
