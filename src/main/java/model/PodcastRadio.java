package model;

import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PodcastRadio {

    private  int podcastId;

    private String podcastName;

    private String PodcastUrl;

}
