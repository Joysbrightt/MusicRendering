package com.joysbrightt.musicrendering.exceptionClass;

import lombok.Getter;

@Getter
public class NotFoundException {

    private String message;

    public NotFoundException(String message) {
        this.message = message;
    }
}
