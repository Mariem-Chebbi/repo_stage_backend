package lean.toc.manajerobackend.models.pokerPlanning_grp2_models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class JiraIssuesResponse {
    private String id;
    private String platformId;
    private String text;
    private String status;
}
