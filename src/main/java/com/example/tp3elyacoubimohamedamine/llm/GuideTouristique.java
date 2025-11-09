package com.example.tp3elyacoubimohamedamine.llm;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;

public interface GuideTouristique {

    @SystemMessage("""
        Tu es un guide touristique francophone.
        Donne exactement 2 endroits à visiter et le prix moyen d’un repas.
        Répond STRICTEMENT en JSON .
        Format :
        {
          "ville_ou_pays": "nom",
          "endroits_a_visiter": ["...", "..."],
          "prix_moyen_repas": "<prix> <devise>"
        }
        """)
    @UserMessage("Donne les informations touristiques sur {{lieu}}, avec {{nb}} endroits à visiter.")
    String guide(String lieu, int nb);
}
