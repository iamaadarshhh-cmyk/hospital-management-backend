package com.HospitalManagement.dto;

import com.HospitalManagement.entity.Status;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class AppointmentDTO {
    private Long appointmentId;
    private Long patientId;
    private Long doctorId;
    private LocalDate date;
    private LocalTime time;
    private Status status;
}
