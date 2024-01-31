package com.pratik.demo.SpringAi.service;

import org.springframework.ai.client.Generation;

import java.util.List;

public interface PromptGenerator {
   String generate(String style, String imageQuality, String numberOfPrompt);
}
