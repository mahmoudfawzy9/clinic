package com.mahmoud.clinic2.service;

import com.mahmoud.clinic2.entity.Appointment;

import java.util.List;

public interface AppointmentService {

    List<Appointment> getAppointments();

    Appointment getAppointmentById(Long id);

    Appointment insert(Appointment appointment, String patientKey);

    void updateAppointment(Long id, Appointment appointment);

    void deleteAppointment(Long appointmentId);

}
