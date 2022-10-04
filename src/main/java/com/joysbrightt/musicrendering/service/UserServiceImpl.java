package com.joysbrightt.musicrendering.service;

import com.joysbrightt.musicrendering.dtos.request.DeleteUserAcct;
import com.joysbrightt.musicrendering.dtos.request.RegisterUserRequest;
import com.joysbrightt.musicrendering.dtos.request.UserLoginRequest;
import com.joysbrightt.musicrendering.dtos.request.VerificationMessage;
import com.joysbrightt.musicrendering.dtos.response.RegisterUserResponse;
import com.joysbrightt.musicrendering.dtos.response.UserLoginResponse;
import com.joysbrightt.musicrendering.events.SendMessageEvent;
import com.joysbrightt.musicrendering.exceptionClass.MusicRenderingException;
import com.joysbrightt.musicrendering.model.User;
import com.joysbrightt.musicrendering.repository.UserRepository;
import com.mongodb.internal.bulk.DeleteRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
@Slf4j
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private ApplicationEventPublisher applicationEventPublisher;

    public UserServiceImpl(UserRepository userRepository, ApplicationEventPublisher applicationEventPublisher) {
        this.userRepository = userRepository;
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @Override
    public RegisterUserResponse createUser(RegisterUserRequest registerRequest) {
        User user = new User();
        if (user.getEmail().equals(registerRequest.getEmail())) throw new MusicRenderingException("account already exist");

        User newUser = User.builder()
                .dob(registerRequest.getDob())
                .firstName(registerRequest.getFirstName())
                .email(registerRequest.getEmail())
                .lastName(registerRequest.getLastName())
                .password(registerRequest.getPassword())
                .build();
         userRepository.save(newUser);
        VerificationMessage verificationMessage = VerificationMessage.builder()
                .userFullName(user.getFirstName() +" " + user.getLastName())
                .subject("email verification from music player")
                .receiver(user.getEmail())
                .sender("oluwatomisinoladoyin@gmail.com")
                .build();

        SendMessageEvent sendMessageEvent = new SendMessageEvent(verificationMessage);
        applicationEventPublisher.publishEvent(sendMessageEvent);


        return RegisterUserResponse.builder()
                .isSuccess(true)
                .statusCode(201)
                .message(RegisterUserResponse.builder().firstName(newUser.getFirstName())+ "You have been registered successfully")
                .build();
    }

    @Override
    public UserLoginResponse userLogin(UserLoginRequest loginRequest) {
      Optional <User> foundUser = userRepository.findUserByEmail(loginRequest.getEmail());
      if(foundUser.isEmpty()) throw new MusicRenderingException("invalid account query");
      foundUser.get().setEmail(loginRequest.getEmail());
        if(!foundUser.get().getPassword().equals(loginRequest.getPassword())) throw new MusicRenderingException("invalid login details: enter the correct details");
        foundUser.get().setPassword(loginRequest.getPassword());
        return UserLoginResponse.builder()
                .isSuccess(true)
                .statusCode(200)
                .message("Login successfully")
                .build();
    }

    @Override
    public Optional<User> removeUser(DeleteUserAcct deleteUserAcct) {
        Optional <User> user = userRepository.removeUserByEmail(deleteUserAcct.getEmail());
        if (!user.get().getEmail().equals(deleteUserAcct.getEmail())) throw new MusicRenderingException("invalid email account");

        return Optional.empty();
    }
}

//class StreamsInJava{
//    public static void main(String[] args) {
//        System.out.println( IntStream.rangeClosed(1,10)
//                .sum());
//
//    }
//  List<Books> books = getBooks();
//
//  List<String> programmingBookTitles = books.stream()
//          .filter(book -> book.getType()== Booktype.PROGRAMMING)
//          .sorted((b1, b2) -> b1.getTitle().length - b2.getTitle().length)
//          .map(Books::getTitle)
//          .collect(Collectors.toList());
//  programmingBookTitles.forEach(System.out::println);
//
//    public List<Books> getBooks() {
//        return books;
//    }
//
//    public void setBooks(List<Books> books) {
//        this.books = books;
//    }


