package org.frou.beans;

import org.frou.model.Candidate;
import org.frou.repository.CandidateRepository;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.util.List;

/**
 * Created by Corentin on 17-novembre-14.
 */
@ManagedBean
@ViewScoped
public class CandidatesViewBean {

    @Inject
    private CandidateRepository candidateRepository;

    private List<Candidate> candidates;

    public CandidatesViewBean() {
        // empty constructor, do nothing.
    }

    public void init() {
        if (FacesContext.getCurrentInstance().isPostback()) {
            return;
        }
        candidates = candidateRepository.getAllCandidates();
    }

    public List<Candidate> getCandidates() {
        return candidates;
    }

}
