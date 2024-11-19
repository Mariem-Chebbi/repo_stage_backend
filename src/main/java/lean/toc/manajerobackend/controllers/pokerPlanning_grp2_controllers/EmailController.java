package lean.toc.manajerobackend.controllers.pokerPlanning_grp2_controllers;

import lean.toc.manajerobackend.services.pokerPlanning_grp2_services.EmailService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@AllArgsConstructor
public class EmailController {


    private EmailService emailService;
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/send")
    public ResponseEntity<String> sendEmail(@RequestParam("to") String toEmail,
                                            @RequestParam("subject") String subject,
                                            @RequestParam("body") String body) {
        try {
            emailService.sendEmail(toEmail, body, subject);
            return ResponseEntity.ok("Email sent successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to send email: " + e.getMessage());
        }
    }






}
