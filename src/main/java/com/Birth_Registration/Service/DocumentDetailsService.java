package com.Birth_Registration.Service;


import com.Birth_Registration.Model.DocumentDetails;

import java.util.List;
import java.util.Optional;

public interface DocumentDetailsService {
    List<DocumentDetails> getAllDocumentDetails();
    Optional<DocumentDetails> createDocumentDetails(DocumentDetails documentDetails);
    Optional<DocumentDetails> getDocumentDetailsById(Long id);
    Optional<DocumentDetails> updateDocumentDetails(Long id, DocumentDetails documentDetailsDetails);
    void deleteDocumentDetails(Long id);
}
