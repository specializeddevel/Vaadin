package com.learning.blogblink.Controller;

import com.learning.blogblink.Domain.Entity.DTO.UserAddRequestDTO;
import com.learning.blogblink.Domain.Entity.DTO.UserResponseDTO;
import com.learning.blogblink.Domain.Entity.DTO.UserUpdateRequestDTO;
import com.learning.blogblink.Domain.Entity.User;
import com.learning.blogblink.Mapper.UserMapper;
import com.learning.blogblink.Service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


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

    @PostMapping("/add")
    public ResponseEntity<User> addUSer(@RequestBody UserAddRequestDTO userAddRequestDTO) {
        User userEntity = userMapper.userAddRequestDTOToUsuario(userAddRequestDTO);
        User newUser = userService.createUser(userEntity);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);

    }

    @PutMapping("/update/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable Long userId, @RequestBody UserUpdateRequestDTO userUpdateRequestDTO) {
        User userEntity = userMapper.userUpdateRequestDTOToUser(userUpdateRequestDTO);
        User updateUser = userService.updateUser(userId, userEntity);
        if(updateUser != null) {
            return new ResponseEntity<>(updateUser, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<User> deleteUser(@PathVariable Long userId) {
        User deletedUser = userService.removeUser(userId);
        if(deletedUser != null) {
            return new ResponseEntity<>(deletedUser, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping()
    public ResponseEntity<List<UserResponseDTO>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        List<UserResponseDTO> userDTOList = userMapper.usersToUserResponseDTO(users);
        return new ResponseEntity<>(userDTOList, HttpStatus.OK);
    }
}
