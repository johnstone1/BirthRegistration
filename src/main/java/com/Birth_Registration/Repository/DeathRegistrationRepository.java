package com.Birth_Registration.Repository;
import com.Birth_Registration.Model.DeathRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeathRegistrationRepository extends JpaRepository<DeathRegistration, Long> {
}
