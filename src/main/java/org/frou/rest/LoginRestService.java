package org.frou.rest;

import org.codehaus.jackson.map.ObjectMapper;
import org.frou.model.Evaluator;
import org.frou.repository.EvaluatorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by C on 5/1/2015.
 */
@Path("/login")
public class LoginRestService {

    @Inject
    private EvaluatorRepository evaluatorRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginRestService.class);

    @POST
    @Consumes("*/*")
    public Response login(InputStream json) {
        LOGGER.info("Received JSON string");
        ObjectMapper objectMapper = new ObjectMapper();
        Evaluator evaluator = null;
        try {
            evaluator = objectMapper.readValue(json, Evaluator.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        LOGGER.info("Email: {}, Password: {}", evaluator.getEmail(), evaluator.getPassword());
        Evaluator confirmedEvaluator = evaluatorRepository.validate(evaluator.getEmail(), evaluator.getPassword());
        if (confirmedEvaluator == null) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }

        JsonArrayBuilder array = Json.createArrayBuilder();
        JsonObjectBuilder objectBuilder = Json.createObjectBuilder();
        objectBuilder.add("email", confirmedEvaluator.getEmail())
                .add("firstName", confirmedEvaluator.getFirstName())
                .add("lastName", confirmedEvaluator.getLastName())
                .add("id", confirmedEvaluator.getId());
        return Response.status(Response.Status.OK).entity(array.add(objectBuilder.build()).build()).build();
    }
}
