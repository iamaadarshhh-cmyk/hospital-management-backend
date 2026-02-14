package com.HospitalManagement.mapper;

import com.HospitalManagement.dto.DoctorDTO;
import com.HospitalManagement.entity.Doctor;

public class DoctorMapper {
    public static DoctorDTO toDTO(Doctor doctor){
        DoctorDTO dto = new DoctorDTO();
        dto.setDoctorId(doctor.getDoctorId());
        dto.setName(doctor.getName());
        dto.setEmail(doctor.getEmail());
        dto.setSpecialization(doctor.getSpecialization());

        return dto;
    }

    public static Doctor toEntity(DoctorDTO dto){
        Doctor doctor = new Doctor();
        doctor.setDoctorId(dto.getDoctorId());
        doctor.setName(dto.getName());
        doctor.setEmail(dto.getEmail());
        doctor.setSpecialization(dto.getSpecialization());

        return doctor;
    }
}
