package com.mahmoud.clinic2;

import com.mahmoud.clinic2.entity.Patient;
import com.mahmoud.clinic2.entity.enums.Gender;
import com.mahmoud.clinic2.request.CreatePatientProfileRequest;
import com.mahmoud.clinic2.service.PatientService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class PatientServiceTest {

    @InjectMocks
    PatientService service;

    Patient patient;
    CreatePatientProfileRequest request;

    void saveNewPatient() {

        this.patient = new Patient();

        patient.setId(1L);
        patient.setGender(Gender.MALE);
        patient.setFirstName("Mahmoud");
        patient.setMiddleName("Fawzy");
        patient.setLastName("Mohamed");
        patient.setHomePhone("+2450***");
        patient.setMobilePhone("01006864224");
    }
    @Test
    void getPatient() {
        Mockito.when(service.getPatientById(1L)).thenReturn(this.patient);
        Patient patientRes = service.getPatientById(1L);

        assertThat(patientRes.getPatientProfileKey()).isEqualTo(this.patient.getPatientProfileKey());
        verify(service).getPatientById(1L);

    }
}
