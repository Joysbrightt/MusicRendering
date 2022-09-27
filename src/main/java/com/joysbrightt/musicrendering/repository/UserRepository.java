package com.joysbrightt.musicrendering.repository;

import com.joysbrightt.musicrendering.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

     Optional<User> findUserByEmail(String email);

     Optional<User> removeUserByEmail(String email);
}
