package com.joysbrightt.musicrendering.repository;

import com.joysbrightt.musicrendering.model.Recent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecentRepository extends JpaRepository<Recent, Long> {


}
