package com.pratik.demo.SpringAi.controller;


import com.pratik.demo.SpringAi.service.PromptGenerator;
import org.springframework.ai.client.Generation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class PhotographyPromptController {

    @Autowired
    private PromptGenerator generator;

    @GetMapping("/ai-photo-image/generate-prompt")
    public String generate(@RequestParam(value = "photographyStyle", defaultValue = "nature") String photographyStyle, @RequestParam(value = "imageQuality",
            defaultValue = "4k") String imageQuality, @RequestParam(value = "numberOfPrompt", defaultValue = "numberOfPrompt") String numberOfPrompt) {

        return generator.generate(photographyStyle, imageQuality, numberOfPrompt);
    }

}
