package com.HospitalManagement.service;

import com.HospitalManagement.dto.PatientDTO;
import com.HospitalManagement.entity.Patient;
import com.HospitalManagement.exception.PatientNotFoundException;
import com.HospitalManagement.mapper.PatientMapper;
import com.HospitalManagement.repository.PatientRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;

    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public Patient addPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Page<Patient> getAllPatients(Pageable pageable) {
        return patientRepository.findByActiveTrue(pageable);
    }

    @Override
    public Patient getPatientById(Long id) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new PatientNotFoundException("Patient not found with id " + id));
        if(!patient.isActive())
        {
            throw new PatientNotFoundException("Patient not found");
        }
        return patient;
    }

    @Override
    public Patient updatePatient(Long id, Patient patient) {
        Patient existing = getPatientById(id);
        existing.setName(patient.getName());
        existing.setEmail(patient.getEmail());
        existing.setDisease(patient.getDisease());
        existing.setDateOfBirth(patient.getDateOfBirth());
        return patientRepository.save(existing);

    }

    @Override
    public void deletePatient(Long id) {
        Patient patient = getPatientById(id);
        patient.setActive(false);
        patientRepository.save(patient);
    }

    @Override
    public Page<PatientDTO> getPatientByName(String name, Pageable pageable) {
        return patientRepository
                .findByNameContainingIgnoreCase(name,pageable)
                .map(PatientMapper::toDTO);
    }
}
