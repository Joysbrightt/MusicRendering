package com.joysbrightt.musicrendering.service;

import com.joysbrightt.musicrendering.dtos.request.AddSongRequest;
import com.joysbrightt.musicrendering.dtos.response.AddSongResponse;
import com.joysbrightt.musicrendering.model.Songs;

import java.util.List;

public interface SongsService {

    AddSongResponse addSongs(AddSongRequest addSongRequest);

    void removeSongs(Long songId);

    List<Songs> showSong();

    Songs findSongsByUrl(String songUrl);

    Long countNumberOfSongs();
}
