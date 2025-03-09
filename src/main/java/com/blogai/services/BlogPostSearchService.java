package com.blogai.services;

import com.blogai.models.BlogPost;
import com.blogai.models.BlogPostIndex;
import org.springframework.stereotype.Service;
import com.blogai.search.repositories.BlogPostSearchRepository;
import java.util.List;
import java.time.format.DateTimeFormatter;

@Service
public class BlogPostSearchService {
    private final BlogPostSearchRepository searchRepository;

    public BlogPostSearchService(BlogPostSearchRepository searchRepository) {
        this.searchRepository = searchRepository;
    }

    // Index a blog post in Elasticsearch
    public void indexBlogPost(BlogPost post) {
        BlogPostIndex index = new BlogPostIndex();
        index.setId(post.getId().toString());
        index.setTitle(post.getTitle());
        index.setContent(post.getContent());

        // Convert LocalDateTime to ISO format String
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        index.setCreatedAt(post.getCreatedAt().format(formatter));

        searchRepository.save(index);
    }
    // Search for blog posts by keyword
    public List<BlogPostIndex> searchPosts(String keyword) {
        return searchRepository.findByTitleContainingOrContentContaining(keyword, keyword);
    }
}
