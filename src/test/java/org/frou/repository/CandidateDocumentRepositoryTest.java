package org.frou.repository;

import org.frou.commons.BaseRepositoryTest;
import org.frou.model.CandidateDocument;
import org.frou.model.DocumentType;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.powermock.reflect.Whitebox;

import java.util.List;

public class CandidateDocumentRepositoryTest extends BaseRepositoryTest {

    private CandidateDocumentRepository repository;

    @Before
    public void init() {
        repository = new CandidateDocumentRepository();
        Whitebox.setInternalState(repository, entityManager);
    }

    @Test
    public void testSimpleFind() {
        CandidateDocument document = repository.find(-1l);
        Assert.assertNotNull(document);
        Assert.assertEquals(-1l, document.getCandidate().getId().longValue());
        Assert.assertEquals(DocumentType.CV, document.getDocumentType());
        Assert.assertEquals("http://bsse.example.com/cv1.pdf", document.getUrl());
    }

    @Test
    public void testGetDocumentOfType() throws Exception {
        List<CandidateDocument> documentList = repository.getDocumentOfType(DocumentType.CV);
        Assert.assertNotNull(documentList);
        Assert.assertEquals(1, documentList.size());
        Assert.assertFalse(documentList.stream().anyMatch(cd -> DocumentType.CV != cd.getDocumentType()));
    }

    @Test
    public void testGetDocumentsOfTypeWithNull() {
        List<CandidateDocument> documentList = repository.getDocumentOfType(null);
        Assert.assertNotNull(documentList);
        Assert.assertTrue(documentList.isEmpty());
    }
}