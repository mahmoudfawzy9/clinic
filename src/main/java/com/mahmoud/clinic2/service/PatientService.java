package com.mahmoud.clinic2.service;

import com.mahmoud.clinic2.request.CreatePatientProfileRequest;
import com.mahmoud.clinic2.response.CreatePatientResponse;
import org.springframework.http.ResponseEntity;

public interface PatientService {

    ResponseEntity<CreatePatientResponse> insert(CreatePatientProfileRequest createPatientProfileRequest);
    
    Patient getPatientById(Long id);
    
    SuccessResponse<Patient> delete(Long id);


}
