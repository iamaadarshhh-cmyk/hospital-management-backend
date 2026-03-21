package com.HospitalManagement.dto;

import com.HospitalManagement.entity.BloodGroup;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class PatientDTO {

    private Long patientId;

    @NotBlank(message = "Name is required")
    private String name;

    @Email(message = "Invalid email format")
    private String email;

    @NotNull(message = "Blood group is required")
    private BloodGroup bloodGroup;

    private String disease;

    @NotNull(message = "Date of birth is required")
    private LocalDate dateOfBirth;
}
