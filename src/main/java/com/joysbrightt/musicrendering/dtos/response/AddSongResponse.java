package com.joysbrightt.musicrendering.dtos.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddSongResponse {

    private String message;
    private int statusCode;
    private boolean isSuccess;

}
