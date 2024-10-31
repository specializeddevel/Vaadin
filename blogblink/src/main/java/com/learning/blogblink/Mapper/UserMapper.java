package com.learning.blogblink.Mapper;

import ch.qos.logback.core.model.ComponentModel;
import com.learning.blogblink.Domain.Entity.DTO.UserAddRequestDTO;
import com.learning.blogblink.Domain.Entity.DTO.UserResponseDTO;
import com.learning.blogblink.Domain.Entity.DTO.UserUpdateRequestDTO;
import com.learning.blogblink.Domain.Entity.User;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;
import java.util.stream.Collectors;

import static com.learning.blogblink.Constant.StorageConstant.PROFILE_STORAGE_PATH;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "profileImageUrl", ignore = true)
    User userAddRequestDTOToUsuario(UserAddRequestDTO userAddRequestDTO);
    @Mapping(target = "profileImageUrl", ignore = true)
    User userUpdateRequestDTOToUser(UserUpdateRequestDTO userUpdateRequestDTO, @MappingTarget User user);
    UserResponseDTO userToUserResponseDTO(User user);
    List<UserResponseDTO> usersToUserResponseDTO(List<User> users);


    @AfterMapping
    default void customizeImage(User user, @MappingTarget UserResponseDTO userResponseDTO) {
        String customizeImagePath = PROFILE_STORAGE_PATH + user.getProfileImageUrl();
        userResponseDTO.setProfileImageUrl(customizeImagePath);
    }
}
