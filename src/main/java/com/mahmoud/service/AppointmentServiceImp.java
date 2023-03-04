package com.mahmoud.service;

import com.mahmoud.bootstrap.AppointmentLoader;
import com.mahmoud.entity.Appointment;
import com.mahmoud.entity.enums.AppointmentStatus;
import com.mahmoud.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AppointmentServiceImp implements AppointmentService{
    @Autowired
    AppointmentRepository appointmentRepository;

    @Autowired
    AppointmentLoader appointmentLoader;
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
    public Appointment insert(Appointment appointment) {
 
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
