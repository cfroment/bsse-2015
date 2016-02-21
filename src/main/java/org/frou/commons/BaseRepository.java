package org.frou.commons;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by Corentin on 13-novembre-14.
 */
public abstract class BaseRepository<T, PK> {

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
            clazz = null;
        }
    }

    public T find(PK primaryKey) {
        return entityManager.find(this.clazz, primaryKey);
    }

    public List<T> findAll() {
        return entityManager.createQuery("SELECT entity FROM " + clazz.getSimpleName() + " entity", clazz).getResultList();
    }

    protected EntityManager getEntityManager() {
        return entityManager;
    }
}
