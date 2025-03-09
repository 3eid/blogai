package com.blogai.services;


import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.stereotype.Service;

@Service
public class OpenAIService {

    private OpenAiChatModel chatModel;

    public void OpenAiService(OpenAiChatModel chatModel) {
        this.chatModel = chatModel;
    }

    public OpenAIService(OpenAiChatModel chatModel) {
        this.chatModel = chatModel;
    }

    // Generate Blog Post Ideas
    public String generateBlogPostIdeas(String topic) {
        String promptText = "Generate 5 blog post ideas about: " + topic;
        Prompt prompt = new Prompt(promptText);
        ChatResponse response = chatModel.call(prompt);
        return response.getResults().get(0).getOutput().getText();
    }

    // Generate Blog Post Outline
    public String generateBlogPostOutline(String title) {
        String promptText = "Create an outline for a blog post titled: " + title;
        Prompt prompt = new Prompt(promptText);
        ChatResponse response = chatModel.call(prompt);
        return response.getResults().get(0).getOutput().getText();
    }

    // Generate Full Blog Post
    public String generateBlogPost(String outline) {
        String promptText = "Write a detailed blog post based on this outline: " + outline;
        Prompt prompt = new Prompt(promptText);
        ChatResponse response = chatModel.call(prompt);
        return response.getResults().get(0).getOutput().getText();
    }

    // Proofread and Fix Grammar
    public String proofreadText(String text) {
        String promptText = "Fix any grammar mistakes in the following text: " + text;
        Prompt prompt = new Prompt(promptText);
        ChatResponse response = chatModel.call(prompt);
        return response.getResults().get(0).getOutput().getText();
    }
}
