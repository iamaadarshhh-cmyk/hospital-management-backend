package com.HospitalManagement.service;

import com.HospitalManagement.entity.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface PatientService {
    Patient addPatient(Patient patient);

    Page<Patient> getAllPatients(Pageable pageable);

    Patient getPatientById(Long id);

    Patient updatePatient(Long id, Patient patient);

    void deletePatient(Long id);


}
