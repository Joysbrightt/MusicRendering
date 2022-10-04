package com.joysbrightt.musicrendering.service;

import com.joysbrightt.musicrendering.dtos.request.FavouriteUpdateRequest;
import com.joysbrightt.musicrendering.dtos.response.FavouriteUpdateResponse;
import com.joysbrightt.musicrendering.model.Songs;
import com.joysbrightt.musicrendering.model.User;

public interface FavouriteService {
    void addFavourite(Songs songs, User user);

    void deleteFavourite(Long favouriteId);

    FavouriteUpdateResponse updateDownload(FavouriteUpdateRequest updateRequest);

    Long showListOfDownloads();
}
