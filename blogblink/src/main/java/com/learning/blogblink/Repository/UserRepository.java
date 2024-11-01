package com.learning.blogblink.Repository;

import com.learning.blogblink.Domain.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    public Optional<User> findUserByUsername(String username);
    public Optional<User> findUserByEmail(String email);

}
