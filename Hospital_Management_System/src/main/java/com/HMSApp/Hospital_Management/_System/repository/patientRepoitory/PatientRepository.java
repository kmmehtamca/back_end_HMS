package com.HMSApp.Hospital_Management._System.repository.patientRepoitory;

import com.HMSApp.Hospital_Management._System.entity.patientinfo.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository <Patient,Long> {

}
