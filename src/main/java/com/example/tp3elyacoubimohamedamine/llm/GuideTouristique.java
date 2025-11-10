package com.example.tp3elyacoubimohamedamine.llm;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.V;

public interface GuideTouristique {

    @SystemMessage("""
        Tu es un guide touristique francophone.
        Donne exactement {{nb}} endroits à visiter et le prix moyen d’un repas.
        Réponds STRICTEMENT en JSON au format :
        {
          "ville_ou_pays": "nom de la ville ou du pays",
          "endroits_a_visiter": ["endroit 1", "endroit 2"],
          "prix_moyen_repas": "<prix> <devise>"
        }
        """)
    @UserMessage("Fournis les informations touristiques pour {{lieu}} en proposant {{nb}} endroits à visiter.")
    String guide(@V("lieu") String lieu, @V("nb") int nb);
}
