package com.learning.blogblink.Controller;

import com.learning.blogblink.Domain.Entity.DTO.UserAddRequestDTO;
import com.learning.blogblink.Domain.Entity.DTO.UserResponseDTO;
import com.learning.blogblink.Domain.Entity.DTO.UserUpdateRequestDTO;
import com.learning.blogblink.Domain.Entity.User;
import com.learning.blogblink.Mapper.UserMapper;
import com.learning.blogblink.Service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.io.IOException;
import java.util.List;


@RestController
@RequestMapping(path = {"/", "/user"})
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @PostMapping(value = "/add", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<User> addUSer(UserAddRequestDTO userAddRequestDTO) throws IOException {
        User newUser = userService.createUser(userAddRequestDTO);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);

    }

    @PutMapping(value = "/update/{userId}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<User> updateUser(@PathVariable Long userId, UserUpdateRequestDTO userUpdateRequestDTO) throws IOException {
        User updateUser = userService.updateUser(userId, userUpdateRequestDTO);
        return new ResponseEntity<>(updateUser, HttpStatus.OK);

    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<User> deleteUser(@PathVariable Long userId) {
        User deletedUser = userService.removeUser(userId);
        return new ResponseEntity<>(deletedUser, HttpStatus.OK);

    }

    @GetMapping()
    public ResponseEntity<List<UserResponseDTO>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        List<UserResponseDTO> userDTOList = userMapper.usersToUserResponseDTO(users);
        return new ResponseEntity<>(userDTOList, HttpStatus.OK);
    }
}
