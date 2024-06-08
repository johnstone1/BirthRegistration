package com.Birth_Registration.Repository;

import com.Birth_Registration.Model.BirthRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BirthRegistrationRepository extends JpaRepository<BirthRegistration, Long> {

    Optional<BirthRegistration> findByMothersNameAndNameOfChild(String mothersName, String nameOfChild);

}
