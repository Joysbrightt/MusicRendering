package model;

import lombok.*;

import java.util.Queue;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Player {
    private float volume;
    private String repeat;
    private Queue<Music> songs;
    private int currentSongIndex;

}
