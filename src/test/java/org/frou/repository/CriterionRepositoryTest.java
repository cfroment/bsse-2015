package org.frou.repository;

import org.frou.commons.BaseRepositoryTest;
import org.frou.model.Criterion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.powermock.reflect.Whitebox;

import java.math.BigDecimal;

public class CriterionRepositoryTest extends BaseRepositoryTest {

    private CriterionRepository repository;

    @Before
    public void init() {
        repository = new CriterionRepository();
        Whitebox.setInternalState(repository, entityManager);
    }

    @Test
    public void testSimpleFind() {
        Criterion criterion = repository.find(-1l);
        Assert.assertNotNull(criterion);
        Assert.assertEquals(new BigDecimal("0.50"), criterion.getWeight());
        Assert.assertEquals(3, criterion.getRelatedEvaluations().size());
    }

}