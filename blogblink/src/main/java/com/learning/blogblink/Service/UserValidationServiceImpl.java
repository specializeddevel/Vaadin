package com.learning.blogblink.Service;

import com.learning.blogblink.Domain.Entity.User;
import com.learning.blogblink.Repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserValidationServiceImpl implements UserValidationService {

    private final UserRepository userRepository;

    public UserValidationServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void validateUsernameAndEmail(String newUsername, String newEmail, Long userId) {
        findUserByUsername(newUsername).ifPresent(user -> {
            if (userId == null || !user.getId().equals(userId)) {
                throw new RuntimeException("Username is already taken: " + newUsername);
            }
        });

        findUserByEmail(newEmail).ifPresent(user -> {
            if (userId == null || !user.getId().equals(userId)) {
                throw new RuntimeException("Email is already in use: " + newEmail);
            }
        });
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<User> findUserByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<User> findUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }
}
