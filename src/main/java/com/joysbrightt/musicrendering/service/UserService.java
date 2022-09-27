package com.joysbrightt.musicrendering.service;

import com.joysbrightt.musicrendering.dtos.request.DeleteUserAcct;
import com.joysbrightt.musicrendering.dtos.request.RegisterUserRequest;
import com.joysbrightt.musicrendering.dtos.request.UserLoginRequest;
import com.joysbrightt.musicrendering.dtos.response.RegisterUserResponse;
import com.joysbrightt.musicrendering.dtos.response.UserLoginResponse;
import com.joysbrightt.musicrendering.model.User;
import com.mongodb.internal.bulk.DeleteRequest;

import java.util.Optional;

public interface UserService {

    RegisterUserResponse createUser(RegisterUserRequest registerRequest);

    UserLoginResponse userLogin(UserLoginRequest loginRequest);

    Optional<User> removeUser(DeleteUserAcct deleteUserAcct);
}
