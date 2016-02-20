package org.frou.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Corentin on 13-novembre-14.
 */
@Entity
@Table(name = "CRITERION")
public class Criterion {

    @Id
    @Column(name = "ID")
    @GeneratedValue
    private Long id;

    @Column(name = "WEIGHT", scale = 1)
    private BigDecimal weight;

    @OneToMany(mappedBy = "criterion")
    private List<Evaluation> relatedEvaluations;

    /**
     * Default constructor for the entity.
     */
    public Criterion() {
        // empty constructor.
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public List<Evaluation> getRelatedEvaluations() {
        return relatedEvaluations;
    }

    public void setRelatedEvaluations(List<Evaluation> relatedEvaluations) {
        this.relatedEvaluations = relatedEvaluations;
    }
}
