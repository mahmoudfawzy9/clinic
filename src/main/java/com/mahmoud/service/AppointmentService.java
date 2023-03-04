package com.mahmoud.service;

import com.mahmoud.entity.Appointment;

import java.util.List;

public interface AppointmentService {
    List<Appointment> getAppointments();

    Appointment getAppointmentById(Long id);

    Appointment insert(Appointment appointment);

    void updateAppointment(Long id, Appointment appointment);

    void deleteAppointment(Long appointmentId);
}