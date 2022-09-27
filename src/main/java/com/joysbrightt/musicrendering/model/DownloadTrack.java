package com.joysbrightt.musicrendering.model;

import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DownloadTrack{

    private int downloadsId;

    private int musicId;
}
