package com.Birth_Registration.Repository;

import com.Birth_Registration.Model.DeathNotification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeathNotificationRepository extends JpaRepository<DeathNotification, Long> {
}
