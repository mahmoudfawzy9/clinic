package com.mahmoud.bootstrap;

import com.mahmoud.entity.Appointment;
import com.mahmoud.entity.enums.AppointmentStatus;
import com.mahmoud.repository.AppointmentRepository;
import org.springframework.boot.CommandLineRunner;

public class AppointmentLoader implements CommandLineRunner {

    public final AppointmentRepository appointmentRepository;

    public AppointmentLoader(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadAppointments();
    }

    public void loadAppointments() {
        if (appointmentRepository.count() == 0) {
            appointmentRepository.save(
                    Appointment.builder()
                            .title("Go to doctor")
                            .description("Get some medicine")
                            .appointmentStatus(AppointmentStatus.NOT_COMPLETED)
                            .build()
            );
            appointmentRepository.save(
                    Appointment.builder()
                            .title("Go to clinic 14")
                            .description("Complete treatment")
                            .appointmentStatus(AppointmentStatus.COMPLETED)
                            .build()
            );
            System.out.println("Sample Appointments Loaded");
        }
    }
}
