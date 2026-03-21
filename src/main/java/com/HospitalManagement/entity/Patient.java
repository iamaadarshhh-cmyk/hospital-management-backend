package com.HospitalManagement.entity;

import com.HospitalManagement.entity.BloodGroup;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Patient extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long patientId;

    private String name;

    private String email;

    @Enumerated(EnumType.STRING)
    private BloodGroup bloodGroup;

    private String disease;

    private LocalDate dateOfBirth;


}
