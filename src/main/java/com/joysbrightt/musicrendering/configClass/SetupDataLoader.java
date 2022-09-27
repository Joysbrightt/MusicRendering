package com.joysbrightt.musicrendering.configClass;

import com.joysbrightt.musicrendering.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import com.joysbrightt.musicrendering.model.Roletype;
import com.joysbrightt.musicrendering.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@Slf4j
public class SetupDataLoader implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
  private final UserRepository userRepository;

  private final PasswordEncoder passwordEncoder;

    public SetupDataLoader(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
if(userRepository.findUserByEmail("adminuser@gmail.com").isEmpty()){
    User user = new User("Admin", "User","adminuser@gmail.com", passwordEncoder.encode("password"), Roletype.ROLE_ADMIN );
        user.setDateJoined(LocalDate.now());
        userRepository.save(user);
}
    }
}
