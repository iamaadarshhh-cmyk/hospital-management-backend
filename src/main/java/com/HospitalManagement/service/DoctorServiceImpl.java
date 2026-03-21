package com.HospitalManagement.service;

import com.HospitalManagement.dto.DoctorDTO;
import com.HospitalManagement.entity.Doctor;
import com.HospitalManagement.entity.Specialization;
import com.HospitalManagement.exception.DoctorNotFoundException;
import com.HospitalManagement.mapper.DoctorMapper;
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
        return doctorRepository.findByActiveTrue(pageable);
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
        existing.setActive(false);
        doctorRepository.save(existing);
    }


    public Page<DoctorDTO> getDoctorsBySpecialization(Specialization specialization, Pageable pageable)
    {
        return doctorRepository
                .findBySpecialization(specialization, pageable)
                .map(DoctorMapper::toDTO);
    }
}
