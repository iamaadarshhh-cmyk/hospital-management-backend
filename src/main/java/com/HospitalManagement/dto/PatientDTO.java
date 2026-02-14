package com.HospitalManagement.dto;

import com.HospitalManagement.entity.BloodGroup;
import lombok.Data;

import java.time.LocalDate;

@Data
public class PatientDTO {

    private Long patientId;
    private String name;
    private String email;
    private BloodGroup bloodGroup;
    private String disease;
    private LocalDate dateOfBirth;
}
