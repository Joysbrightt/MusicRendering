package com.joysbrightt.musicrendering.dtos.request;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import java.time.LocalDate;
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterUserRequest {

        private String firstName;
        private String  lastName;
        @Email
        @Valid
        private String email;

        private String password;

        @JsonSerialize(using = LocalDateTimeSerializer.class)
        private LocalDate dob;

    }
