package org.frou.rest;

import org.frou.model.Criterion;
import org.frou.repository.CriterionRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by C on 4/22/2015.
 */
@RunWith(PowerMockRunner.class)
public class CriterionRestServiceTest {

    private CriterionRestService criterionRestService;

    @Mock
    private CriterionRepository criterionRepository;

    @Before
    public void setUp() throws Exception {
        criterionRestService = new CriterionRestService();
        Whitebox.setInternalState(criterionRestService, criterionRepository);

        PowerMockito.when(criterionRepository.findAllCriteria()).then(invocationOnMock -> {
            List<Criterion> criterionList = new ArrayList<>();
            criterionList.add(buildCriterion(new Random().nextDouble()));
            return criterionList;
        });
    }

    private Criterion buildCriterion(double doubleValue) {
        Criterion criterion = new Criterion();
        criterion.setWeight(BigDecimal.valueOf(doubleValue).setScale(2, RoundingMode.HALF_UP));
        return criterion;
    }

    @Test
    public void testFindAllCriteria() throws Exception {
        System.out.println(criterionRestService.findAllCriteria().toString());
    }

}
