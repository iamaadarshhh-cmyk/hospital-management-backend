package com.HospitalManagement.controller;

import com.HospitalManagement.dto.DoctorDTO;

import com.HospitalManagement.entity.Doctor;
import com.HospitalManagement.entity.Specialization;
import com.HospitalManagement.mapper.DoctorMapper;
import com.HospitalManagement.service.DoctorService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/doctors")
public class DoctorController {
    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public DoctorDTO addDoctor(@Valid @RequestBody DoctorDTO dto){
        Doctor doctor = DoctorMapper.toEntity(dto);
        Doctor savedDoctor = doctorService.addDoctor(doctor);
        return DoctorMapper.toDTO(savedDoctor);
    }


    @PreAuthorize("hasAnyRole('ADMIN','DOCTOR')")
    @GetMapping
    public Page<DoctorDTO> getDoctors(@RequestParam(required = false) Specialization specialization, Pageable pageable) {

        if(specialization != null)
        {
            return doctorService.getDoctorsBySpecialization(specialization, pageable);
        }
        return doctorService.getAllDoctor(pageable)
                .map(DoctorMapper::toDTO);
    }


    @PreAuthorize("hasAnyRole('ADMIN','DOCTOR')")
    @GetMapping("/{id}")
    public DoctorDTO getDoctor(@PathVariable Long id) {

        Doctor doctor = doctorService.getDoctorById(id);

        return DoctorMapper.toDTO(doctor);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public DoctorDTO updateDoctor(@PathVariable Long id,
                                    @Valid @RequestBody DoctorDTO dto) {

        Doctor doctor = DoctorMapper.toEntity(dto);

        Doctor updated = doctorService.updateDoctor(id, doctor);

        return DoctorMapper.toDTO(updated);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public void deleteDoctor(@PathVariable Long id) {
        doctorService.deleteDoctor(id);
    }
}
