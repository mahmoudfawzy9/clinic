package com.mahmoud.clinic2.repository;

import com.mahmoud.clinic2.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Optional;

@CrossOrigin("http://localhost:4200")
@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    Optional<Patient> findById(Long id);

    Optional<Patient> findByFirstName(String firstName);

    Optional<Patient> findByMobilePhone(String mobile);

    Optional<Patient> findByPatientProfileKey(String key);

}
