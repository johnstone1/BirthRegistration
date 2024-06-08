package com.Birth_Registration.Controller;
import com.Birth_Registration.Dtos.BirthRegistrationDTO;
import com.Birth_Registration.Dtos.DeathNotificationDto;
import com.Birth_Registration.Dtos.DeathRegistrationDTO;
import com.Birth_Registration.Dtos.UpdateChildNameDto;
import com.Birth_Registration.Model.BirthRegistration;
import com.Birth_Registration.Model.DeathNotification;
import com.Birth_Registration.Model.DeathRegistration;
import com.Birth_Registration.Model.DocumentDetails;
import com.Birth_Registration.Service.DocumentDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/api/documentDetails")
public class DocumentDetailsController {

    private final DocumentDetailsService documentDetailsService;


    @GetMapping("/getAllDocumentDetails")
    public List<DocumentDetails> getAllDocumentDetails() {
        return documentDetailsService.getAllDocumentDetails();
    }

    @PostMapping("/createDocumentDetails")
    public ResponseEntity<DocumentDetails> createDocumentDetails(@RequestBody DocumentDetails documentDetails) {
        Optional<DocumentDetails> savedDocumentDetails = documentDetailsService.createDocumentDetails(documentDetails);
        return savedDocumentDetails
                .map(details -> ResponseEntity.status(HttpStatus.CREATED).body(details))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null));
    }


    @PostMapping("/registerBirth")
    public ResponseEntity<BirthRegistration> registerBirth(@RequestBody BirthRegistrationDTO birthRegistrationDto) {
        BirthRegistration birthRegistration = documentDetailsService.registerBirth(birthRegistrationDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(birthRegistration);
    }
    @PutMapping("/updateChildName")
    public ResponseEntity<BirthRegistration> updateChildName(@RequestBody UpdateChildNameDto updateChildNameDto) {
        BirthRegistration updatedRegistration = documentDetailsService.updateChildName(updateChildNameDto);
        if (updatedRegistration != null) {
            return ResponseEntity.ok(updatedRegistration);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
    @PostMapping("/registerDeath")
    public ResponseEntity<DeathRegistration> registerDeath(@RequestBody DeathRegistrationDTO deathRegistrationDto) {
        DeathRegistration deathRegistration = documentDetailsService.registerDeath(deathRegistrationDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(deathRegistration);
    }
    @PostMapping("/notifyDeath")
    public ResponseEntity<DeathNotification> notifyDeath(@RequestBody DeathNotificationDto deathNotificationDto) {
        DeathNotification deathNotification = documentDetailsService.notifyDeath(deathNotificationDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(deathNotification);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<DocumentDetails> getDocumentDetailsById(@PathVariable Long id) {
        Optional<DocumentDetails> documentDetails = documentDetailsService.getDocumentDetailsById(id);
        return documentDetails.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/updateDocumentDetails/{id}")
    public ResponseEntity<DocumentDetails> updateDocumentDetails(@PathVariable Long id, @RequestBody DocumentDetails documentDetailsDetails) {
        return documentDetailsService.updateDocumentDetails(id, documentDetailsDetails)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/deleteDocumentDetails/{id}")
    public ResponseEntity<Object> deleteDocumentDetails(@PathVariable Long id) {
        documentDetailsService.deleteDocumentDetails(id);
        return ResponseEntity.noContent().build();
    }
}
