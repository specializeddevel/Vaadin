package com.learning.blogblink.Service;

import com.learning.blogblink.Domain.Entity.DTO.UserAddRequestDTO;
import com.learning.blogblink.Domain.Entity.DTO.UserUpdateRequestDTO;
import com.learning.blogblink.Domain.Entity.User;
import com.learning.blogblink.Mapper.UserMapper;
import com.learning.blogblink.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final ImageService imageService;

    public UserServiceImpl(UserRepository userRepository,
                           UserMapper userMapper,
                           ImageService imageService) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.imageService = imageService;
    }

    @Override
    public User createUser(UserAddRequestDTO userAddRequestDTO) throws IOException {
        String imageName = imageService.saveProfileImage(null,userAddRequestDTO.getUsername(),userAddRequestDTO.getProfileImageUrl());
        User userEntity = userMapper.userAddRequestDTOToUsuario(userAddRequestDTO);
        userEntity.setProfileImageUrl(imageName);
        return userRepository.save(userEntity);
    }

    @Override
    public User updateUser(Long userId, UserUpdateRequestDTO userUpdateRequestDTO) throws IOException {
        User existingUser = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));
        userMapper.userUpdateRequestDTOToUser(userUpdateRequestDTO, existingUser);
        String imageName = imageService.saveProfileImage(existingUser.getProfileImageUrl(), userUpdateRequestDTO.getUsername(),userUpdateRequestDTO.getProfileImageUrl());
        existingUser.setProfileImageUrl(imageName);
        return userRepository.save(existingUser);
    }

    @Override
    public User removeUser(Long userId) {
        User existingUser = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));
        imageService.deleteUserProfileImage(existingUser.getProfileImageUrl());
        userRepository.delete(existingUser);
        return existingUser;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users;
    }
}
