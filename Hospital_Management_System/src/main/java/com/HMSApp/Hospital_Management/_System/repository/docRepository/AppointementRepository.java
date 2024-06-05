package com.HMSApp.Hospital_Management._System.repository.docRepository;

import com.HMSApp.Hospital_Management._System.entity.doclogin.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointementRepository extends JpaRepository <Appointment,Long> {
}
