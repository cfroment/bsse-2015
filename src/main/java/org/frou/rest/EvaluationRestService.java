package org.frou.rest;

import org.apache.commons.io.IOUtils;
import org.frou.model.Evaluation;
import org.frou.repository.EvaluationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by C on 4/30/2015.
 */
@Path("/evaluation")
public class EvaluationRestService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EvaluationRestService.class);

    @Inject
    private EvaluationRepository evaluationRepository;


    @GET
    @Path("/{evaluator}/{candidate}")
    @Produces(MediaType.APPLICATION_JSON)
    public JsonArray findEvaluation(@PathParam("evaluator") Long evaluatorId, @PathParam("candidate") Long candidateId) {
        JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
        List<Evaluation> evaluations = evaluationRepository
                .findEvaluationsForEvaluatorForCandidate(evaluatorId, candidateId);
        evaluations.stream().forEach(evaluation -> {
            arrayBuilder.add(Json.createObjectBuilder()
                                     .add("score", evaluation.getScore())
                                     .add("criterionId", evaluation.getCriterion().getId())
                                     .add("criterionWeight", evaluation.getCriterion().getWeight())
                                     .add("comment", evaluation.getComment())
                                     .build());
        });
        return arrayBuilder.build();
    }

    @POST
    @Path("/create/{evaluator}/{candidate}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createEvaluation(@PathParam("evaluator") Long evaluatorId, @PathParam("candidate") Long candidateId,
                                     InputStream inputStream)
            throws IOException {
        StringWriter writer = new StringWriter();
        IOUtils.copy(inputStream, writer);
        parseEvaluations(writer.toString()).forEach(evaluationRepository::create);
        return Response.status(Response.Status.ACCEPTED).build();
    }

    private List<Evaluation> parseEvaluations(String jsonEvaluations) {
        return new ArrayList<>();
    }

}
