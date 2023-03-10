package com.mahmoud.clinic2.repository;

import com.mahmoud.clinic2.entity.Appointment;
import com.mahmoud.clinic2.entity.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@CrossOrigin("http://localhost:4200")
@Repository
public interface AppointmentRepository extends CrudRepository<Appointment, Long> {
    
     @Query("SELECT a FROM Appointment a WHERE a.title LIKE %?1%")
     public List<Appointment> findAll(String keyword);


    Optional<Appointment> findByPatient(Patient patient);

    Page<Appointment> findById(@RequestParam("id") Long id, Pageable pageable);

    Page<Appointment> findByTitleContaining(@RequestParam("title") String title, Pageable pageable);

//    List<Appointment> findAll(String keyword);
}
