package com.example.biosphere.service;

import com.example.biosphere.model.User;
import com.example.biosphere.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    // 🔹 Connexion
    public Optional<User> login(String email, String password) {
        Optional<User> user = userRepository.findByEmail(email);
        if (user.isPresent() && user.get().getPassword().equals(password)) {
            return user;
        }
        return Optional.empty();
    }

    // 🔹 Recherche d’un utilisateur par ID (utilisé par EcosystemService)
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }


}
