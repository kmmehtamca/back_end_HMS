package com.HMSApp.Hospital_Management._System.controller.patientcontroller;

import com.HMSApp.Hospital_Management._System.entity.doclogin.Appointment;
import com.HMSApp.Hospital_Management._System.entity.patientinfo.Patient;
import com.HMSApp.Hospital_Management._System.repository.patientRepoitory.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.management.AttributeNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class PatientController {
    @Autowired
    private PatientRepository patientRepository;

    @PostMapping("/insert")
    public Patient CreatePatient(@RequestBody Patient patient) {
        return patientRepository.save(patient);
    }

    @GetMapping("/retrieveall")
    public  List<Patient>  getallPatient() {
        return patientRepository.findAll();
    }

    @GetMapping("/retrievebyid/{id}")
    public  ResponseEntity<Patient>getPatientbyID(@PathVariable Long id) throws AttributeNotFoundException {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new AttributeNotFoundException("Patient not found with ID: " + id));
    return ResponseEntity.ok(patient) ;
    }

    @DeleteMapping("/patients/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteAppointment(@PathVariable Long id) throws AttributeNotFoundException {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new AttributeNotFoundException("Patient not found with ID: " + id));

        patientRepository.delete(patient);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);

        return ResponseEntity.ok(response);
    }

    @PutMapping("/patients/{id}")
    public ResponseEntity<Patient>updatepatinetbyID(@PathVariable Long id,@RequestBody Patient patientdetails ) throws AttributeNotFoundException {
         Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new AttributeNotFoundException("Patient not found with ID: " + id));
        patient.setAge(patientdetails.getAge());
        patient.setFirstName(patientdetails.getFirstName());
        patient.setBlood(patientdetails.getBlood());
        patient.setMiddleName(patientdetails.getMiddleName());
        patient.setLastName(patientdetails.getLastName());
            patient.setPrescription(patientdetails.getPrescription());
            patient.setFees(patientdetails.getFees());
        patient.setUrgency(patientdetails.getUrgency());
        Patient patientsaved =  patientRepository.save(patient);
        return ResponseEntity.ok(patientsaved);
    }
}