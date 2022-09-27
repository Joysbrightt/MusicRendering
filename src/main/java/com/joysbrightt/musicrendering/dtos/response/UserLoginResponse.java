package com.joysbrightt.musicrendering.dtos.response;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserLoginResponse {
    private String message;

    private boolean isSuccess;

    private int statusCode;

}
