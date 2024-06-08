package com.Birth_Registration.Service;

import com.Birth_Registration.Dtos.BirthRegistrationDTO;
import com.Birth_Registration.Dtos.DeathNotificationDto;
import com.Birth_Registration.Dtos.DeathRegistrationDTO;
import com.Birth_Registration.Dtos.UpdateChildNameDto;
import com.Birth_Registration.Model.*;
import com.Birth_Registration.Repository.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class DocumentDetailsServiceImpl implements DocumentDetailsService {

    private final DocumentDetailsRepository documentDetailsRepository;
    private final DocumentSourceRepository documentSourceRepository;
    private final BirthRegistrationRepository birthRegistrationRepository;
    private final DeathRegistrationRepository deathRegistrationRepository;
    private final DeathNotificationRepository deathNotificationRepository;

    @Override
    public List<DocumentDetails> getAllDocumentDetails() {
        return documentDetailsRepository.findAll();
    }

    @Override
    public Optional<DocumentDetails> createDocumentDetails(DocumentDetails documentDetails) {
        log.info("Creating DocumentDetails: {}", documentDetails);
        Optional<DocumentSource> documentSource = documentSourceRepository.findById(documentDetails.getDocumentSource().getId());
        if (documentSource.isEmpty()) {
            log.error("DocumentSource with id {} not found", documentDetails.getDocumentSource().getId());
            return Optional.empty();
        }
        documentDetails.setDocumentSource(documentSource.get());
        DocumentDetails savedDocumentDetails = documentDetailsRepository.save(documentDetails);
        log.info("DocumentDetails created successfully: {}", savedDocumentDetails);
        return Optional.of(savedDocumentDetails);
    }


    @Override
    public Optional<DocumentDetails> getDocumentDetailsById(Long id) {
        return documentDetailsRepository.findById(id);
    }

    @Override
    public Optional<DocumentDetails> updateDocumentDetails(Long id, DocumentDetails documentDetailsDetails) {
        return documentDetailsRepository.findById(id)
                .map(documentDetails -> {
                    documentDetails.setName(documentDetailsDetails.getName());
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

    @Override
    public BirthRegistration registerBirth(BirthRegistrationDTO birthRegistrationDto) {
        BirthRegistration birthRegistration = new BirthRegistration();
        birthRegistration.setNewChild(birthRegistrationDto.isNewChild());
        birthRegistration.setNameOfChild(birthRegistrationDto.getNameOfChild());
        birthRegistration.setRegistrationNo(birthRegistrationDto.getRegistrationNo());
        birthRegistration.setPlaceOfBirth(birthRegistrationDto.getPlaceOfBirth());
        birthRegistration.setNextOfKin(birthRegistrationDto.getNextOfKin());
        birthRegistration.setMale(birthRegistrationDto.isMale());
        birthRegistration.setFemale(birthRegistrationDto.isFemale());
        birthRegistration.setSingle(birthRegistrationDto.isSingle());
        birthRegistration.setTwin(birthRegistrationDto.isTwin());
        birthRegistration.setBornAlive(birthRegistrationDto.isBornAlive());
        birthRegistration.setDead(birthRegistrationDto.isDead());
        birthRegistration.setDate(birthRegistrationDto.getDate());
        birthRegistration.setBirthDate(birthRegistrationDto.getBirthDate());
        birthRegistration.setWeight(birthRegistrationDto.getWeight());
        birthRegistration.setMothersName(birthRegistrationDto.getMothersName());
        birthRegistration.setMothersAge(birthRegistrationDto.getMothersAge());
        birthRegistration.setMothersNationality(birthRegistrationDto.getMothersNationality());
        birthRegistration.setMothersResidence(birthRegistrationDto.getMothersResidence());
        birthRegistration.setMothersOccupation(birthRegistrationDto.getMothersOccupation());
        birthRegistration.setMothersIdNo(birthRegistrationDto.getMothersIdNo());
        birthRegistration.setMothersEducationLevel(birthRegistrationDto.getMothersEducationLevel());
        birthRegistration.setMothersMaritalStatus(birthRegistrationDto.getMothersMaritalStatus());
        birthRegistration.setPreviousBirthToMother(birthRegistrationDto.getPreviousBirthToMother());
        birthRegistration.setFathersName(birthRegistrationDto.getFathersName());
        birthRegistration.setFathersNationality(birthRegistrationDto.getFathersNationality());
        birthRegistration.setFathersIdNo(birthRegistrationDto.getFathersIdNo());
        birthRegistration.setCapacityOfInformatName(birthRegistrationDto.getCapacityOfInformatName());
        birthRegistration.setCapacityOfInformatRelationship(birthRegistrationDto.getCapacityOfInformatRelationship());
        birthRegistration.setDisclaimerAccepted(birthRegistrationDto.isDisclaimerAccepted());
        birthRegistration.setRegistrationDate(birthRegistrationDto.getRegistrationDate());

        return birthRegistrationRepository.save(birthRegistration);
    }

    @Override
    public BirthRegistration updateChildName(UpdateChildNameDto updateChildNameDto) {
        String mother =updateChildNameDto.getMothersName();
        String childOlderName =updateChildNameDto.getChildOlderName();
        String newChildName =updateChildNameDto.getChildNewName();
        System.out.println("mothers name is"+mother);
        System.out.println("mothers name is"+childOlderName);

        Optional<BirthRegistration> birthRegOpt = birthRegistrationRepository.findByMothersNameAndNameOfChild(mother, childOlderName);

        if (birthRegOpt.isPresent()) {
            BirthRegistration birthReg = birthRegOpt.get();
            birthReg.setNameOfChild(newChildName);
            return birthRegistrationRepository.save(birthReg);
        } else {
            throw new RuntimeException("Birth registration not found for mother: " + mother + " and child: " + childOlderName);
        }

    }

    @Override
    public DeathRegistration registerDeath(DeathRegistrationDTO deathRegistrationDto) {
        DeathRegistration deathRegistration = new DeathRegistration();

        deathRegistration.setOpd(deathRegistrationDto.getOpd());
        deathRegistration.setPatientNo(deathRegistrationDto.getPatientNo());
        deathRegistration.setPatientName(deathRegistrationDto.getPatientName());
        deathRegistration.setName(deathRegistrationDto.getName());
        deathRegistration.setDate(deathRegistrationDto.getDate());
        deathRegistration.setStreetNo(deathRegistrationDto.getStreetNo());
        deathRegistration.setPlaceOfBirth(deathRegistrationDto.getPlaceOfBirth());
        deathRegistration.setResidence(deathRegistrationDto.getResidence());
        deathRegistration.setBirthDate(deathRegistrationDto.getBirthDate());
        deathRegistration.setAge(deathRegistrationDto.getAge());
        deathRegistration.setGender(deathRegistrationDto.getGender());
        deathRegistration.setNextOfKin(deathRegistrationDto.getNextOfKin());
        deathRegistration.setOccupation(deathRegistrationDto.getOccupation());
        deathRegistration.setMorbidCondition(deathRegistrationDto.getMorbidCondition());

        CauseOfDeath causeOfDeath = new CauseOfDeath();
        causeOfDeath.setCode(deathRegistrationDto.getCauseOfDeathCode());
        causeOfDeath.setCount(deathRegistrationDto.getCauseOfDeathCount());
        causeOfDeath.setDescription(deathRegistrationDto.getCauseOfDeathDescription());
        deathRegistration.setCauseOfDeath(causeOfDeath);

        deathRegistration.setAttendedBeforeDeath(deathRegistrationDto.isAttendedBeforeDeath());
        deathRegistration.setPostMortem(deathRegistrationDto.isPostMortem());
        deathRegistration.setExaminedBodyBeforeDeath(deathRegistrationDto.isExaminedBodyBeforeDeath());
        deathRegistration.setExaminerName(deathRegistrationDto.getExaminerName());
        deathRegistration.setExaminerTitle(deathRegistrationDto.getExaminerTitle());
        deathRegistration.setCertificationDate(deathRegistrationDto.getCertificationDate());

        return deathRegistrationRepository.save(deathRegistration);
    }
    @Override
    public DeathNotification notifyDeath(DeathNotificationDto deathNotificationDto) {
        DeathNotification deathNotification = new DeathNotification();

        deathNotification.setGender(deathNotificationDto.getGender());
        deathNotification.setName(deathNotificationDto.getName());
        deathNotification.setAge(deathNotificationDto.getAge());
        deathNotification.setEstate(deathNotificationDto.getEstate());
        deathNotification.setStreet(deathNotificationDto.getStreet());
        deathNotification.setDate(deathNotificationDto.getDate());
        deathNotification.setSheetNo(deathNotificationDto.getSheetNo());
        deathNotification.setIpOp(deathNotificationDto.getIpOp());
        deathNotification.setHouseNo(deathNotificationDto.getHouseNo());
        deathNotification.setBox(deathNotificationDto.getBox());
        deathNotification.setTel(deathNotificationDto.getTel());


        deathNotification.setNextOfKin(deathNotificationDto.getNextOfKin());
        deathNotification.setKinEstate(deathNotificationDto.getKinEstate());
        deathNotification.setKinHouseNo(deathNotificationDto.getKinHouseNo());
        deathNotification.setKinStreet(deathNotificationDto.getKinStreet());
        deathNotification.setBroughtFrom(deathNotificationDto.getBroughtFrom());


        deathNotification.setProviderName(deathNotificationDto.getProviderName());
        deathNotification.setProviderIdNo(deathNotificationDto.getProviderIdNo());
        deathNotification.setProviderBox(deathNotificationDto.getProviderBox());
        deathNotification.setProviderTel(deathNotificationDto.getProviderTel());
        deathNotification.setProviderRelation(deathNotificationDto.getProviderRelation());

        deathNotification.setBringerName(deathNotificationDto.getBringerName());
        deathNotification.setBringerBox(deathNotificationDto.getBringerBox());
        deathNotification.setBringerVehicleNo(deathNotificationDto.getBringerVehicleNo());
        deathNotification.setBringerTelNo(deathNotificationDto.getBringerTelNo());
        deathNotification.setBringerRelation(deathNotificationDto.getBringerRelation());
        deathNotification.setBringerLicence(deathNotificationDto.getBringerLicence());

        deathNotification.setPupils(deathNotificationDto.getPupils());
        deathNotification.setResponseToStimuli(deathNotificationDto.getResponseToStimuli());
        deathNotification.setBreathSounds(deathNotificationDto.getBreathSounds());
        deathNotification.setCardiacActivity(deathNotificationDto.getCardiacActivity());
        deathNotification.setRigorMotis(deathNotificationDto.getRigorMotis());
        deathNotification.setOtherFindings(deathNotificationDto.getOtherFindings());
        deathNotification.setArrivalStatus(deathNotificationDto.getArrivalStatus());
        deathNotification.setPoliceStationReferredTo(deathNotificationDto.getPoliceStationReferredTo());
        deathNotification.setPractitionerDate(deathNotificationDto.getPractitionerDate());
        deathNotification.setPractitionerName(deathNotificationDto.getPractitionerName());
        deathNotification.setPractitionerTime(deathNotificationDto.getPractitionerTime());
        deathNotification.setPractitionerDesignation(deathNotificationDto.getPractitionerDesignation());


        deathNotification.setCollectorFullNames(deathNotificationDto.getCollectorFullNames());
        deathNotification.setCollectorRelationship(deathNotificationDto.getCollectorRelationship());
        deathNotification.setCollectorBox(deathNotificationDto.getCollectorBox());
        deathNotification.setCollectorId(deathNotificationDto.getCollectorId());

        return deathNotificationRepository.save(deathNotification);
    }



}
