package com.HMSApp.Hospital_Management._System.controller.doclogincontroller;

import com.HMSApp.Hospital_Management._System.entity.doclogin.Medicine;
import com.HMSApp.Hospital_Management._System.entity.patientinfo.Patient;
import com.HMSApp.Hospital_Management._System.repository.docRepository.MedicineRepository;
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
@RequestMapping("/api/v2")
public class MedicineController {
    @Autowired
    private MedicineRepository medicineRepository;

    @PostMapping("/insert")
    public Medicine CreateMedicine(@RequestBody Medicine medicine)
    {
        return medicineRepository.save(medicine);
    }

    @GetMapping("/retrieveall")
    public List<Medicine> getallmedicine()
    {
        return medicineRepository.findAll();
    }

    @GetMapping("/retrievebyid/{id}")
    public ResponseEntity<Medicine> getMedicineID(@PathVariable Long id) throws AttributeNotFoundException {
        Medicine medicine = medicineRepository.findById(id)
                .orElseThrow(() -> new AttributeNotFoundException("Patient not found with ID: " + id));
        return ResponseEntity.ok(medicine) ;
    }
    @PutMapping("/medicines/{id}")
    public ResponseEntity<Medicine>updatemedicinebyID(@PathVariable Long id,@RequestBody Medicine medicinedetails ) throws AttributeNotFoundException {
        Medicine medicine = medicineRepository.findById(id)
                .orElseThrow(() -> new AttributeNotFoundException("Patient not found with ID: " + id));
        medicine.setDrugName(medicinedetails.getDrugName());
        medicine.setStock(medicinedetails.getStock());
        Medicine medicinesaved =  medicineRepository.save(medicine);
        return ResponseEntity.ok(medicinesaved);
    }

    @DeleteMapping("/medicines/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteAppointment(@PathVariable Long id) throws AttributeNotFoundException {
        Medicine medicine = medicineRepository.findById(id)
                .orElseThrow(() -> new AttributeNotFoundException("Medicine not found with ID: " + id));

        medicineRepository.delete(medicine);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);

        return ResponseEntity.ok(response);
    }
}

