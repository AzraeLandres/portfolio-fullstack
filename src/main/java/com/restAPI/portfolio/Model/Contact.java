package com.restAPI.portfolio.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Contact {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String emailAddress;
    private String subject;
    private String message;
}
