package com.joysbrightt.musicrendering.service;


import com.amazonaws.services.kms.model.NotFoundException;
import com.joysbrightt.musicrendering.dtos.request.DownloadUpdateRequest;
import com.joysbrightt.musicrendering.dtos.response.DownloadUpdateResponse;
import com.joysbrightt.musicrendering.exceptionClass.MusicRenderingException;
import com.joysbrightt.musicrendering.model.Downloads;
import com.joysbrightt.musicrendering.model.Songs;
import com.joysbrightt.musicrendering.model.User;
import com.joysbrightt.musicrendering.repository.DownloadsRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class DownloadServiceImpl implements DownloadService{

    private final DownloadsRepository downloadsRepository;

    public DownloadServiceImpl( DownloadsRepository downloadsRepository) {
        this.downloadsRepository = downloadsRepository;
    }

    @Override
    public void addDownload(Songs songs, User user) {
        com.joysbrightt.musicrendering.model.Downloads downloads = new com.joysbrightt.musicrendering.model.Downloads();
        if (downloads.getDownloadsId().equals(songs.getSongsId())) throw new MusicRenderingException("song already downloaded, do you want to download again?");
        com.joysbrightt.musicrendering.model.Downloads newDownload = com.joysbrightt.musicrendering.model.Downloads.builder()
                .downloadsId(songs.getSongsId())
                .userId(Math.toIntExact(user.getId())).build();



        downloadsRepository.save(newDownload);

    }

    @Override
    public void deleteDownload(Long downloadsId) {
        Downloads downloads = downloadsRepository.getReferenceById(downloadsId);
        if (!downloads.getDownloadsId().equals(downloadsId)) throw new NotFoundException("not found");
        downloadsRepository.delete(downloads);

    }

    @Override
    public DownloadUpdateResponse updateDownload(DownloadUpdateRequest updateRequest) {
        Optional<Downloads> downloads = Optional.ofNullable(downloadsRepository.findById(updateRequest.getDownloadsId()).orElseThrow(() -> new NotFoundException("invalid query, enter the correct download id7666")));

        DownloadUpdateRequest downloadUpdateRequest = DownloadUpdateRequest.builder()
                .changeDownloadedSongUrl("")
                .changeDownloadedSongLocation("")
                .changeDownloadedSongName("")

                .build();
            downloads.equals(downloadsRepository.equals(downloadUpdateRequest));
        return DownloadUpdateResponse.builder()
                .statusCode(201)
                .message("information successfully update")
                .isSuccess(true)
                .build();
    }

    @Override
    public Long showListOfDownloads() {

        return downloadsRepository.count();
    }
}
