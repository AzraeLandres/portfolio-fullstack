package com.restAPI.portfolio.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.restAPI.portfolio.Model.Contact;
import com.restAPI.portfolio.Service.EmailService;

@RestController
public class EmailController {

    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("projects/contact")
    public ResponseEntity<String> sendEmail(@RequestBody Contact contact) {
        emailService.sendEmail(contact.getEmailAddress(), contact.getSubject(), contact.getMessage());
        return new ResponseEntity<>("Email sent successfully", HttpStatus.OK);
    }
}
