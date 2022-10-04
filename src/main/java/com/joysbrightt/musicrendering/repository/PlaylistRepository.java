package com.joysbrightt.musicrendering.repository;

import com.joysbrightt.musicrendering.model.enums.PlayListCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaylistRepository extends JpaRepository<PlayListCategory, Long> {


}
