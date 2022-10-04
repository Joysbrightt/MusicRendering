package com.joysbrightt.musicrendering.service.emailService;

import com.joysbrightt.musicrendering.dtos.request.VerificationMessage;
import com.joysbrightt.musicrendering.dtos.response.MailResponse;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.util.concurrent.CompletableFuture;


public interface EmailService {
    CompletableFuture<MailResponse> sendSimpleMail(VerificationMessage mailRequest) throws UnirestException;


    }
