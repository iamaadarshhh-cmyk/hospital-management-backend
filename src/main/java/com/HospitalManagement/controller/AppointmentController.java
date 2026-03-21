package com.HospitalManagement.controller;

import com.HospitalManagement.dto.AppointmentDTO;
import com.HospitalManagement.service.AppointmentService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @PostMapping
    public AppointmentDTO addAppointment(@Valid @RequestBody AppointmentDTO dto) {
        return appointmentService.addAppointment(dto);
    }

    @GetMapping
    public Page<AppointmentDTO> getAppointments(@RequestParam(required = false) LocalDate date, Pageable pageable) {
        if(date != null)
            return appointmentService.getAppointmentByDate(date,pageable);
        return appointmentService.getAllAppointments(pageable);
    }

    @GetMapping("/{id}")
    public AppointmentDTO getAppointment(@PathVariable Long id) {
        return appointmentService.getAppointmentById(id);
    }

    @PutMapping("/{id}")
    public AppointmentDTO updateAppointment(@PathVariable Long id,
                                            @Valid @RequestBody AppointmentDTO dto) {
        return appointmentService.updateAppointment(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deleteAppointment(@PathVariable Long id) {
        appointmentService.deleteAppointment(id);
    }
}
