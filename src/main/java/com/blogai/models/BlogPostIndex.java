package com.blogai.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;

import java.time.format.DateTimeFormatter;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Document(indexName = "blogposts")  // Elasticsearch Index
public class BlogPostIndex {
    @Id
    private String id;

    private String title;
    private String content;

    @Field(type = FieldType.Keyword)  // Store as a String
    private String createdAt;

    public BlogPostIndex(String id, String title, String content, LocalDateTime createdAt) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);  // Convert to String
    }
}