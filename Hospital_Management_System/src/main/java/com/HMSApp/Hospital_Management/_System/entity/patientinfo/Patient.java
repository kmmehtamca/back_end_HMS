package com.HMSApp.Hospital_Management._System.entity.patientinfo;

import jakarta.persistence.*;

@Entity
@Table(name="patients")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long  id;
    @Column(name="first_name")
    private String  firstName;
    @Column(name="middle_name")
    private String  middleName;
    @Column(name="last_name")
    private String  lastName;
    @Column(name="age")
    private String  age;
    @Column(name="blood_group")
    private String  blood;
    @Column(name="prescription")
    private String  prescription;
    @Column(name="dose")
    private String  dose;
    @Column(name="fees")
    private String  fees;
    @Column(name="urgency")
    private String  urgency;

    public Patient() {
    }

    public Patient(long id,String age, String blood, String dose, String fees, String firstName, String lastName, String middleName, String prescription, String urgency) {
        this.id = id;
        this.age = age;
        this.blood = blood;
        this.dose = dose;
        this.fees = fees;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.prescription = prescription;
        this.urgency = urgency;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getBlood() {
        return blood;
    }

    public void setBlood(String blood) {
        this.blood = blood;
    }

    public String getDose() {
        return dose;
    }

    public void setDose(String dose) {
        this.dose = dose;
    }

    public String getFees() {
        return fees;
    }

    public void setFees(String fees) {
        this.fees = fees;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName= lastName;
    }

    public String getMiddleName() {
        return this.middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getPrescription() {
        return prescription;
    }

    public void setPrescription(String prescription) {
        this.prescription = prescription;
    }

    public String getUrgency() {
        return urgency;
    }

    public void setUrgency(String urgency) {
        this.urgency = urgency;
    }
}

