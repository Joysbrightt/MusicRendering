package com.joysbrightt.musicrendering.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.deser.std.DateDeserializers;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor

@Entity(name = "songs")
public class Songs {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "songs_Id", nullable = false)
    private Long songsId;

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
