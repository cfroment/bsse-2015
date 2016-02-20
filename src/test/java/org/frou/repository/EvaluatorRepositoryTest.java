package org.frou.repository;

import org.frou.commons.BaseRepositoryTest;
import org.frou.model.Evaluator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.powermock.reflect.Whitebox;

public class EvaluatorRepositoryTest extends BaseRepositoryTest {

    private EvaluatorRepository repository;

    @Before
    public void initTest() {
        repository = new EvaluatorRepository();
        Whitebox.setInternalState(repository, entityManager);
    }

    @Test
    public void testSimpleFind() {
        Evaluator evaluator = repository.find(-1l);
        Assert.assertNotNull(evaluator);
        Assert.assertEquals("Corentin", evaluator.getFirstName());
        Assert.assertEquals("Froment", evaluator.getLastName());
        Assert.assertEquals("corentin.froment@gmail.com", evaluator.getEmail());
        Assert.assertEquals(6, evaluator.getEvaluations().size());
    }
}