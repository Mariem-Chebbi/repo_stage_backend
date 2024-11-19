package lean.toc.manajerobackend.services.pokerPlanning_grp2_services;


import lean.toc.manajerobackend.models.pokerPlanning_grp2_models.Session;
import lean.toc.manajerobackend.models.pokerPlanning_grp2_models.User;
import lean.toc.manajerobackend.repositories.pokerPlanning_grp2_repositories.SessionRepository;
import lean.toc.manajerobackend.repositories.pokerPlanning_grp2_repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service("pokerPlanningUserService")
@AllArgsConstructor
public class UserService {

    UserRepository userRepository;
    SessionRepository sessionRepo;

    public User addUser(String sessionId, User user) {
        Session session = sessionRepo.findById(sessionId).orElseThrow(() -> new IllegalArgumentException("Invalid session ID"));
        user.setSession(session);
        return userRepository.save(user);
    }

    public List<User> getUsersBySession(String sessionId) {
        Optional<Session> sessionOptional = sessionRepo.findById(sessionId);
        if (sessionOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid session ID");
        }
        Session session = sessionOptional.get();
        return userRepository.findBySession(session);
    }
    public User getUserById(String userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
    }
    public long countUsersInSession(String sessionId) {
        return userRepository.countBySessionId(sessionId);
    }
}
