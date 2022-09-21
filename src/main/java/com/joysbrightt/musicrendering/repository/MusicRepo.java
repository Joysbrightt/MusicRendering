package com.joysbrightt.musicrendering.repository;

import model.Music;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;

public interface MusicRepo {
    Page<Music> findAll(Pageable pageable);
}
