package com.HospitalManagement.service;

import com.HospitalManagement.dto.AppointmentDTO;
import com.HospitalManagement.entity.Appointment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface AppointmentService {
    AppointmentDTO addAppointment(AppointmentDTO dto);

    Page<AppointmentDTO> getAllAppointments(Pageable pageable);

    AppointmentDTO getAppointmentById(Long id);

    AppointmentDTO updateAppointment(Long id, AppointmentDTO dto);

    void deleteAppointment(Long id);

}
