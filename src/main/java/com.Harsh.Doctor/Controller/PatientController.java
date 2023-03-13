package com.Harsh.Doctor.Controller;

import com.Harsh.Doctor.Dao.IDoctorRepository;
import com.Harsh.Doctor.Model.Doctor;
import com.Harsh.Doctor.Model.Patient;
import com.Harsh.Doctor.Service.PatientService;
import jakarta.annotation.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;

@RestController
public class PatientController {

    @Autowired
    IDoctorRepository doctorRepository;

    @Autowired
    PatientService patientService;

    //URL - http://localhost:8080/Patient
    @PostMapping("/Patient")
    public String savePatient(@RequestBody String patientRequest){
        JSONObject json = new JSONObject(patientRequest);
        Patient patient = setPatient(json);
        patientService.savePatient(patient);

        return "saved Patient";
    }

    private Patient setPatient(JSONObject json){
        Patient patient = new Patient();
        patient.setPatientId(json.getInt("patientId"));
        patient.setPatientName(json.getString("patientName"));
        patient.setAge(json.getInt("age"));
        patient.setPhoneNumber(json.getString("phoneNumber"));
        patient.setDiseaseType(json.getString("diseaseType"));
        patient.setGender(json.getString("gender"));

        //we convert MilliSecond into Timestamp
        Timestamp currTime = new Timestamp(System.currentTimeMillis());
        patient.setAdmitDate(currTime);

        String doctorId = json.getString("doctorId");
        Doctor doctor = doctorRepository.findById(Integer.valueOf(doctorId)).get();
        patient.setDoctor(doctor);
        return patient;
    }

    @GetMapping(value= "/patient")
    public ResponseEntity<String> getPatient(@Nullable @RequestParam String doctorId, @Nullable @RequestParam String patientId){
        JSONArray patientDetails = patientService.getPatient();
        return new ResponseEntity<>(patientDetails.toString(),HttpStatus.OK);
    }
}
