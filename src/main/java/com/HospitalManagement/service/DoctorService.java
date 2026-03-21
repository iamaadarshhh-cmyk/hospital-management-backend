package com.HospitalManagement.service;

import com.HospitalManagement.dto.DoctorDTO;
import com.HospitalManagement.entity.Doctor;
import com.HospitalManagement.entity.Specialization;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DoctorService {

    Doctor addDoctor(Doctor doctor);

    Page<Doctor> getAllDoctor(Pageable pageable);

    Doctor getDoctorById(Long id);

    Doctor updateDoctor(Long id, Doctor doctor);

    void deleteDoctor(Long id);


    Page<DoctorDTO> getDoctorsBySpecialization(Specialization specialization, Pageable pageable);
}
