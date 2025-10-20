package com.example.biosphere.service;

import com.example.biosphere.controller.EcosystemController;
import com.example.biosphere.controller.EcosystemController.EcosystemCreateRequest;
import com.example.biosphere.controller.EcosystemController.EcosystemUpdateRequest;
import com.example.biosphere.model.Ecosystem;
import com.example.biosphere.model.User;
import com.example.biosphere.repository.EcosystemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EcosystemService {
    @Autowired private EcosystemRepository ecosystemRepository;
    @Autowired private AuthService authService;

    public List<Ecosystem> getEcosystemsByUser(Long userId) {
        return ecosystemRepository.findByUserId(userId); // ou findByUserIdWithRelations si tu veux
    }

    public Ecosystem createEcosystem(EcosystemController.EcosystemCreateRequest r) {
        User user = authService.findById(r.getUserId())
                .orElseThrow(() -> new RuntimeException("Utilisateur introuvable: " + r.getUserId()));
        Ecosystem e = new Ecosystem();
        e.setName(r.getName()); e.setType(r.getType()); e.setPhotoUrl(r.getPhotoUrl()); e.setUser(user);
        return ecosystemRepository.save(e);
    }

    public Ecosystem updateEcosystem(Long id, EcosystemController.EcosystemUpdateRequest r) {
        Ecosystem e = ecosystemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ecosystème introuvable: " + id));
        if (r.getName()!=null) e.setName(r.getName());
        if (r.getType()!=null) e.setType(r.getType());
        if (r.getPhotoUrl()!=null) e.setPhotoUrl(r.getPhotoUrl());
        return ecosystemRepository.save(e);
    }

    public void deleteEcosystem(Long id){ ecosystemRepository.deleteById(id); }
}


