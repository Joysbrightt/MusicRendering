package com.joysbrightt.musicrendering.dtos.response;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DownloadUpdateResponse {
    private String message;

    private int statusCode;

    private  boolean isSuccess;
}
