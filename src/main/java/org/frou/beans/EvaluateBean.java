package org.frou.beans;

import org.frou.model.Criterion;
import org.frou.repository.CriterionRepository;

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
public class EvaluateBean {

    private Long candidateId;
    private List<Criterion> criteria;

    @Inject
    private CriterionRepository criterionRepository;


    public void init() {
        if (FacesContext.getCurrentInstance().isPostback()) {
            return;
        }
        criteria = criterionRepository.findAllCriteria();
    }

    public Long getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(Long candidateId) {
        this.candidateId = candidateId;
    }

    public List<Criterion> getCriteria() {
        return criteria;
    }
}
