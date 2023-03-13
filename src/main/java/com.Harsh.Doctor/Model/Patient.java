package com.Harsh.Doctor.Model;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Patient_Table")
public class Patient {
    @Id
    @Column(name="Patient_Id")
    private Integer patientId;

    @Column(name="Patient_Name")
    private String patientName;

    @Column(name="Patient_Age")
    private Integer age;
    @Column(name="Patient_PN")
    private String phoneNumber;
    @Column(name="Disease_Typ")
    private String diseaseType;
    @Column(name="Patient_G")
    private String gender;

    @Column(name="admit_Date")
    private Timestamp admitDate;

    @JoinColumn(name="Doctor_Id")
    //Many Of Patient Can have one Doctor
    @ManyToOne(fetch = FetchType.LAZY)
    private Doctor doctor;

}
