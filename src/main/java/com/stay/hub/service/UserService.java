package com.stay.hub.service;

import com.stay.hub.dto.UserDto;
import com.stay.hub.dto.request.ChangePasswordRequest;
import com.stay.hub.dto.request.LoginRequest;
import java.util.List;


public interface UserService {

    UserDto createUser(UserDto user);

    UserDto verifyUser(LoginRequest request);

    UserDto updateUserDetail(UserDto user);

    List<UserDto> getAllUsers();

    UserDto getUser(Long id);

    UserDto changePassword(ChangePasswordRequest request);

    void removeUser(Long id);

}
