package com.example.biosphere.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.biosphere.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
