package com.example.biosphere.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String password;
    private String phone;
    private String photoUrl;
    private String username;
    private LocalDateTime createdAt = LocalDateTime.now();
}
