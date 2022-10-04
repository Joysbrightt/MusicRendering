package com.joysbrightt.musicrendering.dtos.request;
import javax.validation.constraints.Email;

import lombok.*;

import javax.validation.constraints.Email;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Email

public class VerificationMessage {
    private String sender;

    @Email
    private String receiver;
    private String body;
    private String subject;
    private String userFullName;
    private String verificationToken;
    private String domainUrl;

}

