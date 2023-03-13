package com.Harsh.Doctor.Dao;

import com.Harsh.Doctor.Model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPatientRepository extends JpaRepository<Patient,Integer> {
}
