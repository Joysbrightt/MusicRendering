package com.joysbrightt.musicrendering.events;

import com.joysbrightt.musicrendering.dtos.request.VerificationMessage;
import com.joysbrightt.musicrendering.service.emailService.EmailService;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class SendMessageEventListener {
@Qualifier("mail_gun_sender")
    private final EmailService emailService;

    public SendMessageEventListener(EmailService emailService) {
        this.emailService = emailService;
    }

    @EventListener
    public void HandleSendMessageEvent(SendMessageEvent sendMessageEvent) throws UnirestException {
        VerificationMessage verificationMessage = (VerificationMessage) sendMessageEvent.getSource();
        emailService.sendSimpleMail(verificationMessage);
    }
}
