package com.joysbrightt.musicrendering.service;

import com.joysbrightt.musicrendering.dtos.request.AddSongRequest;
import com.joysbrightt.musicrendering.dtos.response.AddSongResponse;
import com.joysbrightt.musicrendering.model.Songs;
import com.joysbrightt.musicrendering.model.User;

import java.util.List;

public interface SongsService {

    AddSongResponse addSongs(AddSongRequest addSongRequest);

    User removeSongs(Long songId);

    Songs showSongs(List<Songs> songsList);

    Songs findSongsByUrl(String songUrl);

    int countSongsBySongsId(int songSize);
}
