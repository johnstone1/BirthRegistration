package com.Birth_Registration.Controller;

import com.Birth_Registration.Dtos.DocumentRegistrationDto;
import com.Birth_Registration.Model.DocumentDetails;
import com.Birth_Registration.Model.DocumentSource;
import com.Birth_Registration.Service.DocumentDetailsService;
import com.Birth_Registration.Service.DocumentSourceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/documentSource")
@CrossOrigin("*")
@RequiredArgsConstructor
public class DocumentSourceController {

    private final DocumentSourceService documentSourceService;
    private  final DocumentDetailsService documentDetailsService;

    @GetMapping("/getAll")
    public List<DocumentSource> getAllDocumentSources() {
        return documentSourceService.getAllDocumentSources();
    }

    @PostMapping("/create")
    public DocumentSource createDocumentSource(@RequestBody DocumentSource documentSource) {
        return documentSourceService.createDocumentSource(documentSource);
    }

    @PostMapping("/DocumentRegistration")
    public ResponseEntity<DocumentDetails> registerDocument(@RequestBody DocumentRegistrationDto documentRegistrationDto) {
        DocumentSource documentSource = new DocumentSource();
        documentSource.setName(documentRegistrationDto.getDocumentSourceName());
        documentSource.setVersion(documentRegistrationDto.getVersion());
        documentSource.setDescription(documentRegistrationDto.getDescription());
        documentSource.setOrganization(documentRegistrationDto.getOrganization());
        documentSource.setActive(true);

        DocumentSource savedDocumentSource = documentSourceService.createDocumentSource(documentSource);

        DocumentDetails documentDetails = new DocumentDetails();
        documentDetails.setDocumentSource(savedDocumentSource);
        documentDetails.setDocNo(documentRegistrationDto.getDocNo());
        documentDetails.setName(documentRegistrationDto.getName());
        documentDetails.setExternalRef(documentRegistrationDto.getExternalRef());
        documentDetails.setStartNo(documentRegistrationDto.getStartNo());
        documentDetails.setEndNo(documentRegistrationDto.getEndNo());
        documentDetails.setAmount(documentRegistrationDto.getAmount());
        documentDetails.setUploadDate(documentRegistrationDto.getUploadDate());
        documentDetails.setBankAccount(documentRegistrationDto.isBankAccount());

        Optional<DocumentDetails> savedDocumentDetails = documentDetailsService.createDocumentDetails(documentDetails);

        return savedDocumentDetails
                .map(details -> ResponseEntity.status(HttpStatus.CREATED).body(details))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null));
    }



    @GetMapping("/getById/{id}")
    public ResponseEntity<DocumentSource> getDocumentSourceById(@PathVariable Long id) {
        Optional<DocumentSource> documentSource = documentSourceService.getDocumentSourceById(id);
        return documentSource.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<DocumentSource> updateDocumentSource(@PathVariable Long id, @RequestBody DocumentSource documentSourceDetails) {
        return documentSourceService.updateDocumentSource(id, documentSourceDetails)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteDocumentSource(@PathVariable Long id) {
        documentSourceService.deleteDocumentSource(id);
        return ResponseEntity.noContent().build();
    }
}
