package com.Birth_Registration.Repository;


import com.Birth_Registration.Model.DocumentSource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentSourceRepository extends JpaRepository<DocumentSource, Long> {
}
