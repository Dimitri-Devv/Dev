package com.example.biosphere.service;

import com.example.biosphere.model.User;
import com.example.biosphere.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {
    private final UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    public List<User> getAll() { return repo.findAll(); }
    public User getById(Long id) { return repo.findById(id).orElse(null); }
    public User create(User user) { return repo.save(user); }
    public void delete(Long id) { repo.deleteById(id); }
}
