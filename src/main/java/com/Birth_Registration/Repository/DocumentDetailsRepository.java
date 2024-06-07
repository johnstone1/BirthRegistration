package com.Birth_Registration.Repository;

import com.Birth_Registration.Model.DocumentDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentDetailsRepository extends JpaRepository<DocumentDetails, Long> {
}
