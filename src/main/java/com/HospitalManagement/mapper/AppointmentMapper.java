package com.HospitalManagement.mapper;

import com.HospitalManagement.dto.AppointmentDTO;
import com.HospitalManagement.entity.Appointment;
import com.HospitalManagement.entity.Doctor;
import com.HospitalManagement.entity.Patient;
import com.HospitalManagement.exception.DoctorNotFoundException;
import com.HospitalManagement.exception.PatientNotFoundException;
import com.HospitalManagement.repository.DoctorRepository;
import com.HospitalManagement.repository.PatientRepository;
import org.springframework.stereotype.Component;

@Component
public class AppointmentMapper {
    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;

    public AppointmentMapper(PatientRepository patientRepository, DoctorRepository doctorRepository) {
        this.patientRepository = patientRepository;
        this.doctorRepository = doctorRepository;
    }

    public Appointment toEntity(AppointmentDTO dto){
        Appointment appointment = new Appointment();

        Patient patient = patientRepository.findById(dto.getPatientId())
                .orElseThrow(() -> new PatientNotFoundException("Patient Not found"));

        Doctor doctor = doctorRepository.findById(dto.getDoctorId())
                .orElseThrow(() -> new DoctorNotFoundException("Doctor Not found"));

        appointment.setAppointmentId(dto.getAppointmentId());
        appointment.setPatient(patient);
        appointment.setDoctor(doctor);
        appointment.setDate(dto.getDate());
        appointment.setTime(dto.getTime());
        appointment.setStatus(dto.getStatus());

        return appointment;
    }

    public AppointmentDTO toDTO(Appointment appointment) {
        AppointmentDTO dto = new AppointmentDTO();

        dto.setAppointmentId(appointment.getAppointmentId());
        dto.setPatientId(appointment.getPatient().getPatientId());
        dto.setDoctorId(appointment.getDoctor().getDoctorId());
        dto.setDate(appointment.getDate());
        dto.setTime(appointment.getTime());
        dto.setStatus(appointment.getStatus());

        return dto;
    }
}
