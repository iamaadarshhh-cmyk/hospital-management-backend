package com.HospitalManagement.controller;

import com.HospitalManagement.dto.PatientDTO;
import com.HospitalManagement.entity.Patient;
import com.HospitalManagement.mapper.PatientMapper;
import com.HospitalManagement.service.PatientService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {
    private final PatientService patientService;


    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @PreAuthorize("hasRole('PATIENT')")
    @PostMapping
    public PatientDTO addPatient(@Valid @RequestBody PatientDTO dto){
        Patient patient = PatientMapper.toEntity(dto);
        Patient savedPatient = patientService.addPatient(patient);
        return PatientMapper.toDTO(savedPatient);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping
    public Page<PatientDTO> getPatients(@RequestParam(required = false) String name, Pageable pageable) {
        if(name != null){
            return patientService.getPatientByName(name,pageable);
        }

        return patientService.getAllPatients(pageable)
                .map(PatientMapper::toDTO);
    }

    @PreAuthorize("hasAnyRole('ADMIN','DOCTOR')")
    @GetMapping("/{id}")
    public PatientDTO getPatient(@PathVariable Long id) {

        Patient patient = patientService.getPatientById(id);

        return PatientMapper.toDTO(patient);
    }


    @PutMapping("/{id}")
    public PatientDTO updatePatient(@PathVariable Long id,
                                    @Valid @RequestBody PatientDTO dto) {

        Patient patient = PatientMapper.toEntity(dto);

        Patient updated = patientService.updatePatient(id, patient);

        return PatientMapper.toDTO(updated);
    }


    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public void deletePatient(@PathVariable Long id) {
        patientService.deletePatient(id);
    }

}
