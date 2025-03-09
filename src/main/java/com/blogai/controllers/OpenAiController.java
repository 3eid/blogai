package com.blogai.controllers;


import com.blogai.services.OpenAIService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/openai")
public class OpenAiController {

    private final OpenAIService openAiService;

    public OpenAiController(OpenAIService openAiService) {
        this.openAiService = openAiService;
    }

    @GetMapping("/ideas")
    public String getBlogPostIdeas(@RequestParam String topic) {
        return openAiService.generateBlogPostIdeas(topic);
    }

    @GetMapping("/outline")
    public String getBlogPostOutline(@RequestParam String title) {
        return openAiService.generateBlogPostOutline(title);
    }

    @PostMapping("/generate")
    public String generateBlogPost(@RequestBody String outline) {
        return openAiService.generateBlogPost(outline);
    }

    @PostMapping("/proofread")
    public String proofreadText(@RequestBody String text) {
        return openAiService.proofreadText(text);
    }
}
