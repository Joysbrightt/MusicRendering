package com.joysbrightt.musicrendering.exceptionClass;

public class MusicRenderingException extends  RuntimeException{

    private String message;

    public MusicRenderingException(String message) {
        this.message = message;
    }
}
