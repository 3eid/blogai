package com.blogai.search.repositories;

import com.blogai.models.BlogPostIndex;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogPostSearchRepository extends ElasticsearchRepository<BlogPostIndex, String> {
    List<BlogPostIndex> findByTitleContainingOrContentContaining(String title, String content);
}