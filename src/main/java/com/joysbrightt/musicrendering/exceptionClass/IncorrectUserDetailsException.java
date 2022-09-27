package com.joysbrightt.musicrendering.exceptionClass;

import lombok.Getter;

@Getter
public class IncorrectUserDetailsException {

    private String message;

    public IncorrectUserDetailsException(String message) {
        this.message = message;
    }
}
