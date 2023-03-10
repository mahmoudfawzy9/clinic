package com.mahmoud.clinic2.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CreatePatientResponse {

    private String message;
    private long patientId;
    private int messageCode;
}
