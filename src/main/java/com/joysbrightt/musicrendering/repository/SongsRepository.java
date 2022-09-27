package com.joysbrightt.musicrendering.repository;

import com.joysbrightt.musicrendering.model.Songs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongsRepository extends JpaRepository<Songs, Long> {
    Songs findSongsByUrl(String songUrl);
    Songs countSongsBySongsId(int songSize);
}
