package com.joysbrightt.musicrendering.service.emailService;

import com.joysbrightt.musicrendering.dtos.request.VerificationMessage;
import com.joysbrightt.musicrendering.dtos.response.MailResponse;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Slf4j
@NoArgsConstructor
@Service("mail_gun_sender")

public class MailGunServiceImpl implements EmailService{
    private final String DOMAIN = System.getenv("DOMAIN");
    private final String PRIVATE_KEY = System.getenv("MAILGUN_PRIVATE_KEY");


    @Override
    @Async
    public CompletableFuture<MailResponse> sendSimpleMail(VerificationMessage mailRequest) throws UnirestException {
        HttpResponse<String> request = Unirest.post("https://api.mailgun.net/v3/" + DOMAIN + "/messages")
                .basicAuth("api", PRIVATE_KEY)
                .queryString("from", mailRequest.getSender())
                .queryString("to", mailRequest.getReceiver())
                .queryString("subject", mailRequest.getSubject())
                .queryString("html", mailRequest.getBody())
                .asString();
        MailResponse mailResponse = new MailResponse(request.getStatus() == 200);
        return CompletableFuture.completedFuture(mailResponse);
    }


}

