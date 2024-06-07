package com.Birth_Registration.Service;


import com.Birth_Registration.Model.DocumentSource;
import com.Birth_Registration.Repository.DocumentSourceRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class DocumentSourceServiceImpl implements DocumentSourceService {

    private final DocumentSourceRepository documentSourceRepository;

    @Override
    public List<DocumentSource> getAllDocumentSources() {
        return documentSourceRepository.findAll();
    }

    @Override
    public DocumentSource createDocumentSource(DocumentSource documentSource) {
        return documentSourceRepository.save(documentSource);
    }

    @Override
    public Optional<DocumentSource> getDocumentSourceById(Long id) {
        return documentSourceRepository.findById(id);
    }

    @Override
    public Optional<DocumentSource> updateDocumentSource(Long id, DocumentSource documentSourceDetails) {
        return documentSourceRepository.findById(id)
                .map(documentSource -> {
                    documentSource.setName(documentSourceDetails.getName());
                    documentSource.setVersion(documentSourceDetails.getVersion());
                    documentSource.setDescription(documentSourceDetails.getDescription());
                    documentSource.setOrganization(documentSourceDetails.getOrganization());
                    documentSource.setActive(documentSourceDetails.isActive());
                    return documentSourceRepository.save(documentSource);
                });
    }

    @Override
    public void deleteDocumentSource(Long id) {
        documentSourceRepository.findById(id)
                .ifPresent(documentSource -> {
                    documentSource.setActive(false);
                    documentSourceRepository.save(documentSource);
                });
    }
}
