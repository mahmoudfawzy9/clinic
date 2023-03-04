package com.mahmoud.repository;

import com.mahmoud.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:4200")
@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
}
