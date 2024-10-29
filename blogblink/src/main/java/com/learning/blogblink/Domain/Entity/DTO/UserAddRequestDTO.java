package com.learning.blogblink.Domain.Entity.DTO;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserAddRequestDTO {
    private String firstName;
    private String lastName;
    private String username;
    private String email;

}
