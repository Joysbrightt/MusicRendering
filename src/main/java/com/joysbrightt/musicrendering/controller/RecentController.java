package com.joysbrightt.musicrendering.controller;

import com.joysbrightt.musicrendering.dtos.request.RecentUpdateRequest;
import com.joysbrightt.musicrendering.dtos.response.RecentUpdateResponse;
import com.joysbrightt.musicrendering.model.Songs;
import com.joysbrightt.musicrendering.model.User;
import com.joysbrightt.musicrendering.service.RecentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

@RestController
public class RecentController {

    private final RecentService recentService;

    public RecentController(RecentService recentService) {
        this.recentService = recentService;
    }

    @PostMapping("/{addRecent}")

    public ResponseEntity<?> addRecent(Songs songs, User user){
        recentService.addRecent(songs, user);

        return new ResponseEntity<>((Songs) songs, (MultiValueMap<String, String>) user, HttpStatus.CREATED);
    }

    @DeleteMapping("/{deleteRecent}")

    public ResponseEntity<?> deleteRecent(Long recentId, @PathVariable String deleteRecent){
        recentService.deleteRecent(recentId);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{updateRecent}")

    public ResponseEntity<?> updateRecent(RecentUpdateRequest updateRequest){
        RecentUpdateResponse updateResponse = recentService.updateRecent(updateRequest);
        return new ResponseEntity<>(updateResponse, HttpStatus.ACCEPTED);
    }

}
