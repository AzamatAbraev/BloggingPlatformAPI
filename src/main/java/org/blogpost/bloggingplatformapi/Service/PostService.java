package org.blogpost.bloggingplatformapi.Service;

import org.blogpost.bloggingplatformapi.Model.Post;
import org.blogpost.bloggingplatformapi.Repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    private final PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Post getPostById(Long id) {
        return postRepository.findById(id).orElse(null);
    }

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public Post createPost(Post post) {
        return postRepository.save(post);
    }

    public Post updatePost(Long id, Post post) {
        Post existingPost = postRepository.findById(id).orElse(null);

        if (existingPost == null) {
            return null;
        }

        existingPost.setTitle(post.getTitle());
        existingPost.setContent(post.getContent());
        existingPost.setCategory(post.getCategory());

        return postRepository.save(existingPost);
    }

    public boolean deletePost(Long id) {
        if (!postRepository.existsById(id)) {
            return false;
        }

        postRepository.deleteById(id);
        return true;
    }

    public List<Post> findByTerm(String term) {
        return postRepository.searchByTerm(term);
    }
}
