package com.Birth_Registration.Service;


import com.Birth_Registration.Model.DocumentDetails;
import com.Birth_Registration.Model.DocumentSource;
import com.Birth_Registration.Repository.DocumentDetailsRepository;
import com.Birth_Registration.Repository.DocumentSourceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DocumentDetailsServiceImpl implements DocumentDetailsService {

    private final DocumentDetailsRepository documentDetailsRepository;
    private final DocumentSourceRepository documentSourceRepository;

    @Override
    public List<DocumentDetails> getAllDocumentDetails() {
        return documentDetailsRepository.findAll();
    }

    @Override
    public Optional<DocumentDetails> createDocumentDetails(DocumentDetails documentDetails) {
        Optional<DocumentSource> documentSource = documentSourceRepository.findById(documentDetails.getDocumentSource().getId());
        if (documentSource.isEmpty()) {
            return Optional.empty();
        }
        documentDetails.setDocumentSource(documentSource.get());
        return Optional.of(documentDetailsRepository.save(documentDetails));
    }

    @Override
    public Optional<DocumentDetails> getDocumentDetailsById(Long id) {
        return documentDetailsRepository.findById(id);
    }

    @Override
    public Optional<DocumentDetails> updateDocumentDetails(Long id, DocumentDetails documentDetailsDetails) {
        return documentDetailsRepository.findById(id)
                .map(documentDetails -> {
                    documentDetails.setDocNo(documentDetailsDetails.getDocNo());
                    documentDetails.setExternalRef(documentDetailsDetails.getExternalRef());
                    documentDetails.setStartNo(documentDetailsDetails.getStartNo());
                    documentDetails.setEndNo(documentDetailsDetails.getEndNo());
                    documentDetails.setAmount(documentDetailsDetails.getAmount());
                    documentDetails.setUploadDate(documentDetailsDetails.getUploadDate());
                    documentDetails.setBankAccount(documentDetailsDetails.isBankAccount());
                    return documentDetailsRepository.save(documentDetails);
                });
    }

    @Override
    public void deleteDocumentDetails(Long id) {
        documentDetailsRepository.findById(id)
                .ifPresent(documentDetailsRepository::delete);
    }
}
