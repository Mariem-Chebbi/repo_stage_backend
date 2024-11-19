package lean.toc.manajerobackend.controllers.pokerPlanning_grp2_controllers;


import lean.toc.manajerobackend.models.pokerPlanning_grp2_models.User;
import lean.toc.manajerobackend.models.pokerPlanning_grp2_models.Vote;
import lean.toc.manajerobackend.repositories.pokerPlanning_grp2_repositories.UserRepository;
import lean.toc.manajerobackend.repositories.pokerPlanning_grp2_repositories.VoteRepository;
import lean.toc.manajerobackend.services.pokerPlanning_grp2_services.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/votes")
public class VoteController {

    @Autowired
    private VoteService voteService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private VoteRepository voteRepository;


    @PostMapping
    public ResponseEntity<Vote> addVote(@RequestBody Vote vote) {
        Vote savedVote = voteService.addVote(vote);
        return ResponseEntity.ok(savedVote);
    }

    @GetMapping("/session/{sessionId}/issue/{issueId}")
    public ResponseEntity<List<Vote>> getVotesBySessionAndIssue(@PathVariable String sessionId, @PathVariable String issueId) {
        List<Vote> votes = voteService.getVotesBySessionAndIssue(sessionId, issueId);
        return ResponseEntity.ok(votes);
    }

   @GetMapping("getaverage")
    public ResponseEntity<Double> getAverageVote(
            @RequestParam String sessionId,
            @RequestParam String issueId) {
        double averageVote = voteService.calculateAverageVote(sessionId, issueId);
        return ResponseEntity.ok(averageVote);
    }


    @PostMapping("/session/submitVote")
    public Vote submitVote(@RequestBody Vote vote) {
        User user = userRepository.findById(vote.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        Vote newVote = new Vote();
        newVote.setSessionId(vote.getSessionId());
        newVote.setIssueId(vote.getIssueId());
        newVote.setVote(vote.getVote());
        newVote.setUserId(user.getId());
        newVote.setUserName(user.getName());

        return  voteRepository.save(newVote);
    }


    @GetMapping("/count/{issueId}")
    public Long getVoteCount(@PathVariable String issueId) {
        return voteService.getVoteCountByIssueId(issueId);
    }

    @GetMapping("/issue/{issueId}")
    public List<Vote> getVotesByIssueId(@PathVariable String issueId) {
        return voteService.getVotesByIssueId(issueId);
    }

    @GetMapping("/sessions/{sessionId}/vote-frequency")
    public ResponseEntity<Map<String, Integer>> getVoteFrequencyForSession(@PathVariable String sessionId) {
        Map<String, Integer> frequencyMap = voteService.calculateVoteFrequencyForSession(sessionId);
        return ResponseEntity.ok(frequencyMap);
    }

    @GetMapping("/sessions/{sessionId}/vote-distribution")
    public Map<String, Object> getVoteDistribution(@PathVariable String sessionId) {
        return voteService.getVoteDistribution(sessionId);
    }
}
