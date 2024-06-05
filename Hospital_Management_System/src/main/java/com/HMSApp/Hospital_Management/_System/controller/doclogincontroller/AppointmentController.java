package com.HMSApp.Hospital_Management._System.controller.doclogincontroller;

import com.HMSApp.Hospital_Management._System.entity.doclogin.Appointment;
import com.HMSApp.Hospital_Management._System.entity.doclogin.Medicine;
import com.HMSApp.Hospital_Management._System.repository.docRepository.AppointementRepository;
import com.HMSApp.Hospital_Management._System.repository.docRepository.MedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.management.AttributeNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v3")
public class AppointmentController {
    @Autowired
    private AppointementRepository appointementRepository;

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/insert")
    public Appointment CreateAppointement(@RequestBody Appointment appointment) {
        return appointementRepository.save(appointment);
    }

    @GetMapping("/retrieveall")
    public List<Appointment> getallappointement() {
        return appointementRepository.findAll();
    }


    @DeleteMapping("/appointments/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteAppointment(@PathVariable Long id) throws AttributeNotFoundException {
        Appointment appointment = appointementRepository.findById(id)
                .orElseThrow(() -> new AttributeNotFoundException("Appointment not found with ID: " + id));

        appointementRepository.delete(appointment);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);

        return ResponseEntity.ok(response);
    }

}
