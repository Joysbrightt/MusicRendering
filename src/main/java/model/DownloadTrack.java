package model;

import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DownloadTrack extends Downloads {

    private int downloadsId;

    private int musicId;
}
