package org.frou.rest;

import org.frou.service.EvaluatorService;
import org.frou.vo.EvaluatorVO;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/evaluators")
public class EvaluatorRestService {

    @Inject
    private EvaluatorService evaluatorService;

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<EvaluatorVO> findAllEvaluators() {
        return evaluatorService.findAll();
    }

}
