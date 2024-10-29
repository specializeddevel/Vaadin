package com.learning.blogblink.Mapper;

import ch.qos.logback.core.model.ComponentModel;
import com.learning.blogblink.Domain.Entity.DTO.UserAddRequestDTO;
import com.learning.blogblink.Domain.Entity.DTO.UserResponseDTO;
import com.learning.blogblink.Domain.Entity.DTO.UserUpdateRequestDTO;
import com.learning.blogblink.Domain.Entity.User;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User userAddRequestDTOToUsuario(UserAddRequestDTO userAddRequestDTO);
    User userUpdateRequestDTOToUser(UserUpdateRequestDTO userUpdateRequestDTO);
    UserResponseDTO userToUserResponseDTO(User user);
    List<UserResponseDTO> usersToUserResponseDTO(List<User> users);


}
