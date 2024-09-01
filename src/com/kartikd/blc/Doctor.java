package com.kartikd.blc;

public class Doctor {
    private static int idCounter = 0;
    private int id;
    private String name;
    private String speciality;

    // Constructor
    public Doctor(String name, String speciality) {
        this.id = ++idCounter;  // Pre-incrementation: first increment and then assign
        this.name = name;
        this.speciality = speciality;
    }

    // Getters
    public int getId() {
        return id;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    // Overriding the toString method
    @Override
    public String toString() {
        return "Doctor ID: " + id + " , Name: " + name + " , Speciality: " + speciality;
    }
}
