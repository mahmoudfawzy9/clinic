package com.mahmoud.clinic2.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.mahmoud.clinic2.entity.enums.Gender;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "patient")
@Getter
@Setter
@Builder
@AllArgsConstructor
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @javax.persistence.Column(name = "id", updatable = false, nullable = true)
    private Long id;
    @javax.persistence.Column(name = "patient_profile_key", unique = true)
    private String patientProfileKey;
    @javax.persistence.Column(name = "first_name", length = 100, nullable = false)
    private String firstName;

    @javax.persistence.Column(name = "middle_name", length = 100)
    private String middleName;

    @javax.persistence.Column(name = "last_name", length = 100, nullable = false)
    private String lastName;

    @javax.persistence.Column(name = "pps_number", length = 100, insertable = true, unique = true)
    private String ppsNumber;

    @javax.persistence.Column(name = "DATE_OF_BIRTH", nullable = false)
//    @Convert(converter = LocalDateAttributeConverter.class)
//    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    private String dateOfBirth;

    @Enumerated(EnumType.STRING)
    @javax.persistence.Column(name = "GENDER", insertable = true, length = 6)
    private Gender gender;

    @javax.persistence.Column(name = "EMAIL", length = 255)
    private String email;

    @javax.persistence.Column(name = "MOBILE_PHONE", nullable = false, length = 50)
    private String mobilePhone;

    @javax.persistence.Column(name = "HOME_PHONE", length = 50)
    private String homePhone;

    @javax.persistence.Column(name = "CREATED_AT")
    @CreationTimestamp
    private Timestamp createdAt;

    @Column(name = "UPDATED_AT")
    @UpdateTimestamp
    private Timestamp updatedAt;

    @JsonIgnoreProperties("patient")
    @OneToMany(cascade = CascadeType.ALL,  orphanRemoval = true)
    @JoinColumn(name = "patient_id", referencedColumnName = "id", updatable = true, insertable = true)
    private List<Appointment> appointmentCollection;

    public Patient(){

    }

    //to be done later
//    @OneToOne(mappedBy = "patient", cascade = CascadeType.ALL)
//    private PatientAddress patientAddress;
}
