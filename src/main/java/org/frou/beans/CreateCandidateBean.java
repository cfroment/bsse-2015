package org.frou.beans;

import org.frou.model.Candidate;
import org.frou.repository.CandidateRepository;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.io.IOException;

/**
 * Created by Corentin on 17-novembre-14.
 */
@ManagedBean
@ViewScoped
public class CreateCandidateBean {

    @Inject
    private CandidateRepository repository;

    private Candidate candidate;

    public void init() {
        if (FacesContext.getCurrentInstance().isPostback()) {
            return;
        }
        candidate = new Candidate();
    }

    public void createCandidate() throws IOException {
        repository.createCandidate(candidate);
        FacesContext.getCurrentInstance().getExternalContext().redirect("../candidates.xhtml");
    }

    public Candidate getCandidate() {
        return candidate;
    }

}
