package com.joysbrightt.musicrendering.exceptionClass;

import lombok.Getter;

@Getter
public class MusicRenderingException extends  RuntimeException{

    private String message;

    public MusicRenderingException(String message) {
        this.message = message;
    }
}
