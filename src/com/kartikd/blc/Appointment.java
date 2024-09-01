package com.kartikd.blc;

public class Appointment {
    private Patient patient;
    private Doctor doctor;
    private String date;

    public Appointment(Patient patient, Doctor doctor, String date) {
        this.patient = patient;
        this.doctor = doctor;
        this.date = date;
    }

    public String toString() {
        String data = "Appointment: [Patient: " + patient + " , Doctor: " + doctor + " , Date: " + date + "]";
        return data;
    }
}
