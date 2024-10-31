package com.learning.blogblink.Domain.Entity.DTO;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

@Getter
@Setter
public class UserResponseDTO {
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private Date createdAt;
    private Date updatedAt;
    private String profileImageUrl;
}
