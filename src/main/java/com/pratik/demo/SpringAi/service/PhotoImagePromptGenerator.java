package com.pratik.demo.SpringAi.service;

import org.springframework.ai.client.AiClient;
import org.springframework.ai.client.AiResponse;
import org.springframework.ai.prompt.Prompt;
import org.springframework.ai.prompt.PromptTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class PhotoImagePromptGenerator implements PromptGenerator {

    @Autowired
    AiClient aiClient;

    @Override
    public String generate(String photographyStyle, String imageQuality, String numberOfPrompt) {
        String promptMessage = "Act as an highly experienced photographer, create {numberOfPrompt} image generation" +
                " prompt on {photographyStyle} photography, which will generate {imageQuality} images, out put should be" +
                " in a list format where each list object will have title and prompt";
        PromptTemplate promptTemplate = new PromptTemplate(promptMessage);

        Prompt prompt = promptTemplate.create(Map.of("numberOfPrompt", numberOfPrompt, "photographyStyle", photographyStyle,
                "imageQuality", imageQuality));

        AiResponse response = aiClient.generate(prompt);

        return response.getGeneration().getText();
    }
}
