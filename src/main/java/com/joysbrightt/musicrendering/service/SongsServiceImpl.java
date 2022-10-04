package com.joysbrightt.musicrendering.service;

import com.joysbrightt.musicrendering.dtos.request.AddSongRequest;
import com.joysbrightt.musicrendering.dtos.response.AddSongResponse;
import com.joysbrightt.musicrendering.exceptionClass.MusicRenderingException;
import com.joysbrightt.musicrendering.model.Songs;
import com.joysbrightt.musicrendering.repository.SongsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public void removeSongs(Long songId) {
        Songs song = songsRepository.findById(songId).orElseThrow(()-> new MusicRenderingException("Song not found!"));
        songsRepository.delete(song);
//        if (songs.get().getSongsId().equals(songId))
//            songsRepository.deleteById(songs.get().getSongsId());
//        User.builder().songs(songId.intValue()).build();
        countNumberOfSongs();
    };
        @Override
    public List<Songs> showSong() {
            List<Songs> songs = songsRepository.findAll();
            if(songs.isEmpty()){
                throw new RuntimeException("No song found!");
            }
            return songs;
//            try {
//                Optional<Songs> songs = songsRepository.findAll().add(songsList)
//            } catch (Exception e) {
//                throw new RuntimeException(e);
//            } {
//                return songsList;
//            }
//        return null;
    }

    @Override
    public Songs findSongsByUrl(String songUrl) {
        return null;
    }

    @Override
    public Long countNumberOfSongs() {
        return songsRepository.count();
    }
}