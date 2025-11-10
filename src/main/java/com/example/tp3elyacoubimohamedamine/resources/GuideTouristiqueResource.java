package com.example.tp3elyacoubimohamedamine.resources;

import com.example.tp3elyacoubimohamedamine.llm.LlmClient;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/guide")
@Produces(MediaType.APPLICATION_JSON)
public class GuideTouristiqueResource {

    @Inject
    LlmClient llm;

    @GET
    @Path("lieu/{ville_ou_pays}")
    public Response villeOuPays(@PathParam("ville_ou_pays") String lieu,
                                @QueryParam("nb") @DefaultValue("2") int nb) {
        String json = llm.getInfos(lieu, nb);
        return Response.ok(json).build();
    }

    @GET
    @Path("lieu/{ville_ou_pays}/{nb}")
    public Response villeOuPaysAvecNb(@PathParam("ville_ou_pays") String lieu,
                                      @PathParam("nb") int nb) {
        String json = llm.getInfos(lieu, nb);
        return Response.ok(json).build();
    }
}
