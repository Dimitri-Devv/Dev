package com.example.biosphere.controller;

import com.example.biosphere.model.Ecosystem;
import com.example.biosphere.service.EcosystemService;
import com.example.biosphere.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/ecosystems")
@CrossOrigin(origins = "*")
public class EcosystemController {

    @Autowired private EcosystemService ecosystemService;

    @GetMapping("/{userId}")
    public List<Ecosystem> getEcosystemsByUser(@PathVariable Long userId) {
        return ecosystemService.getEcosystemsByUser(userId);
    }

    @PostMapping
    public Ecosystem createEcosystem(@RequestBody EcosystemCreateRequest request) {
        return ecosystemService.createEcosystem(request);
    }

    @PutMapping("/{id}")
    public Ecosystem update(@PathVariable Long id, @RequestBody EcosystemUpdateRequest request) {
        return ecosystemService.updateEcosystem(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { ecosystemService.deleteEcosystem(id); }

    public static class EcosystemCreateRequest {
        private String name; private String type; private String photoUrl; private Long userId;
        public String getName(){return name;} public void setName(String name){this.name=name;}
        public String getType(){return type;} public void setType(String type){this.type=type;}
        public String getPhotoUrl(){return photoUrl;} public void setPhotoUrl(String photoUrl){this.photoUrl=photoUrl;}
        public Long getUserId(){return userId;} public void setUserId(Long userId){this.userId=userId;}
    }
    public static class EcosystemUpdateRequest {
        private String name; private String type; private String photoUrl;
        public String getName(){return name;} public void setName(String name){this.name=name;}
        public String getType(){return type;} public void setType(String type){this.type=type;}
        public String getPhotoUrl(){return photoUrl;} public void setPhotoUrl(String photoUrl){this.photoUrl=photoUrl;}
    }
}



