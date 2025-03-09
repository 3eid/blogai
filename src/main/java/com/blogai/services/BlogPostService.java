package com.blogai.services;

import com.blogai.models.BlogPost;
import com.blogai.repositories.BlogPostRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogPostService {
    private final BlogPostRepository blogPostRepository;
    private final BlogPostSearchService searchService;

    public BlogPostService(BlogPostRepository blogPostRepository, BlogPostSearchService searchService) {
        this.blogPostRepository = blogPostRepository;
        this.searchService = searchService;
    }

    public List<BlogPost> getAllPosts() {
        return blogPostRepository.findAll();
    }

    public BlogPost getPostById(Long id) {
        return blogPostRepository.findById(id).orElse(null);
    }

    public BlogPost createPost(BlogPost post) {
        BlogPost savedPost = blogPostRepository.save(post);
        searchService.indexBlogPost(savedPost); // Index in Elasticsearch
        return savedPost;
    }
    public BlogPost updatePost(Long id, BlogPost newPost) {
        return blogPostRepository.findById(id).map(post -> {
            post.setTitle(newPost.getTitle());
            post.setContent(newPost.getContent());
            BlogPost updatedPost = blogPostRepository.save(post);
            searchService.indexBlogPost(updatedPost); // Update Elasticsearch index
            return updatedPost;
        }).orElseThrow(() -> new RuntimeException("Post not found"));
    }
    public void deletePost(Long id) {
        blogPostRepository.deleteById(id);
    }
}
