package com.joysbrightt.musicrendering.dtos.request;

import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.Email;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserLoginRequest {
    @Email
    @Valid
    private String email;

    @Valid
    private String password;
}
