package com.stay.hub.service.impl;

import com.stay.hub.dto.UserDto;
import com.stay.hub.dto.mapper.UserMapper;
import com.stay.hub.dto.request.ChangePasswordRequest;
import com.stay.hub.dto.request.LoginRequest;
import com.stay.hub.entity.UserData;
import com.stay.hub.exception.UserNotFoundException;
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
    private final UserMapper userMapper;

    @Override
    public UserDto createUser(UserDto user) {
        return userMapper.toDto(userRepository.save(userMapper.toEntity(user)));
    }

    @Override
    public UserDto verifyUser(LoginRequest request) {
        UserDto userDto = userMapper.toDto(userRepository.findByNameAndPassword(request.userName(), request.password()));

        if (userDto != null) return userDto;
        else throw new UserNotFoundException(request.userName() + " Not Found");

    }

    @Override
    @Transactional
    public UserDto updateUserDetail(UserDto userDto) {
        UserData existingUser = userRepository
                .findById(userDto.getId())
                .orElseThrow(() -> new UserNotFoundException("User not found with name : " + userDto.getName()));

        userMapper.updateEntityFromDto(userDto, existingUser);

        return userMapper.toDto(userRepository.save(existingUser));
    }

    @Override
    public List<UserDto> getAllUsers() {
        return userMapper.toDto(userRepository.findAll());

    }

    @Override
    public UserDto getUser(Long id) {
        return userMapper.toDto(
                userRepository
                        .findById(id)
                        .orElseThrow(() -> new UserNotFoundException("User not found with id : " + id)));
    }

    @Override
    public UserDto changePassword(ChangePasswordRequest request) {
        return null;
    }

    @Override
    @Transactional
    public void removeUser(Long id) {
        UserData user = userRepository.findById(id)
                .orElseThrow(() ->
                        new UserNotFoundException("User not found with id: " + id));

        userRepository.delete(user);
    }
}
