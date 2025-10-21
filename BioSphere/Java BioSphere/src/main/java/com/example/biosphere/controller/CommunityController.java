package com.example.biosphere.controller;
import com.example.biosphere.model.Message;
import com.example.biosphere.model.Comment;
import com.example.biosphere.model.Post;
import com.example.biosphere.service.CommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.biosphere.model.Ecosystem;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/community")
@CrossOrigin(origins = "*")
public class CommunityController {

    @Autowired
    private CommunityService communityService;

    // 🔹 Récupérer tous les posts (avec filtre)
    @GetMapping("/posts")
    public List<Post> getPosts(@RequestParam(required = false, defaultValue = "all") String type) {
        return communityService.getPosts(type);
    }

    // 🔹 Créer un post
    @PostMapping("/posts")
    public Post createPost(@RequestBody Map<String, Object> body) {
        Long userId = Long.valueOf(body.get("userId").toString());
        String type = (String) body.get("type");
        String text = (String) body.get("text");
        List<String> images = (List<String>) body.get("images");
        return communityService.createPost(userId, type, text, images);
    }

    // 🔹 Récupérer les commentaires d’un post
    @GetMapping("/posts/{postId}/comments")
    public List<Comment> getComments(@PathVariable Long postId) {
        return communityService.getComments(postId);
    }

    // 🔹 Ajouter un commentaire
    @PostMapping("/posts/{postId}/comments")
    public Comment addComment(@PathVariable Long postId, @RequestBody Map<String, Object> body) {
        Long userId = Long.valueOf(body.get("userId").toString());
        String text = (String) body.get("text");
        return communityService.addComment(postId, userId, text);
    }





}
