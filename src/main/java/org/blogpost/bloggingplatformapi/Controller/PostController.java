package org.blogpost.bloggingplatformapi.Controller;

import org.blogpost.bloggingplatformapi.Model.Post;
import org.blogpost.bloggingplatformapi.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {
    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    public ResponseEntity<Post> createPost(@RequestBody Post post) {
        return ResponseEntity.status(HttpStatus.CREATED).body(postService.createPost(post));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable Long id, @RequestBody Post post) {
        Post updatedPost = postService.updatePost(id, post);

        if (updatedPost == null) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(updatedPost);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable Long id) {
        boolean isDeleted = postService.deletePost(id);

        if (!isDeleted) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Post>> getPosts(@RequestParam(required = false) String term) {
        List<Post> posts = (term == null) ? postService.getAllPosts() : postService.findByTerm(term);
        return ResponseEntity.ok(posts);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable Long id) {
        Post post = postService.getPostById(id);

        return ResponseEntity.ok(post);
    }

}
