package org.frou.rest;

import org.frou.model.Candidate;
import org.frou.repository.CandidateRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 *
 */
@Path("/candidates")
public class CandidateRestService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CandidateRestService.class);

    @Inject
    private CandidateRepository candidateRepository;

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public JsonArray getAllCandidates() {
        LOGGER.info("Getting all the candidates.");
        List<Candidate> candidates = candidateRepository.getAllCandidates();
        JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();

        candidates.stream().forEach(candidate -> arrayBuilder.add(Json.createObjectBuilder()
                .add("firstName", candidate.getFirstName())
                .add("lastName", candidate.getLastName())
                .add("destination", candidate.getDestination())
                .add("id", candidate.getId())));

        return arrayBuilder.build();
    }
}
