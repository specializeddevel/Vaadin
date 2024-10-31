package com.learning.blogblink.Domain.Entity.DTO;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class UserUpdateRequestDTO {
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private MultipartFile profileImageUrl;
}
