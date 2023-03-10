package com.mahmoud.clinic2.controller;

import com.mahmoud.clinic2.request.CreatePatientProfileRequest;
import com.mahmoud.clinic2.response.CreatePatientResponse;
import com.mahmoud.clinic2.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/patient")
public class PatientController {

    @Autowired
    PatientService patientProfileService;
    @PostMapping(value = "/create")
    public ResponseEntity<CreatePatientResponse> createPatientProfile(
             @RequestBody CreatePatientProfileRequest createPatientProfileRequest) {
        return patientProfileService.insert(createPatientProfileRequest);
    }
}
