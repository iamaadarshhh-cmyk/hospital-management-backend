package com.HospitalManagement.mapper;

import com.HospitalManagement.dto.PatientDTO;
import com.HospitalManagement.entity.Patient;

public class PatientMapper {

    public static PatientDTO toDTO(Patient patient) {
        PatientDTO dto = new PatientDTO();
        dto.setPatientId(patient.getPatientId());
        dto.setName(patient.getName());
        dto.setEmail(patient.getEmail());
        dto.setBloodGroup(patient.getBloodGroup());
        dto.setDisease(patient.getDisease());
        dto.setDateOfBirth(patient.getDateOfBirth());
        return dto;
    }

    public static Patient toEntity(PatientDTO dto) {
        Patient patient = new Patient();
        patient.setPatientId(dto.getPatientId());
        patient.setName(dto.getName());
        patient.setEmail(dto.getEmail());
        patient.setBloodGroup(dto.getBloodGroup());
        patient.setDisease(dto.getDisease());
        patient.setDateOfBirth(dto.getDateOfBirth());
        return patient;
    }
}
