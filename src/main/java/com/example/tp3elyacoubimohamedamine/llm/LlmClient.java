package com.example.tp3elyacoubimohamedamine.llm;

import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.googleai.GoogleAiGeminiChatModel;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.service.AiServices;
import jakarta.enterprise.context.Dependent;

@Dependent
public class LlmClient {

    private final GuideTouristique assistant;

    public LlmClient() {
        String apiKey = System.getenv("GEMINI_KEY");
        if (apiKey == null || apiKey.isBlank()) {
            throw new IllegalStateException("Variable GEMINI_KEY manquante !");
        }

        ChatModel model = GoogleAiGeminiChatModel.builder()
                .apiKey(apiKey)
                .modelName("gemini-2.0-flash-exp")
                .temperature(0.3)
                .logRequestsAndResponses(true)
                .build();

        var memory = MessageWindowChatMemory.withMaxMessages(10);

        this.assistant = AiServices.builder(GuideTouristique.class)
                .chatModel(model)
                .chatMemory(memory)
                .build();
    }

    public String getInfos(String lieu, int nb) {
        if (nb <= 0) nb = 2;
        return assistant.guide(lieu, nb);
    }
}
