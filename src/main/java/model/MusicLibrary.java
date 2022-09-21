package model;

import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MusicLibrary {
//    FAVOURITE_MUSIC("FAVOURITE_SONGS", "FAVOURITE_PLAYLIST", "MY_PLAYLISTS",
//            "FAVOURITE", "FAVOURITE_ALBUMS", "FAVOURITE_VIDEOS", "FOLLOWED_ARTISTS"),
//
//    MY_PODCASTS("UPDATE","DOWNLOADS","PODCASTS_FOLLOWED") {

    private Favourite favorites;

    private FavoriteTrack favouriteTracks;

    private Recent recent;

    private RecentTrack recentTrack;

    private Downloads downloads;

    private DownloadTrack downloadTrack;


//    MusicLibrary(String update, String downloads, String podcasts_followed) {
//
//    }

//    MusicLibrary(String favourite_songs, String favourite_playlist, String my_playlists, String favourite, String favourite_albums, String favourite_videos, String followed_artists) {
//    }


}

