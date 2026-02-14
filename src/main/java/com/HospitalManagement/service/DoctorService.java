package com.HospitalManagement.service;

import com.HospitalManagement.entity.Doctor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DoctorService {

    Doctor addDoctor(Doctor doctor);

    Page<Doctor> getAllDoctor(Pageable pageable);

    Doctor getDoctorById(Long id);

    Doctor updateDoctor(Long id, Doctor doctor);

    void deleteDoctor(Long id);

}
