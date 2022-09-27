package com.joysbrightt.musicrendering.dtos.response;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class RegisterUserResponse {

    private String message;

    private int statusCode;

    private boolean isSuccess;

    private String firstName;
}
