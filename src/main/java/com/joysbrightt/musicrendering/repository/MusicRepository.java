package com.joysbrightt.musicrendering.repository;

import com.joysbrightt.musicrendering.model.Songs;
import com.joysbrightt.musicrendering.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface MusicRepository extends JpaRepository<Long, User> {

    Songs findMusicByTitleIsIgnoreCase(String title);

    List<Songs> findMusicByUploadedBy(String email);
    Page<Songs> findAll(Pageable pageable);


}
