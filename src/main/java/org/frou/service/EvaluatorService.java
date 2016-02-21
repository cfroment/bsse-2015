package org.frou.service;

import ma.glasnost.orika.MapperFacade;
import org.frou.repository.EvaluatorRepository;
import org.frou.vo.EvaluatorVO;

import javax.inject.Inject;
import java.util.List;

public class EvaluatorService {

    @Inject
    @Mapper(type = MapperType.EVALUATOR)
    private MapperFacade mapperFacade;

    @Inject
    private EvaluatorRepository evaluatorRepository;

    public List<EvaluatorVO> findAll() {
        return mapperFacade.mapAsList(evaluatorRepository.findAll(), EvaluatorVO.class);
    }

}
