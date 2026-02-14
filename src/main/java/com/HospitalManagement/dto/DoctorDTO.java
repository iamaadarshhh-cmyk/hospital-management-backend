package com.HospitalManagement.dto;


import com.HospitalManagement.entity.Specialization;
import lombok.Data;

@Data
public class DoctorDTO {
    private Long doctorId;
    private String name;
    private String email;
    private Specialization specialization;
}
