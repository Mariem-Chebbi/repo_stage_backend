package lean.toc.manajerobackend.models.safe_models;

import lean.toc.manajerobackend.models.safe_models.RiskStatus;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Data
@Document(collection = "risks")
public class Risk {
    @Id
    private String id;

    private String description; // Description of the risk
    private String impact; // Impact level (High/Medium/Low)
    private String likelihood; // Likelihood level (High/Medium/Low)
    private String mitigationPlan; // Plan to mitigate the risk
    private RiskStatus status; // Status of the risk (Open/Closed)
}
