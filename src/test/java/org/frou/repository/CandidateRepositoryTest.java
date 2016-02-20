package org.frou.repository;

import org.frou.commons.BaseRepositoryTest;
import org.frou.model.Candidate;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.powermock.reflect.Whitebox;

import java.util.List;

public class CandidateRepositoryTest extends BaseRepositoryTest {

    private CandidateRepository repository;

    @Before
    public void init() {
        repository = new CandidateRepository();
        Whitebox.setInternalState(repository, entityManager);
    }

    @Test
    public void testSimpleFind() {
        Candidate candidate = repository.find(-1l);
        Assert.assertNotNull(candidate);
        Assert.assertEquals(6, candidate.getEvaluations().size());
        Assert.assertEquals(2, candidate.getDocuments().size());

        long sumOfFirstCriterionForCandidate1 = candidate.getEvaluations().stream()
                .filter(e -> e.getCriterion().getId().equals(-1l))
                .count();
        Assert.assertEquals(2l, sumOfFirstCriterionForCandidate1);
    }

    @Test
    public void testGetAllCandidates() throws Exception {
        List<Candidate> candidates = repository.getAllCandidates();
        Assert.assertNotNull(candidates);
        Assert.assertEquals(2, candidates.size());
    }
}