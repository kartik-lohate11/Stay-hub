package com.stay.hub.controller;

import com.stay.hub.dto.UserDto;
import com.stay.hub.dto.request.LoginRequest;
import com.stay.hub.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@Slf4j
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto) {

        UserDto response = userService.createUser(userDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    /**
     * Update User
     */
    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable Long id, @Valid @RequestBody UserDto userDto) {

        userDto.setId(id);

        return ResponseEntity.ok(userService.updateUserDetail(userDto));
    }

    /**
     * Get User By Id
     */
    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long id) {

        return ResponseEntity.ok(userService.getUser(id));
    }

    /**
     * Get All Users
     */
    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers() {

        return ResponseEntity.ok(userService.getAllUsers());
    }

    /**
     * Delete User
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {

        userService.removeUser(id);

        return ResponseEntity.noContent().build();
    }

    @PostMapping("/verify")
    public ResponseEntity<?> verifyUser(@RequestBody LoginRequest request){
       return ResponseEntity.ok(userService.verifyUser(request));
    }

}
