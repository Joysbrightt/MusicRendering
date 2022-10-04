package com.joysbrightt.musicrendering.dtos.request;


import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DownloadUpdateRequest {
    private Long downloadsId;
    private String changeDownloadedSongName;

    private String changeDownloadedSongLocation;

    private String changeDownloadedSongUrl;
}
