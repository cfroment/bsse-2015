package org.frou.commons;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by Corentin on 13-novembre-14.
 */
public abstract class BaseRepository<T> {

    @PersistenceContext(name = "ApplicationPersistenceUnit")
    private EntityManager entityManager;

    private final Class<T> clazz;

    protected BaseRepository() {
        Type genericSuperClass = this.getClass().getGenericSuperclass();
        if (genericSuperClass instanceof ParameterizedType) {
            ParameterizedType pt = (ParameterizedType) genericSuperClass;
            Type[] fieldArgTypes = pt.getActualTypeArguments();
            clazz = (Class<T>) fieldArgTypes[0];
        } else {
            clazz=null;
        }
    }

    public T find(Object primaryKey) {
        return entityManager.find(this.clazz, primaryKey);
    }

    protected EntityManager getEntityManager() {
        return entityManager;
    }
}
