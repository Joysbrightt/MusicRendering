package com.joysbrightt.musicrendering.dtos.request;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.deser.std.DateDeserializers;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;
import lombok.*;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddSongRequest {
    @NonNull
    @NotBlank
    private  String title;
    @NonNull
    @NotBlank
    private  String musicName;
    @NonNull
    @NotBlank
    private String musicArtist;
    @NonNull
    @NotBlank
    @JsonSerialize(using = DateSerializer.class)
    @JsonDeserialize(using = DateDeserializers.CalendarDeserializer.class)
    private LocalDate localDate;
    @NonNull
    @NotBlank
    private String musicUrl;
}
