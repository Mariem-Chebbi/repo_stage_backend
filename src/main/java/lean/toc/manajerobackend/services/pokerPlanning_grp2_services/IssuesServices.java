package lean.toc.manajerobackend.services.pokerPlanning_grp2_services;



import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;
import jakarta.persistence.EntityNotFoundException;
import lean.toc.manajerobackend.models.pokerPlanning_grp2_models.Issues;
import lean.toc.manajerobackend.models.pokerPlanning_grp2_models.IssuesCsvRepresentation;
import lean.toc.manajerobackend.models.pokerPlanning_grp2_models.IssuesRequest;
import lean.toc.manajerobackend.models.pokerPlanning_grp2_models.Session;
import lean.toc.manajerobackend.repositories.pokerPlanning_grp2_repositories.IssuesRepository;
import lean.toc.manajerobackend.repositories.pokerPlanning_grp2_repositories.SessionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class IssuesServices {
    private static final String PREFIX = "PP-";

    IssuesRepository issuesRepo;
    SessionRepository sessionRepo;

    public Issues addIssue(String sessionId, Issues issue) {
        Session session = sessionRepo.findById(sessionId).orElseThrow(() -> new IllegalArgumentException("Invalid session ID"));
        // Générer un numéro d'issue
        long count = issuesRepo.countBySessionId(sessionId); // Compte le nombre d'issues pour cette session
        String issueNumber = PREFIX + (count + 1); // Générer le numéro d'issue

        issue.setIssueNumber(issueNumber); // Définir le numéro d'issue
        issue.setSession(session);
        return issuesRepo.save(issue);
    }
    public List<Issues> getAllIssues() {
        return issuesRepo.findAll();
    }

    public Issues updateIssues (Issues issues, String id) {
        Issues existingIssue = issuesRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Entity with id " + id + " not found"));
        existingIssue.setIssueDescription(issues.getIssueDescription());
        return issuesRepo.save(existingIssue);
    }

    public void deleteIssues(String id) {
        issuesRepo.deleteById(id);
    }

    public List<Issues> getIssuesBySessionId(String sessionId) {
        return issuesRepo.findBySessionId(sessionId);
    }



// *******************************   user stories **************************************

    public List<Issues> displayUserStories() {
        return issuesRepo.findAll();

    }


    public Issues getIssuesById(String id) {
        return issuesRepo.findById(id).orElse(null);
    }


    public Integer uploadIssues(MultipartFile file, String sessionId) throws IOException {
        Set<Issues> issues = parseCsv(file);
        issuesRepo.saveAll(issues);
        return issues.size();
    }

  private Set<Issues> parseCsv(MultipartFile file) throws IOException {
        try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            HeaderColumnNameMappingStrategy<IssuesCsvRepresentation> strategy =
                    new HeaderColumnNameMappingStrategy<>();
            strategy.setType(IssuesCsvRepresentation.class);
            CsvToBean<IssuesCsvRepresentation> csvToBean =
                    new CsvToBeanBuilder<IssuesCsvRepresentation>(reader)
                            .withMappingStrategy(strategy)
                            .withIgnoreEmptyLine(true)
                            .withIgnoreLeadingWhiteSpace(true)
                            .build();
            return csvToBean.parse()
                    .stream()
                    .map(csvLine -> Issues.builder()
                                    .name(csvLine.getName())
                                    .issueDescription(csvLine.getDescription())
//                            .estimation(csvLine.getEstimation())
//                            .status(csvLine.getStatus())
//                            .emittedVotes(csvLine.getEmittedVotes())
                                    .build()
                    )
                    .collect(Collectors.toSet());
        }
    }



    public void insertIssues1(List<IssuesRequest> newUserStories, String sessionId) {
        List<Issues> userstories = new ArrayList<>();

        for (var Issues : newUserStories) {
            var us = new Issues();
            us.setIssueDescription(Issues.getDescription());
            // us.setSessionId(sessionId) ;
            userstories.add(us);
        }
        issuesRepo.saveAll(userstories);
    }

    public long countIsuuesInSession(String sessionId) {
        return issuesRepo.countBySessionId(sessionId);
    }
}
