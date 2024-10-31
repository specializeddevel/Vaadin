package com.learning.blogblink.Service;

import com.learning.blogblink.Domain.Entity.DTO.UserAddRequestDTO;
import com.learning.blogblink.Domain.Entity.DTO.UserUpdateRequestDTO;
import com.learning.blogblink.Domain.Entity.User;
import com.learning.blogblink.Repository.UserRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@Primary
public interface UserService {

    User createUser(UserAddRequestDTO user) throws IOException;
    User updateUser(Long userId, UserUpdateRequestDTO user) throws IOException;
    User removeUser(Long userId);
    List<User> getAllUsers();
}
