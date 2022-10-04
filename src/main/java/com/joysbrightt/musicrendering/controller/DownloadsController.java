package com.joysbrightt.musicrendering.controller;

import com.joysbrightt.musicrendering.dtos.request.DownloadUpdateRequest;
import com.joysbrightt.musicrendering.dtos.response.DownloadUpdateResponse;
import com.joysbrightt.musicrendering.model.Songs;
import com.joysbrightt.musicrendering.model.User;
import com.joysbrightt.musicrendering.service.DownloadService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class DownloadsController {
    private final DownloadService downloadService;

    public DownloadsController(DownloadService downloadService) {
        this.downloadService = downloadService;
    }

    @RequestMapping("/{addDownload}")
    public ResponseEntity<?>addDownload(@PathVariable("addDownload") @RequestParam Songs songs, User user){
        downloadService.addDownload(songs, user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{deleteDownload}")
    public ResponseEntity<?> deleteDownload(@PathVariable("deleteDownload") @RequestParam Long downloadsId){
        downloadService.deleteDownload(downloadsId);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @PutMapping("/{updateDownload}")

    public ResponseEntity<?> updateDownload(@PathVariable("updateDownload") @RequestBody DownloadUpdateRequest updateRequest){
        DownloadUpdateResponse updateResponse = downloadService.updateDownload(updateRequest);

        return new ResponseEntity<>(updateResponse, HttpStatus.CREATED);
    }


    @GetMapping("/{showListOfDownload}")

    public ResponseEntity<?> showListOfDownload(){
        downloadService.showListOfDownloads();

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
