package com.HospitalManagement.service;

import com.HospitalManagement.entity.Doctor;
import com.HospitalManagement.exception.DoctorNotFoundException;
import com.HospitalManagement.repository.DoctorRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository doctorRepository;

    public DoctorServiceImpl(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @Override
    public Doctor addDoctor(Doctor doctor) {

        return doctorRepository.save(doctor);
    }

    @Override
    public Page<Doctor> getAllDoctor(Pageable pageable) {
        return doctorRepository.findAll(pageable);
    }

    @Override
    public Doctor getDoctorById(Long id) {
        return doctorRepository.findById(id)
                .orElseThrow(() -> new DoctorNotFoundException("Doctor Not found with id "+id));
    }

    @Override
    public Doctor updateDoctor(Long id, Doctor doctor) {
        Doctor existing = getDoctorById(id);
        existing.setName(doctor.getName());
        existing.setEmail(doctor.getEmail());
        existing.setSpecialization(doctor.getSpecialization());

        return doctorRepository.save(existing);
    }

    @Override
    public void deleteDoctor(Long id) {
        Doctor existing = getDoctorById(id);
        doctorRepository.delete(existing);
    }
}
