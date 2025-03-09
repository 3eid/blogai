package com.blogai.controllers;

import com.blogai.models.BlogPostIndex;
import com.blogai.services.BlogPostSearchService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/search")
public class BlogPostSearchController {
    private final BlogPostSearchService searchService;

    public BlogPostSearchController(BlogPostSearchService searchService) {
        this.searchService = searchService;
    }

    @GetMapping("/{keyword}")
    public List<BlogPostIndex> searchPosts(@PathVariable String keyword) {
        return searchService.searchPosts(keyword);
    }
}
