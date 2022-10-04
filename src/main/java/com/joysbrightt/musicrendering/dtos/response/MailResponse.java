package com.joysbrightt.musicrendering.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Builder
@Setter
public class MailResponse {

    private boolean isSuccessful;
}
