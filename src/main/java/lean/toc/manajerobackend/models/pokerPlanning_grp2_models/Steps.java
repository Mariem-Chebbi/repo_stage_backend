package lean.toc.manajerobackend.models.pokerPlanning_grp2_models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Steps")

public class Steps implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    String id;
    String title;
    String stepDescription;

    public Steps(String title, String stepDescription) {
        this.title = title;
        this.stepDescription = stepDescription;
    }
}
