package com.mahmoud.clinic2.service;

import com.mahmoud.clinic2.entity.Appointment;
import com.mahmoud.clinic2.entity.Patient;
import com.mahmoud.clinic2.repository.AppointmentRepository;
import com.mahmoud.clinic2.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AppointmentServiceImp implements AppointmentService{
    @Autowired
    AppointmentRepository appointmentRepository;

    @Autowired
    PatientRepository patientRepository;
        //search keyword
         public List<Appointment> listAll(String keyword) {
         if(keyword != null) {
             return appointmentRepository.findAll(keyword);
         }
         return (List<Appointment>) appointmentRepository.findAll();
     }
    
    public AppointmentServiceImp(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public List<Appointment> getAppointments() {
        List<Appointment> appointments = new ArrayList<>();
        appointmentRepository.findAll().forEach(appointments::add);
        return appointments;
    }

    @Override
    public Appointment getAppointmentById(Long id) {
        return appointmentRepository.findById(id).get();
    }

    @Override
    public Appointment insert(Appointment appointment, String patientKey) {
  // You should create patient first before setting an appointment by using CreatePatient API

        Optional<Patient> patient1 = patientRepository.findByPatientProfileKey(patientKey);

        appointment.setPatient(patient1.get());

        return appointmentRepository.save(appointment);
    }

    @Override
    public void updateAppointment(Long id, Appointment appointment) {
         Appointment appointmentFromDb = appointmentRepository.findById(id).get();
        System.out.println(appointmentFromDb.toString());
        appointmentFromDb.setAppointmentStatus(appointment.getAppointmentStatus());
        appointmentFromDb.setDescription(appointment.getDescription());
        appointmentFromDb.setTitle(appointment.getTitle());
        appointmentRepository.save(appointmentFromDb);
    }

    @Override
    public void deleteAppointment(Long appointmentId) {
     appointmentRepository.deleteById(appointmentId);
    }
}
