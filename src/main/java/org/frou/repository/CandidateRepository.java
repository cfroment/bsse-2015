package org.frou.repository;

import org.frou.commons.BaseRepository;
import org.frou.model.Candidate;

import javax.ejb.Stateless;
import java.util.List;

/**
 * Created by Corentin on 17-novembre-14.
 */
@Stateless
public class CandidateRepository extends BaseRepository<Candidate, Long> {

    /**
     * Gets all the Candidate entities.
     *
     * @return a List of Candidate.
     */
    public List<Candidate> getAllCandidates() {
        return findAll();
    }

    /**
     * Creates a new candidate.
     *
     * @param candidate a Candidate.
     */
    public void createCandidate(Candidate candidate) {
        candidate.setId(null);
        getEntityManager().persist(candidate);
    }

}
