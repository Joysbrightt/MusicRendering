package model;

import lombok.*;

import java.time.LocalDate;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Music {
    private String id;
    private  String title;
    private  String musicName;

    private String musicArtist;

    private LocalDate localDate;

    private String musicUrl;

}
