package com.joysbrightt.musicrendering.exceptionClass;

import lombok.Getter;

@Getter
public class InvalidCommandException {
    private String message;

    public InvalidCommandException(String message) {
        this.message = message;
    }
}
