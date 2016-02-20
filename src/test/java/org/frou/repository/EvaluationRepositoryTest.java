package org.frou.repository;

import org.frou.commons.BaseRepositoryTest;
import org.frou.model.Candidate;
import org.frou.model.Criterion;
import org.frou.model.Evaluation;
import org.frou.model.Evaluator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.powermock.reflect.Whitebox;

import java.math.BigDecimal;
import java.util.List;

public class EvaluationRepositoryTest extends BaseRepositoryTest {

    private EvaluationRepository evaluationRepository;

    @Before
    public void init(){
        evaluationRepository = new EvaluationRepository();
        Whitebox.setInternalState(evaluationRepository, entityManager);
    }

    @Test
    public void testSimpleFind() {
        Evaluation evaluation = evaluationRepository.find(-1l);
        Assert.assertNotNull(evaluation);
        Assert.assertEquals(-1l, evaluation.getEvaluator().getId().longValue());
        Assert.assertEquals(-1l, evaluation.getCandidate().getId().longValue());
        Assert.assertEquals(new BigDecimal("0.50"), evaluation.getCriterion().getWeight());
    }

    @Test
    public void testFindEvaluationsWithEvaluator() throws Exception {
        Evaluator evaluator = new Evaluator();
        evaluator.setId(-1l);

        List<Evaluation> evaluationList = evaluationRepository.findEvaluations(evaluator);
        Assert.assertNotNull(evaluationList);
        Assert.assertTrue(!evaluationList.isEmpty());
        Assert.assertEquals(6, evaluationList.size());
    }

    @Test
    public void testFindEvaluationsWithCandidate() throws Exception {
        Candidate candidate1 = new Candidate();
        candidate1.setId(-1l);

        List<Evaluation> evaluations = evaluationRepository.findEvaluations(candidate1);
        Assert.assertNotNull(evaluations);

        Candidate candidate2 = new Candidate();
        candidate2.setId(-2l);

        List<Evaluation> evaluations2 = evaluationRepository.findEvaluations(candidate2);
        Assert.assertNotNull(evaluations2);
        Assert.assertEquals(3, evaluations2.size());
    }

    @Test
    public void testFindEvaluationsWithCriterion() throws Exception {
        Criterion crit1 = new Criterion();
        crit1.setId(-1l);

        List<Evaluation> evaluations = evaluationRepository.findEvaluations(crit1);
        Assert.assertNotNull(evaluations);
        Assert.assertEquals(3, evaluations.size());

        Criterion crit2 = new Criterion();
        crit2.setId(-2l);

        List<Evaluation> evaluations2 = evaluationRepository.findEvaluations(crit2);
        Assert.assertNotNull(evaluations2);
        Assert.assertEquals(3, evaluations2.size());
    }
}