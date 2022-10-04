package com.joysbrightt.musicrendering.service;

import com.joysbrightt.musicrendering.dtos.request.FavouriteUpdateRequest;
import com.joysbrightt.musicrendering.dtos.response.FavouriteUpdateResponse;
import com.joysbrightt.musicrendering.exceptionClass.MusicRenderingException;
import com.joysbrightt.musicrendering.model.Favourite;
import com.joysbrightt.musicrendering.model.Songs;
import com.joysbrightt.musicrendering.model.User;
import com.joysbrightt.musicrendering.repository.FavouriteRepository;
import org.springframework.stereotype.Service;

@Service
public class FavouriteServiceImpl implements FavouriteService{

    private final FavouriteRepository favouriteRepository;

    public FavouriteServiceImpl(FavouriteRepository favouriteRepository) {
        this.favouriteRepository = favouriteRepository;
    }

    @Override
    public void addFavourite(Songs songs, User user) {
        Favourite favourite = favouriteRepository.getReferenceById(user.getId());
        if (!favourite.getFavouriteId().equals(favourite.getFavouriteId())) throw new MusicRenderingException("invalid details enter the correct details");
        Favourite.builder().userId(favourite.getUserId())
                .favouriteId(favourite.getFavouriteId())
                .build();
    }

    @Override
    public void deleteFavourite(Long favouriteId) {

        Favourite  favourite = favouriteRepository.getReferenceById(favouriteId);
        if (!favourite.getFavouriteId().equals(favouriteId)) throw new MusicRenderingException("invalid favourite details");
        favouriteRepository.delete(favourite);

    }

    @Override
    public FavouriteUpdateResponse updateDownload(FavouriteUpdateRequest updateRequest) {

        Favourite  favourite = favouriteRepository.getReferenceById(updateRequest.getFavouriteId());
        if (!favourite.getFavouriteId().equals(updateRequest.getFavouriteId())) throw new MusicRenderingException("invalid favourite details");

        FavouriteUpdateRequest.builder().build();
        return FavouriteUpdateResponse.builder()
                .isSuccess(true)
                .message("success!")
                .statusCode(201).build();
    }

    @Override
    public Long showListOfDownloads() {
        return favouriteRepository.count();
    }
}
