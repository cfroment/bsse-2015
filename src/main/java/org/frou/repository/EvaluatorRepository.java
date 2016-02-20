package org.frou.repository;

import org.frou.commons.BaseRepository;
import org.frou.model.Evaluator;

import javax.ejb.Stateless;
import java.util.List;

/**
 * Created by Corentin on 13-novembre-14.
 */
@Stateless
public class EvaluatorRepository extends BaseRepository<Evaluator> {

    public Evaluator validate(String email, String password) {
        System.out.println("Entered validate with" +email + " "+password);
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT e FROM Evaluator e WHERE ");
        sql.append(" e.email = :email AND ");
        sql.append(" e.password = :password ");
        List<Evaluator> evaluators = getEntityManager().createQuery(sql.toString(), Evaluator.class).setParameter("email", email)
                .setParameter("password", password).getResultList();
        if (evaluators == null ||evaluators.isEmpty() || evaluators.size() > 1) {
            return null;
        }
        return evaluators.get(0);
    }
}
