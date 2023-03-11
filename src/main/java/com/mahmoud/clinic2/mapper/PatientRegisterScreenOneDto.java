package com.mahmoud.clinic2.mapper;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.mahmoud.clinic2.entity.enums.Gender;
import com.mahmoud.clinic2.request.BaseDto;
import lombok.*;

import java.io.Serializable;
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PatientRegisterScreenOneDto extends BaseDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private String patientId;

    private String firstName;

    private String middleName;

    private String lastName;

    private String mobilePhone;

    private String homePhone;

    private Gender gender;

    private String email;

    private String dateOfBirth;
}