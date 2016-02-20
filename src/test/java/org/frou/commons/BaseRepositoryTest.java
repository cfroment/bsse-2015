package org.frou.commons;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by Corentin on 13-novembre-14.
 */
public class BaseRepositoryTest {

    protected static EntityManager entityManager;
    private static EntityManagerFactory entityManagerFactory;

    @BeforeClass
    public static void initClass() {
        entityManagerFactory = Persistence.createEntityManagerFactory("test");
        entityManager = entityManagerFactory.createEntityManager();
    }


    @AfterClass
    public static void cleanClass() {
        if (entityManager !=null){
            entityManager.close();
        }
        if (entityManagerFactory != null) {
            entityManagerFactory.close();
        }
    }
}
