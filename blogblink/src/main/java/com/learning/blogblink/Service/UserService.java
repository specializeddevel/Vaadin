package com.learning.blogblink.Service;

import com.learning.blogblink.Domain.Entity.User;
import com.learning.blogblink.Repository.UserRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public interface UserService {

    User createUser(User user);
    User updateUser(User user);
    User removeUser(Long userId);
    List<User> getAllUsers();
}
