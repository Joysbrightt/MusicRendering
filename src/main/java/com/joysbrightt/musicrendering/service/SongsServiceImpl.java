package com.joysbrightt.musicrendering.service;

import com.joysbrightt.musicrendering.dtos.request.AddSongRequest;
import com.joysbrightt.musicrendering.dtos.response.AddSongResponse;
import com.joysbrightt.musicrendering.exceptionClass.MusicRenderingException;
import com.joysbrightt.musicrendering.model.Songs;
import com.joysbrightt.musicrendering.model.User;
import com.joysbrightt.musicrendering.repository.SongsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class SongsServiceImpl implements SongsService {

    private SongsRepository songsRepository;

    private int songSize;

//    public SongsServiceImpl(int songSize) {
//        this.songSize = songSize;
//    }

    @Override
    public AddSongResponse addSongs(AddSongRequest addSongRequest) {
        Songs songs = songsRepository.findSongsByUrl(addSongRequest.getMusicUrl());
        if(songs.getMusicUrl().equals(addSongRequest.getMusicUrl())) throw new MusicRenderingException("song already added, please add new song");
        AddSongRequest.builder()
                .title(songs.getTitle())
                .musicArtist(songs.getMusicArtist())
                .musicName(songs.getMusicName())
                .musicUrl(songs.getMusicUrl())
                .localDate(songs.getLocalDate())
                .build();
        return AddSongResponse.builder()
                .isSuccess(true)
                .message("Song successfully added")
                .statusCode(201)
                .build();
    }

    @Override
    public User removeSongs(Long songId) {
        Optional<Songs> songs = songsRepository.findById(songId);
        if (songs.get().getSongsId().equals(songId))
            songsRepository.deleteById(songs.get().getSongsId());
//        User.builder().songs(songId.intValue()).build();
        countSongsBySongsId(songSize);
        return null;
    };
        @Override
    public Songs showSongs(List<Songs> songsList) {
        return null;
    }

    @Override
    public Songs findSongsByUrl(String songUrl) {
        return null;
    }

    @Override
    public int countSongsBySongsId(int songSize) {

        return songSize;
    }
}