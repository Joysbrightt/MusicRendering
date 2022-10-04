package com.joysbrightt.musicrendering.repository;

import com.joysbrightt.musicrendering.model.Favourite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavouriteRepository extends JpaRepository<Favourite, Long> {

}
