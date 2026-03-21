package com.HospitalManagement.repository;

import com.HospitalManagement.entity.Appointment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    boolean existsByDoctorDoctorIdAndDateAndTime(
            Long doctorId,
            LocalDate date,
            LocalTime time
    );

    Page<Appointment> findByActiveTrue(Pageable pageable);

    Page<Appointment> findByDate(LocalDate date, Pageable pageable);

}
