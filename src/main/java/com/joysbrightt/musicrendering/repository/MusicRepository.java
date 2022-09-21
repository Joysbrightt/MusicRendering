package com.joysbrightt.musicrendering.repository;

import model.Music;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface MusicRepository extends JpaRepository<Music, Long>, MusicRepo {

    Music findMusicByTitleIsIgnoreCase(String title);

    List<Music> findMusicByUploadedBy(String email);

}
