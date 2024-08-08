package com.gift.website.service;



import com.gift.website.Modal.Document;
import com.gift.website.Repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DocumentService {
    @Autowired
    private DocumentRepository documentRepository;

    public Document addDocument(Document document) {
        return documentRepository.save(document);
    }

    public Optional<Document> viewDocument(Long documentId) {
        return documentRepository.findById(documentId);
    }

    public Document editDocument(Long documentId, Document updatedDocument) {
        return documentRepository.findById(documentId)
            .map(document -> {
                document.setTitle(updatedDocument.getTitle());
                document.setDescription(updatedDocument.getDescription());
                document.setFilePath(updatedDocument.getFilePath());
                return documentRepository.save(document);
            }).orElseGet(() -> {
                updatedDocument.setId(documentId);
                return documentRepository.save(updatedDocument);
            });
    }

    public void deleteDocument(Long documentId) {
        documentRepository.deleteById(documentId);
    }
}
