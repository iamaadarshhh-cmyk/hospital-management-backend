package com.HospitalManagement.repository;

import com.HospitalManagement.entity.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    Page<Patient> findByNameContainingIgnoreCase(String name, Pageable page);

    Page<Patient> findByActiveTrue(Pageable pageable);
}

//You extended JpaRepository.
//
//        What this gave you automatically:
//
//Save patient
//
//Find patient
//
//Delete patient
//
//Pagination
//
//        Sorting
//
//You wrote zero SQL, but DB works.
//
//Repository = Auto Database Toolkit