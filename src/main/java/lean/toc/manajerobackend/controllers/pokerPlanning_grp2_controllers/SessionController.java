package lean.toc.manajerobackend.controllers.pokerPlanning_grp2_controllers;


import lean.toc.manajerobackend.models.pokerPlanning_grp2_models.Session;
import lean.toc.manajerobackend.services.pokerPlanning_grp2_services.ApiResponse;
import lean.toc.manajerobackend.services.pokerPlanning_grp2_services.SessionService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class SessionController {
    SessionService sessionService ;

    @PostMapping("/addSession")
    Session addSession(@RequestBody Session session) {
        return  sessionService.addSession(session);
    }


    @GetMapping("/getSessions")
    List<Session> getSessions(){
        return sessionService.getAllSessions();
    }

    @GetMapping("/getSession/{id}")
    public Session getSessionById(@PathVariable String id) {
        return sessionService.getSessionById(id);
    }
    @DeleteMapping("/deleteSession/{id}")
    public void deleteSession(@PathVariable String id ){
        sessionService.deleteSession(id);
    }
    @PutMapping("/updateSession/{id}")
    public Session updateSession(@PathVariable String id, @RequestBody Session session) {
        return sessionService.updateSession(session, id);

    }
    // User Invitation
    @PostMapping("/{sessionId}/invite")
    public ResponseEntity<String> inviteUserToSession(@PathVariable String sessionId, @RequestParam String email) {
        sessionService.inviteUserToSession(sessionId, email);
        return ResponseEntity.ok("Invitation sent to " + email);
    }

     @PostMapping("/close/{id}")
     public ResponseEntity<ApiResponse> closeSession(@PathVariable String id) {
         try {
             sessionService.closeSession(id);
             return ResponseEntity.ok(new ApiResponse("Session closed successfully"));
         } catch (RuntimeException e) {
             return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage()));
         }
     }

        @GetMapping("/status/{id}")
        public ResponseEntity<ApiResponse> getSessionStatus(@PathVariable String id) {
            boolean closed = sessionService.isSessionClosed(id);
            return ResponseEntity.ok(new ApiResponse(closed ? "Session is closed" : "Session is open"));
        }


}
