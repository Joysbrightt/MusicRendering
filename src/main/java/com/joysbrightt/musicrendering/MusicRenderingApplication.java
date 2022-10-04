package com.joysbrightt.musicrendering;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class MusicRenderingApplication {

    public static void main(String[] args) {
        SpringApplication.run(MusicRenderingApplication.class, args);
    }

}
