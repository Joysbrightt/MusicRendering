package com.joysbrightt.musicrendering.dtos.request;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MailRequest {
 private String sender;

 private String receiver;

 private String body;

 private String subject;

}
