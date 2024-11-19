package lean.toc.manajerobackend.models.safe_models;

import lean.toc.manajerobackend.models.safe_models.UserStory;
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
@Document(collection = "epics")
public class Epic {
    @Id
    private String id;

    private String title; // Title of the Epic
    private String description; // Description of the Epic
    private String status; // Status (Backlog/In Progress/Done)
    @DBRef
    private List<UserStory> userStories; // List of User Stories associated with this Epic
}
