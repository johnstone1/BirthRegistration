package com.Birth_Registration.Service;


import com.Birth_Registration.Model.DocumentSource;

import java.util.List;
import java.util.Optional;

public interface DocumentSourceService {
    List<DocumentSource> getAllDocumentSources();
    DocumentSource createDocumentSource(DocumentSource documentSource);
    Optional<DocumentSource> getDocumentSourceById(Long id);
    Optional<DocumentSource> updateDocumentSource(Long id, DocumentSource documentSourceDetails);
    public void deleteDocumentSource(Long id);
}
