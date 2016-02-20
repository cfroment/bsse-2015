package org.frou.repository;

import org.frou.commons.BaseRepository;
import org.frou.model.Candidate;
import org.frou.model.Criterion;
import org.frou.model.Evaluation;
import org.frou.model.Evaluator;

import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Corentin on 17-novembre-14.
 */
@Stateless
public class EvaluationRepository extends BaseRepository<Evaluation> {

    /**
     * Finds evaluations for a given Evaluator.
     *
     * @param evaluator an Evaluator.
     * @return a List of Evaluation entities.
     */
    public List<Evaluation> findEvaluations(Evaluator evaluator) {
        if (evaluator == null) {
            return new ArrayList<>();
        }
        String query = "SELECT e FROM Evaluation e WHERE e.evaluator.id = :evaluatorId";
        return getEntityManager().createQuery(query, Evaluation.class)
                .setParameter("evaluatorId", evaluator.getId())
                .getResultList();

    }

    /**
     * Finds evaluations for a given Candidate.
     *
     * @param candidate a Candidate.
     * @return a List of Evaluation entities.
     */
    public List<Evaluation> findEvaluations(Candidate candidate) {
        if (candidate == null) {
            return new ArrayList<>();
        }
        String query = "SELECT e FROM Evaluation e WHERE e.candidate.id = :candidateId";
        return getEntityManager().createQuery(query, Evaluation.class)
                .setParameter("candidateId", candidate.getId())
                .getResultList();
    }

    /**
     * Finds evaluations for a given Criterion.
     *
     * @param criterion a Criterion.
     * @return a List of Evaluation entities.
     */
    public List<Evaluation> findEvaluations(Criterion criterion) {
        if (criterion == null) {
            return new ArrayList<>();
        }
        String query = "SELECT e FROM Evaluation e WHERE e.criterion.id = :criterionId";
        return getEntityManager().createQuery(query, Evaluation.class)
                .setParameter("criterionId", criterion.getId())
                .getResultList();
    }

    public List<Evaluation> findEvaluationsForEvaluatorForCandidate(Long evaluatorId, Long candidateId) {
        if (evaluatorId == null || candidateId == null) {
            return new ArrayList<>();
        }
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT e ");
        sql.append("FROM Evaluation e ");
        sql.append("WHERE e.candidate.id = :candidateId ");
        sql.append("  AND e.evaluator.id = :evaluatorId ");
        sql.append("ORDER BY e.criterion.id ASC ");
        return getEntityManager().createQuery(sql.toString(), Evaluation.class)
                .setParameter("candidateId", candidateId)
                .setParameter("evaluatorId", evaluatorId).getResultList();
    }

    public void create(Evaluation evaluation) {
        if (evaluation == null) {
            return;
        }
        getEntityManager().persist(evaluation);
    }
}
