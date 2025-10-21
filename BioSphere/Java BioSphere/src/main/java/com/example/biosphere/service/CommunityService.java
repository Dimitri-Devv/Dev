package com.example.biosphere.service;

import com.example.biosphere.model.Comment;
import com.example.biosphere.model.Post;
import com.example.biosphere.model.User;
import com.example.biosphere.repository.CommentRepository;
import com.example.biosphere.repository.PostRepository;
import com.example.biosphere.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommunityService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CommentRepository commentRepository;

    // 🔹 Récupérer les posts avec leurs auteurs et commentaires
    @Transactional
    public List<Post> getPosts(String type) {
        List<Post> posts;

        if (type == null || type.equals("all")) {
            posts = postRepository.findAllByOrderByCreatedAtDesc();
        } else {
            posts = postRepository.findByTypeOrderByCreatedAtDesc(type);
        }

        // ⚙️ Force le chargement des relations utiles (évite les LazyInitializationException)
        posts.forEach(post -> {
            if (post.getAuthor() != null) post.getAuthor().getUsername();
            if (post.getComments() != null) {
                post.getComments().forEach(c -> {
                    if (c.getAuthor() != null) c.getAuthor().getUsername();
                });
            }
        });

        return posts;
    }

    // 🔹 Créer un post
    @Transactional
    public Post createPost(Long userId, String type, String text, List<String> images) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("Utilisateur introuvable"));

        Post post = new Post();
        post.setAuthor(user);
        post.setType(type);
        post.setText(text);
        post.setImages(images);

        return postRepository.save(post);
    }

    // 🔹 Récupérer les commentaires d’un post
    @Transactional
    public List<Comment> getComments(Long postId) {
        List<Comment> comments = commentRepository.findByPostIdOrderByCreatedAtAsc(postId);

        // ⚙️ Charge les auteurs pour chaque commentaire
        comments.forEach(c -> {
            if (c.getAuthor() != null) c.getAuthor().getUsername();
        });

        return comments;
    }

    // 🔹 Ajouter un commentaire
    @Transactional
    public Comment addComment(Long postId, Long userId, String text) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("Utilisateur introuvable"));
        Post post = postRepository.findById(postId).orElseThrow(() -> new RuntimeException("Post introuvable"));

        Comment comment = new Comment();
        comment.setAuthor(user);
        comment.setPost(post);
        comment.setText(text);

        return commentRepository.save(comment);
    }
}
