package org.frou.rest;

import org.frou.model.Criterion;
import org.frou.repository.CriterionRepository;

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
 * Created by Corentin on 4/22/2015.
 */
@Path(value = "/criteria")
public class CriterionRestService {

    @Inject
    private CriterionRepository criterionRepository;

    @GET
    @Path(value = "/all")
    @Produces(MediaType.APPLICATION_JSON)
    public JsonArray findAllCriteria() {
        List<Criterion> criteria = criterionRepository.findAllCriteria();
        JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
        criteria.stream().forEach(criterion -> arrayBuilder.add(Json.createObjectBuilder().add("weight", criterion.getWeight())));
        return arrayBuilder.build();
    }

    private static CriterionDto mapCriterion(Criterion criterion) {
        CriterionDto dto = new CriterionDto();
        dto.setId(criterion.getId());
        dto.setWeight(criterion.getWeight().doubleValue());
        return dto;
    }

    public static class CriterionDto {
        private Long id;
        private Double weight;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public Double getWeight() {
            return weight;
        }

        public void setWeight(Double weight) {
            this.weight = weight;
        }
    }

}
