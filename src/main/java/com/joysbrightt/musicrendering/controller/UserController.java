package com.joysbrightt.musicrendering.controller;

import com.joysbrightt.musicrendering.dtos.request.DeleteUserAcct;
import com.joysbrightt.musicrendering.dtos.request.RegisterUserRequest;
import com.joysbrightt.musicrendering.dtos.request.UserLoginRequest;
import com.joysbrightt.musicrendering.dtos.response.RegisterUserResponse;
import com.joysbrightt.musicrendering.dtos.response.UserLoginResponse;
import com.joysbrightt.musicrendering.model.User;
import com.joysbrightt.musicrendering.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.html.Option;
import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/{registerUser}")
    public ResponseEntity<?> registerUser(@PathVariable("registerUser") RegisterUserRequest registerRequest){
        RegisterUserResponse registerUserResponse = userService.createUser(registerRequest);
        return new ResponseEntity<>(registerUserResponse, HttpStatus.CREATED);
    }

    @PostMapping("/{loginUser}")
    public ResponseEntity<?> loginUser(@PathVariable("loginUser") UserLoginRequest loginRequest){
         UserLoginResponse userLoginResponse = userService.userLogin(loginRequest);
        return new ResponseEntity<>(userLoginResponse, HttpStatus.OK);
    }


    @PostMapping("/{removeUser}")
    public ResponseEntity<?> removeUser(DeleteUserAcct deleteUserAcct){
        Optional<User> userOptional = userService.removeUser(deleteUserAcct);
        return new ResponseEntity<>(userOptional, HttpStatus.MOVED_PERMANENTLY);

    }
}
