package com.gift.website.Repository;


import com.gift.website.Modal.Document;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepository extends JpaRepository<Document, Long> {
}

