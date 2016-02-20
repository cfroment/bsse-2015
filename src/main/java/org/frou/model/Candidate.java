package org.frou.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Corentin on 13-novembre-14.
 */
@Entity
@Table(name = "CANDIDATE")
public class Candidate {

    @Id
    @Column(name = "ID")
    @GeneratedValue
    private Long id;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "DESTINATION")
    private String destination;

    @OneToMany(mappedBy = "candidate")
    private List<Evaluation> evaluations;

    @OneToMany(mappedBy = "candidate", fetch = FetchType.EAGER)
    private List<CandidateDocument> documents;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Evaluation> getEvaluations() {
        return evaluations;
    }

    public void setEvaluations(List<Evaluation> evaluations) {
        this.evaluations = evaluations;
    }

    public List<CandidateDocument> getDocuments() {
        if (documents == null) {
            documents = new ArrayList<>();
        }
        return documents;
    }

    public void setDocuments(List<CandidateDocument> documents) {
        this.documents = documents;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public CandidateDocument getCv() {
        return getDocuments().stream()
                .filter(d -> DocumentType.CV.equals(d.getDocumentType()))
                .findFirst().orElse(null);
    }

    public CandidateDocument getMotivation() {
        return getDocuments().stream()
                .filter(d -> DocumentType.MOTIVATION.equals(d.getDocumentType()))
                .findFirst().orElse(null);
    }
}
