package com.restAPI.portfolio.Controller;

import org.springframework.beans.factory.annotation.Value;
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

    @Value("${email}")
    private String email;

    @PostMapping("/portfolio-azrael/contact")
    public ResponseEntity<String> sendEmail(@RequestBody Contact contact) {
        emailService.sendEmail(email, contact.getSubject(), contact.getMessage());
        return new ResponseEntity<>("Email sent successfully", HttpStatus.OK);
    }
}
