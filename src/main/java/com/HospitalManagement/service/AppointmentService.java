package com.HospitalManagement.service;

import com.HospitalManagement.dto.AppointmentDTO;
import com.HospitalManagement.entity.Appointment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;


public interface AppointmentService {
    AppointmentDTO addAppointment(AppointmentDTO dto);

    Page<AppointmentDTO> getAllAppointments(Pageable pageable);

    AppointmentDTO getAppointmentById(Long id);

    AppointmentDTO updateAppointment(Long id, AppointmentDTO dto);

    void deleteAppointment(Long id);

    Page<AppointmentDTO> getAppointmentByDate(LocalDate date, Pageable pageable);
}
