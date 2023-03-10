package com.mahmoud.clinic2.controller;

import com.mahmoud.clinic2.entity.Appointment;
import com.mahmoud.clinic2.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/appointment")
public class AppointmentController {
    @Autowired
    AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    //The function receives a GET request, processes it and gives back a list of Appointment as a response.
    @GetMapping
    public ResponseEntity<List<Appointment>> getAllappointments() {
        List<Appointment> appointments = appointmentService.getAppointments();
        return new ResponseEntity<>(appointments, HttpStatus.OK);
    }
    //The function receives a GET request, processes it, and gives back a list of Appointment as a response.
    @GetMapping({"/{appointmentId}"})
    public ResponseEntity<Appointment> getAppointment(@PathVariable Long appointmentId) {
        return new ResponseEntity<>(appointmentService.getAppointmentById(appointmentId), HttpStatus.OK);
    }
    //The function receives a POST request, processes it, creates a new Appointment and saves it to the database, and returns a resource link to the created appointment.
    @PostMapping(value = {"/{appointmentId}"}, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Appointment> saveAppointment(@RequestBody Appointment appointment,@RequestParam String patientKey) {
        Appointment appointment1 = appointmentService.insert(appointment, patientKey);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("appointment", "/api/v1/appointment/" + appointment1.getId().toString());
        return new ResponseEntity<>(appointment1, httpHeaders, HttpStatus.CREATED);
    }
    //The function receives a PUT request, updates the Appointment with the specified Id and returns the updated Appointment
    @PutMapping({"/{appointmentId}"})
    public ResponseEntity<Appointment> updateAppointment(@PathVariable("appointmentId") Long appointmentId, @RequestBody Appointment appointment) {
        appointmentService.updateAppointment(appointmentId, appointment);
        return new ResponseEntity<>(appointmentService.getAppointmentById(appointmentId), HttpStatus.OK);
    }
    //The function receives a DELETE request, deletes the Appointment with the specified Id.
    @DeleteMapping({"/{appointmentId}"})
    public ResponseEntity<Appointment> deleteAppointment(@PathVariable("appointmentId") Long appointmentId) {
        appointmentService.deleteAppointment(appointmentId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
