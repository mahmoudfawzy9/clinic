package com.mahmoud.clinic2;

import com.mahmoud.clinic2.entity.Appointment;
import com.mahmoud.clinic2.entity.Patient;
import com.mahmoud.clinic2.entity.enums.Gender;
import com.mahmoud.clinic2.repository.PatientRepository;
import com.mahmoud.clinic2.request.CreatePatientProfileRequest;
import com.mahmoud.clinic2.service.PatientService;
import com.mahmoud.clinic2.service.PatientServiceImp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class PatientServiceTest {

    @Mock
    private PatientRepository patientRepo;

    PatientService service;

    Patient patient;

    List<Appointment> collection;
    CreatePatientProfileRequest request;

    void saveNewPatient() {

        this.patient = new Patient();

        patient.setId(1L);
        patient.setGender(Gender.MALE);
        patient.setFirstName("Mahmoud");
        patient.setMiddleName("Fawzy");
        patient.setLastName("Mohamed");
        patient.setHomePhone("+2450****");
        patient.setMobilePhone("0100686****");
    }

    @BeforeEach
    void setUp()
    {
        this.service
                = new PatientServiceImp(this.patientRepo) ;
    }
    @Test
    void getPatientById() {
        Mockito.when(service.getPatientById(1L)).thenReturn(patient);
        service.getPatientById(1L);
        verify(patientRepo).findById(1L);

    }
}
