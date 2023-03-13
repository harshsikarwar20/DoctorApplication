package com.Harsh.Doctor.Dao;

import com.Harsh.Doctor.Model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDoctorRepository extends JpaRepository<Doctor, Integer> {
}
