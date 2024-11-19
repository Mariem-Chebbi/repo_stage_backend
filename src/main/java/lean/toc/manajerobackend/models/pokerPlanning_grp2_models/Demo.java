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
@Document(collection = "Demo")
public class Demo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    String id;
    String title;
    String intro;
    String description;


    public Demo(String title, String intro, String description) {
        this.title = title;
        this.intro = intro;
        this.description = description;
    }

}






