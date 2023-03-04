package com.mahmoud.repository;

import com.mahmoud.entity.Appointment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@CrossOrigin("http://localhost:4200")
@Repository
public interface AppointmentRepository extends CrudRepository<Appointment, Long> {

    @Query("SELECT a FROM Appointment a WHERE a.title LIKE %?1%")
    public List<Appointment> findAll(String keyword);

    Page<Appointment> findById(@RequestParam("id") Long id, Pageable pageable);

    Page<Appointment> findByTitleContaining(@RequestParam("title") String title, Pageable pageable);

//     List<Appointment> findAll(String keyword);
}
