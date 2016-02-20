package org.frou.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Corentin on 13-novembre-14.
 */
@Entity
@Table(name = "EVALUATION")
public class Evaluation {

    @Id
    @Column(name = "ID")
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "CRITERION_ID")
    private Criterion criterion;

    @ManyToOne
    @JoinColumn(name = "EVALUATOR_ID")
    private Evaluator evaluator;

    @ManyToOne
    @JoinColumn(name = "CANDIDATE_ID")
    private Candidate candidate;

    @Column(name = "SCORE",scale = 1)
    private BigDecimal score;

    @Column(name = "COMMENT", length = 100)
    private String comment;

    @Column(name = "LAST_MODIFICATION_DATE", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModificationDate;

    /**
     * Default constructor for the entity.
     */
    public Evaluation() {
        // empty constructor.
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Criterion getCriterion() {
        return criterion;
    }

    public void setCriterion(Criterion criterion) {
        this.criterion = criterion;
    }

    public Evaluator getEvaluator() {
        return evaluator;
    }

    public void setEvaluator(Evaluator evaluator) {
        this.evaluator = evaluator;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }

    public BigDecimal getScore() {
        return score;
    }

    public void setScore(BigDecimal score) {
        this.score = score;
    }

    public Date getLastModificationDate() {
        return lastModificationDate;
    }

    public void setLastModificationDate(Date lastModificationDate) {
        this.lastModificationDate = lastModificationDate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
