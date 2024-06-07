package com.Birth_Registration.Controller;

import com.Birth_Registration.Model.DocumentSource;
import com.Birth_Registration.Service.DocumentSourceService;
import lombok.RequiredArgsConstructor;
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

    @GetMapping("/getAll")
    public List<DocumentSource> getAllDocumentSources() {
        return documentSourceService.getAllDocumentSources();
    }

    @PostMapping("/create")
    public DocumentSource createDocumentSource(@RequestBody DocumentSource documentSource) {
        return documentSourceService.createDocumentSource(documentSource);
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
