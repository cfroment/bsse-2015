package org.frou.repository;

import org.frou.commons.BaseRepository;
import org.frou.model.CandidateDocument;
import org.frou.model.DocumentType;

import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Corentin on 17-novembre-14.
 */
@Stateless
public class CandidateDocumentRepository extends BaseRepository<CandidateDocument, Long> {

    /**
     * Gets all the CandidateDocument entites with the given DocumentType.
     *
     * @param documentType a DocumentType.
     * @return a List of CandidateDocument.
     */
    public List<CandidateDocument> getDocumentOfType(DocumentType documentType) {
        if (documentType == null) {
            return new ArrayList<>();
        }
        return getEntityManager().createQuery("SELECT cd FROM CandidateDocument cd WHERE cd.documentType = :documentType",
                                              CandidateDocument.class)
                                 .setParameter("documentType", documentType)
                                 .getResultList();
    }

}
