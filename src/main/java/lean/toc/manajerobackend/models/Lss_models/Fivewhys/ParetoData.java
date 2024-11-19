package lean.toc.manajerobackend.models.Lss_models.Fivewhys;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
@Getter
@Setter
@NoArgsConstructor
@Data
@Document(collection ="fivewhys")
@ToString
public class ParetoData implements Serializable {
    @Id
    private CategorieProblem category;
    private long count;
    private double cumulativePercentage;

    public ParetoData(CategorieProblem category, long count, double cumulativePercentage) {
        this.category = category;
        this.count = count;
        this.cumulativePercentage = cumulativePercentage;
    }

    // Getters and setters
}

