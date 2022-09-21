package model;

import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FavoriteTrack {
    private int favouritesId;

    private int musicId;
}
