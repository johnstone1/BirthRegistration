package com.Birth_Registration.Service;
import com.Birth_Registration.Dtos.BirthRegistrationDTO;
import com.Birth_Registration.Dtos.DeathNotificationDto;
import com.Birth_Registration.Dtos.DeathRegistrationDTO;
import com.Birth_Registration.Dtos.UpdateChildNameDto;
import com.Birth_Registration.Model.BirthRegistration;
import com.Birth_Registration.Model.DeathNotification;
import com.Birth_Registration.Model.DeathRegistration;
import com.Birth_Registration.Model.DocumentDetails;

import java.util.List;
import java.util.Optional;

public interface DocumentDetailsService {
    List<DocumentDetails> getAllDocumentDetails();
    Optional<DocumentDetails> createDocumentDetails(DocumentDetails documentDetails);
    Optional<DocumentDetails> getDocumentDetailsById(Long id);
    Optional<DocumentDetails> updateDocumentDetails(Long id, DocumentDetails documentDetailsDetails);
    void deleteDocumentDetails(Long id);
    BirthRegistration registerBirth(BirthRegistrationDTO birthRegistrationDto);
    BirthRegistration updateChildName(UpdateChildNameDto updateChildNameDto);

    DeathRegistration registerDeath(DeathRegistrationDTO deathRegistrationDto);

    DeathNotification notifyDeath(DeathNotificationDto deathNotificationDto);
}
