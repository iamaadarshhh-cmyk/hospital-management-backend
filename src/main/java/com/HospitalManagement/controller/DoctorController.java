package com.HospitalManagement.controller;

import com.HospitalManagement.dto.DoctorDTO;
import com.HospitalManagement.dto.PatientDTO;
import com.HospitalManagement.entity.Doctor;
import com.HospitalManagement.entity.Patient;
import com.HospitalManagement.mapper.DoctorMapper;
import com.HospitalManagement.mapper.PatientMapper;
import com.HospitalManagement.service.DoctorService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/doctors")
public class DoctorController {
    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @PostMapping
    public DoctorDTO addDoctor(@Valid @RequestBody DoctorDTO dto){
        Doctor doctor = DoctorMapper.toEntity(dto);
        Doctor savedDoctor = doctorService.addDoctor(doctor);
        return DoctorMapper.toDTO(savedDoctor);
    }

    @GetMapping
    public Page<DoctorDTO> getAllDoctor(Pageable pageable) {

        return doctorService.getAllDoctor(pageable)
                .map(DoctorMapper::toDTO);
    }


    @GetMapping("/{id}")
    public DoctorDTO getDoctor(@PathVariable Long id) {

        Doctor doctor = doctorService.getDoctorById(id);

        return DoctorMapper.toDTO(doctor);
    }

    @PutMapping("/{id}")
    public DoctorDTO updateDoctor(@PathVariable Long id,
                                    @Valid @RequestBody DoctorDTO dto) {

        Doctor doctor = DoctorMapper.toEntity(dto);

        Doctor updated = doctorService.updateDoctor(id, doctor);

        return DoctorMapper.toDTO(updated);
    }

    @DeleteMapping("/{id}")
    public void deleteDoctor(@PathVariable Long id) {
        doctorService.deleteDoctor(id);
    }
}
