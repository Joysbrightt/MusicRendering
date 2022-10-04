package com.joysbrightt.musicrendering.controller;

import com.joysbrightt.musicrendering.model.Songs;
import com.joysbrightt.musicrendering.model.User;
import com.joysbrightt.musicrendering.service.FavouriteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FavouriteController {

    private final FavouriteService favouriteService;

    public FavouriteController(FavouriteService favouriteService) {
        this.favouriteService = favouriteService;
    }

    @PostMapping("/{addFavourite}")

    public ResponseEntity<?> addFavourite(@RequestParam Songs songs, User user){
    favouriteService.addFavourite(songs, user);

    return new ResponseEntity<>( songs, HttpStatus.ACCEPTED);
    }
}
