package com.stay.hub.service.impl;

import com.stay.hub.dto.UserDto;
import com.stay.hub.dto.request.ChangePasswordRequest;
import com.stay.hub.dto.request.LoginRequest;
import com.stay.hub.repository.UserRepository;
import com.stay.hub.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto user) {
        return null;
    }

    @Override
    public UserDto verifyUser(LoginRequest request) {
        return null;
    }

    @Override
    public UserDto updateUserDetail(UserDto user) {
        return null;
    }

    @Override
    public List<UserDto> getAllUsers() {
        return List.of();
    }

    @Override
    public UserDto getUser(Long id) {
        return null;
    }

    @Override
    public UserDto changePassword(ChangePasswordRequest request) {
        return null;
    }

    @Override
    public void removeUser(Long id) {

    }
}
