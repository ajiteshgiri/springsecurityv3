package com.security.repo;

import com.security.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Integer> {

    Optional<Users> findByUsername(String username);
    Boolean existsByEmail(String email);
    Optional<Users> findByUsernameOrEmail(String username, String email);
}
