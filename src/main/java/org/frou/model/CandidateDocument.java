package org.frou.model;

import javax.persistence.*;

/**
 * Created by Corentin on 17-novembre-14.
 */
@Entity
@Table(name = "CANDIDATE_DOCUMENT")
public class CandidateDocument {

    @Id
    @Column(name = "ID")
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "CANDIDATE_ID")
    private Candidate candidate;

    @Column(name = "DOCUMENT_TYPE")
    @Enumerated(EnumType.STRING)
    private DocumentType documentType;

    @Column(name = "URL")
    private String url;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }

    public DocumentType getDocumentType() {
        return documentType;
    }

    public void setDocumentType(DocumentType documentType) {
        this.documentType = documentType;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
