package com.mahmoud.clinic2.mapper;

import com.mahmoud.clinic2.entity.Patient;
import com.mahmoud.clinic2.request.CreatePatientProfileRequest;
import org.springframework.stereotype.Component;

@Component
public class PatientProfileMapper {

    public Patient mapPatientRequestToEntity(CreatePatientProfileRequest createPatientProfileRequest) {
        Patient patientProfile = Patient.builder().firstName(createPatientProfileRequest.getFirstName())
                .lastName(createPatientProfileRequest.getLastName())
                .middleName(createPatientProfileRequest.getMiddleName())
                .email(createPatientProfileRequest.getEmail())
                .mobilePhone(createPatientProfileRequest.getMobilePhone())
                .ppsNumber(createPatientProfileRequest.getPpsNumber())
                .dateOfBirth(createPatientProfileRequest.getDateOfBirth())
                .build();

        return patientProfile;
    }
}
