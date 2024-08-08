package com.gift.website.Controller;



import com.gift.website.Modal.Document;
import com.gift.website.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class DocumentController {
    @Autowired
    private DocumentService documentService;

    @PostMapping("/addDocuments")
    public ResponseEntity<Document> addDocument(@RequestBody Document document) {
        Document newDocument = documentService.addDocument(document);
        return ResponseEntity.ok(newDocument);
    }

    @GetMapping("/getDocuments")
    public ResponseEntity<Optional<Document>> viewDocument(@RequestParam Long documentId) {
        Optional<Document> document = documentService.viewDocument(documentId);
        return ResponseEntity.ok(document);
    }

    @PostMapping("/editDocuments/{documentId}")
    public ResponseEntity<Document> editDocument(@PathVariable Long documentId, @RequestBody Document updatedDocument) {
        Document document = documentService.editDocument(documentId, updatedDocument);
        return ResponseEntity.ok(document);
    }

    @PostMapping("/deleteDocuments/{documentId}")
    public ResponseEntity<Void> deleteDocument(@PathVariable Long documentId) {
        documentService.deleteDocument(documentId);
        return ResponseEntity.ok().build();
    }
}
