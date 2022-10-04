package com.joysbrightt.musicrendering.service;

import com.joysbrightt.musicrendering.dtos.request.DownloadUpdateRequest;
import com.joysbrightt.musicrendering.dtos.response.DownloadUpdateResponse;
import com.joysbrightt.musicrendering.model.Songs;
import com.joysbrightt.musicrendering.model.User;

public interface DownloadService {

    void addDownload(Songs songs, User user);

    void deleteDownload(Long downloadsId);

    DownloadUpdateResponse updateDownload(DownloadUpdateRequest updateRequest);

    Long showListOfDownloads();
}
