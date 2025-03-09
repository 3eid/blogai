package com.blogai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.blogai.repositories")  // Scan only JPA repositories
@EnableElasticsearchRepositories(basePackages = "com.blogai.search.repositories")  // Scan only Elasticsearch repositories
public class BlogaiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogaiApplication.class, args);
	}

}
