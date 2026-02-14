package com.HospitalManagement.service;

import com.HospitalManagement.dto.AppointmentDTO;
import com.HospitalManagement.entity.Appointment;
import com.HospitalManagement.mapper.AppointmentMapper;
import com.HospitalManagement.repository.AppointmentRepository;
import com.HospitalManagement.service.AppointmentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final AppointmentMapper appointmentMapper;

    public AppointmentServiceImpl(AppointmentRepository appointmentRepository,
                                  AppointmentMapper appointmentMapper) {
        this.appointmentRepository = appointmentRepository;
        this.appointmentMapper = appointmentMapper;
    }

    @Override
    public AppointmentDTO addAppointment(AppointmentDTO dto) {
        if(appointmentRepository.existsByDoctorDoctorIdAndDateAndTime(dto.getDoctorId(),dto.getDate(),dto.getTime())){
            throw new RuntimeException("Doctor already booked at this time");
        }
        Appointment appointment = appointmentMapper.toEntity(dto);
        Appointment saved = appointmentRepository.save(appointment);
        return appointmentMapper.toDTO(saved);
    }

    @Override
    public Page<AppointmentDTO> getAllAppointments(Pageable pageable) {
        return appointmentRepository.findAll(pageable)
                .map(appointmentMapper::toDTO);
    }

    @Override
    public AppointmentDTO getAppointmentById(Long id) {
        Appointment appointment = appointmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Appointment not found"));
        return appointmentMapper.toDTO(appointment);
    }

    @Override
    public AppointmentDTO updateAppointment(Long id, AppointmentDTO dto) {
        Appointment existing = appointmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Appointment not found"));

        Appointment updatedEntity = appointmentMapper.toEntity(dto);
        updatedEntity.setAppointmentId(existing.getAppointmentId());

        Appointment saved = appointmentRepository.save(updatedEntity);
        return appointmentMapper.toDTO(saved);
    }

    @Override
    public void deleteAppointment(Long id) {
        appointmentRepository.deleteById(id);
    }
}
