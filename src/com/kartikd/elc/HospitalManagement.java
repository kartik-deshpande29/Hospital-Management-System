package com.kartikd.elc;

import com.kartikd.blc.Appointment;
import com.kartikd.blc.Doctor;
import com.kartikd.blc.Patient;

import java.util.ArrayList;
import java.util.Scanner;

public class HospitalManagement {
    private static ArrayList<Patient> patients = new ArrayList<>();
    private static ArrayList<Doctor> doctors = new ArrayList<>();
    private static ArrayList<Appointment> appointments = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("***************HOSPITAL MANAGEMENT SYSTEM***************");
            System.out.println("1. Add Patient");
            System.out.println("2. Add Doctor");
            System.out.println("3. Schedule Appointment");
            System.out.println("4. View Patients");
            System.out.println("5. View Doctors");
            System.out.println("6. View Appointments");
            System.out.println("7. Update Patient");
            System.out.println("8. Update Doctor");
            System.out.println("9. Search Patient by ID");
            System.out.println("10. Search Doctor by ID");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addPatient(sc);
                    break;
                case 2:
                    addDoctor(sc);
                    break;
                case 3:
                    scheduleAppointment(sc);
                    break;
                case 4:
                    viewPatients();
                    break;
                case 5:
                    viewDoctors();
                    break;
                case 6:
                    viewAppointments();
                    break;
                case 7:
                    updatePatient(sc);
                    break;
                case 8:
                    updateDoctor(sc);
                    break;
                case 9:
                    searchPatientById(sc);
                    break;
                case 10:
                    searchDoctorById(sc);
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
    }

    private static void addPatient(Scanner sc) {
        System.out.print("Enter Patient's name: ");
        String name = sc.next();
        System.out.print("Enter Patient's age: ");
        int age = sc.nextInt();
        System.out.print("Enter Patient's gender: ");
        String gender = sc.next();

        Patient patient = new Patient(name, gender, age);
        patients.add(patient);
        System.out.println("Patient added successfully!");
    }

    private static void addDoctor(Scanner sc) {
        System.out.print("Enter Doctor's name: ");
        String name = sc.next();
        System.out.print("Enter Doctor's specialization: ");
        String specialization = sc.next();

        Doctor doctor = new Doctor(name, specialization);
        doctors.add(doctor);
        System.out.println("Doctor added successfully!");
    }

    private static void scheduleAppointment(Scanner sc) {
        System.out.print("Enter Patient ID: ");
        int patientId = sc.nextInt();
        System.out.print("Enter Doctor ID: ");
        int doctorId = sc.nextInt();
        System.out.print("Enter Appointment Date (YYYY-MM-DD): ");
        String date = sc.next();

        Patient patient = findPatientById(patientId);
        Doctor doctor = findDoctorById(doctorId);

        if (patient != null && doctor != null) {
            Appointment appointment = new Appointment(patient, doctor, date);
            appointments.add(appointment);
            System.out.println("Appointment scheduled successfully!");
        } else {
            System.out.println("Invalid Patient ID or Doctor ID.");
        }
    }

    private static void viewPatients() {
        System.out.println("List of Patients:");
        for (Patient patient : patients) {
            System.out.println(patient);
        }
    }

    private static void viewDoctors() {
        System.out.println("List of Doctors:");
        for (Doctor doctor : doctors) {
            System.out.println(doctor);
        }
    }

    private static void viewAppointments() {
        System.out.println("List of Appointments:");
        for (Appointment appointment : appointments) {
            System.out.println(appointment);
        }
    }

    private static Patient findPatientById(int id) {
        for (Patient patient : patients) {
            if (patient.getId() == id) {
                return patient;
            }
        }
        return null;
    }

    private static Doctor findDoctorById(int id) {
        for (Doctor doctor : doctors) {
            if (doctor.getId() == id) {
                return doctor;
            }
        }
        return null;
    }
    private static void updatePatient(Scanner sc) {
        System.out.print("Enter Patient ID to update: ");
        int id = sc.nextInt();
        Patient patient = findPatientById(id);

        if (patient != null) {
            System.out.print("Enter new name (leave blank to keep unchanged): ");
            String name = sc.next();
            if (!name.isEmpty()) {
                patient.setName(name);
            }

            System.out.print("Enter new age (leave blank to keep unchanged): ");
            int age = sc.nextInt();
            if (age > 0) {
                patient.setAge(age);
            }

            System.out.print("Enter new gender (leave blank to keep unchanged): ");
            String gender = sc.next();
            if (!gender.isEmpty()) {
                patient.setGender(gender);
            }

            System.out.println("Patient updated successfully!");
        } else {
            System.out.println("Patient not found.");
        }
    }
    private static void updateDoctor(Scanner sc) {
        System.out.print("Enter Doctor ID to update: ");
        int id = sc.nextInt();
        Doctor doctor = findDoctorById(id);

        if (doctor != null) {
            System.out.print("Enter new name (leave blank to keep unchanged): ");
            String name = sc.next();
            if (!name.isEmpty()) {
                doctor.setName(name);
            }

            System.out.print("Enter new specialization (leave blank to keep unchanged): ");
            String speciality = sc.next();
            if (!speciality.isEmpty()) {
                doctor.setSpeciality(speciality);
            }

            System.out.println("Doctor updated successfully!");
        } else {
            System.out.println("Doctor not found.");
        }
    }
    private static void searchPatientById(Scanner sc) {
        System.out.print("Enter Patient ID to search: ");
        int id = sc.nextInt();
        Patient patient = findPatientById(id);

        if (patient != null) {
            System.out.println("Patient found: " + patient);
        } else {
            System.out.println("Patient not found.");
        }
    }

    private static void searchDoctorById(Scanner sc) {
        System.out.print("Enter Doctor ID to search: ");
        int id = sc.nextInt();
        Doctor doctor = findDoctorById(id);

        if (doctor != null) {
            System.out.println("Doctor found: " + doctor);
        } else {
            System.out.println("Doctor not found.");
        }
    }

}

