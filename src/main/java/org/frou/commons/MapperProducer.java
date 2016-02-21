package org.frou.commons;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.frou.model.Evaluator;
import org.frou.service.Mapper;
import org.frou.service.MapperType;
import org.frou.vo.EvaluatorVO;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.enterprise.inject.Produces;
import java.util.HashMap;
import java.util.Map;

@Singleton
public class MapperProducer {

    private MapperFactory mapperFactory;
    private Map<MapperType, Boolean> registerdMappers;

    @PostConstruct
    public void init() {
        mapperFactory = new DefaultMapperFactory.Builder().build();
        registerdMappers = new HashMap<>();
    }

    @Produces
    @Mapper(type = MapperType.EVALUATOR)
    public MapperFacade produceMapper() {
        if (registerdMappers.containsKey(MapperType.EVALUATOR)) {
            registerEvaluatorMapper();
        }
        return mapperFactory.getMapperFacade();
    }

    private void registerEvaluatorMapper() {
        mapperFactory.classMap(Evaluator.class, EvaluatorVO.class)
                .byDefault()
                .exclude("password")
                .register();
        registerdMappers.put(MapperType.EVALUATOR, true);
    }

    public MapperFactory getMapperFactory() {
        return mapperFactory;
    }

    public Map<MapperType, Boolean> getRegisterdMappers() {
        return registerdMappers;
    }
}
