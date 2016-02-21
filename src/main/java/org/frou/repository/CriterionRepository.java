package org.frou.repository;

import org.frou.commons.BaseRepository;
import org.frou.model.Criterion;

import javax.ejb.Stateless;
import java.util.List;

/**
 * Created by Corentin on 17-novembre-14.
 */
@Stateless
public class CriterionRepository extends BaseRepository<Criterion, Long> {

    /**
     * Gets all the criteria of the database, order by weight (descending order)
     *
     * @return a List of Criteria.
     */
    public List<Criterion> findAllCriteria() {
        String sql = "SELECT c FROM Criterion c ORDER BY c.weight DESC";
        return getEntityManager().createQuery(sql, Criterion.class).getResultList();
    }

}
