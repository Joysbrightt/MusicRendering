package com.joysbrightt.musicrendering.service;

import com.amazonaws.services.kms.model.NotFoundException;
import com.joysbrightt.musicrendering.dtos.request.RecentUpdateRequest;
import com.joysbrightt.musicrendering.dtos.response.RecentUpdateResponse;
import com.joysbrightt.musicrendering.exceptionClass.MusicRenderingException;
import com.joysbrightt.musicrendering.model.Recent;
import com.joysbrightt.musicrendering.model.Songs;
import com.joysbrightt.musicrendering.model.User;
import com.joysbrightt.musicrendering.repository.RecentRepository;
import org.springframework.stereotype.Service;

@Service
public class RecentServiceImpl implements RecentService{
    private final RecentRepository recentRepository;

    public RecentServiceImpl(RecentRepository recentRepository) {
        this.recentRepository = recentRepository;
    }

    @Override
    public void addRecent(Songs songs, User user) {

        Recent recent = new Recent();
        if (recentRepository.existsById(recent.getRecentId())) throw new MusicRenderingException("recent already added, enter a new recent details");

        Recent.builder().recentId(recent.getRecentId())
                .userId(recent.getUserId())
                .build();

        recentRepository.save(recent);
    }

    @Override
    public void deleteRecent(Long recentId) {
        Recent recent = recentRepository.getReferenceById(recentId);
        if (!recent.getRecentId().equals(recentId)) throw new NotFoundException("no recent found by the id name");
        recentRepository.delete(recent);
    }

    @Override
    public RecentUpdateResponse updateRecent(RecentUpdateRequest updateRequest) {
        Recent recent = recentRepository.getReferenceById(updateRequest.getRecentId());
        if (!recent.getRecentId().equals(updateRequest.getRecentId())) throw new MusicRenderingException("no recent folder was found enter correct details");

        return RecentUpdateResponse.builder()
                .isSuccess(true)
                .message("recent successfully updated")
                .statusCode(200)
                .build();
    }

    @Override
    public Long showListOfDownloads() {

        return recentRepository.count();
    }
}
