package com.learning.blogblink.Repository;

import com.learning.blogblink.Domain.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
