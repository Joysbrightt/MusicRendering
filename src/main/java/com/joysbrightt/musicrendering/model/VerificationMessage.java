package com.joysbrightt.musicrendering.model;

import lombok.*;

import javax.validation.constraints.Email;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class VerificationMessage {

    @Email
    private String sender;

@Email
private String receiver;
private String body;
private String subject;
private String userFullName;
private String verificationToken;
private String domainUrl;

}
