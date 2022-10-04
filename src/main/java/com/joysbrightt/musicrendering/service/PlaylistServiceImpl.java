package com.joysbrightt.musicrendering.service;

import com.joysbrightt.musicrendering.repository.PlaylistRepository;
import org.springframework.stereotype.Service;

@Service
public class PlaylistServiceImpl implements PlaylistService{

    public PlaylistServiceImpl(PlaylistRepository playlistRepository) {
        this.playlistRepository = playlistRepository;
    }

    private final PlaylistRepository playlistRepository;


    @Override
    public void addPlaylist(Long playlistId) {
    }
}
