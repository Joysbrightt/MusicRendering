package com.joysbrightt.musicrendering.dtos.response;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FavouriteUpdateResponse {

    private String message;

    private boolean isSuccess;

    private int statusCode;
}
