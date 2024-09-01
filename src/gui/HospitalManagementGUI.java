//package gui;
//
//import com.kartikd.blc.Appointment;
//import com.kartikd.blc.Doctor;
//import com.kartikd.blc.Patient;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.util.ArrayList;
//
//public class HospitalManagementGUI extends JFrame {
//    private static ArrayList<Patient> patients = new ArrayList<>();
//    private static ArrayList<Doctor> doctors = new ArrayList<>();
//    private static ArrayList<Appointment> appointments = new ArrayList<>();
//
//    private JTextField patientNameField;
//    private JTextField patientAgeField;
//    private JTextField patientGenderField;
//
//    private JTextField doctorNameField;
//    private JTextField doctorSpecialityField;
//
//    private JTextField appointmentPatientIdField;
//    private JTextField appointmentDoctorIdField;
//    private JTextField appointmentDateField;
//
//    private JTextArea displayArea;
//
//    public HospitalManagementGUI() {
//        setTitle("Hospital Management System");
//        setSize(600, 400);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setLayout(new BorderLayout());
//
//        JTabbedPane tabbedPane = new JTabbedPane();
//
//        JPanel addPatientPanel = new JPanel(new GridLayout(4, 2));
//        addPatientPanel.add(new JLabel("Patient Name:"));
//        patientNameField = new JTextField();
//        addPatientPanel.add(patientNameField);
//        addPatientPanel.add(new JLabel("Patient Age:"));
//        patientAgeField = new JTextField();
//        addPatientPanel.add(patientAgeField);
//        addPatientPanel.add(new JLabel("Patient Gender:"));
//        patientGenderField = new JTextField();
//        addPatientPanel.add(patientGenderField);
//        JButton addPatientButton = new JButton("Add Patient");
//        addPatientPanel.add(addPatientButton);
//        addPatientButton.addActionListener(new AddPatientListener());
//        tabbedPane.addTab("Add Patient", addPatientPanel);
//
//        JPanel addDoctorPanel = new JPanel(new GridLayout(3, 2));
//        addDoctorPanel.add(new JLabel("Doctor Name:"));
//        doctorNameField = new JTextField();
//        addDoctorPanel.add(doctorNameField);
//        addDoctorPanel.add(new JLabel("Doctor Speciality:"));
//        doctorSpecialityField = new JTextField();
//        addDoctorPanel.add(doctorSpecialityField);
//        JButton addDoctorButton = new JButton("Add Doctor");
//        addDoctorPanel.add(addDoctorButton);
//        addDoctorButton.addActionListener(new AddDoctorListener());
//        tabbedPane.addTab("Add Doctor", addDoctorPanel);
//
//        JPanel scheduleAppointmentPanel = new JPanel(new GridLayout(4, 2));
//        scheduleAppointmentPanel.add(new JLabel("Patient ID:"));
//        appointmentPatientIdField = new JTextField();
//        scheduleAppointmentPanel.add(appointmentPatientIdField);
//        scheduleAppointmentPanel.add(new JLabel("Doctor ID:"));
//        appointmentDoctorIdField = new JTextField();
//        scheduleAppointmentPanel.add(appointmentDoctorIdField);
//        scheduleAppointmentPanel.add(new JLabel("Appointment Date (YYYY-MM-DD):"));
//        appointmentDateField = new JTextField();
//        scheduleAppointmentPanel.add(appointmentDateField);
//        JButton scheduleAppointmentButton = new JButton("Schedule Appointment");
//        scheduleAppointmentPanel.add(scheduleAppointmentButton);
//        scheduleAppointmentButton.addActionListener(new ScheduleAppointmentListener());
//        tabbedPane.addTab("Schedule Appointment", scheduleAppointmentPanel);
//
//        displayArea = new JTextArea();
//        displayArea.setEditable(false);
//        add(new JScrollPane(displayArea), BorderLayout.CENTER);
//
//        add(tabbedPane, BorderLayout.NORTH);
//    }
//
//    private class AddPatientListener implements ActionListener {
//        public void actionPerformed(ActionEvent e) {
//            String name = patientNameField.getText();
//            int age = Integer.parseInt(patientAgeField.getText());
//            String gender = patientGenderField.getText();
//
//            Patient patient = new Patient(name, gender, age);
//            patients.add(patient);
//            displayArea.append("Patient added: " + patient + "\n");
//        }
//    }
//
//    private class AddDoctorListener implements ActionListener {
//        public void actionPerformed(ActionEvent e) {
//            String name = doctorNameField.getText();
//            String speciality = doctorSpecialityField.getText();
//
//            Doctor doctor = new Doctor(name, speciality);
//            doctors.add(doctor);
//            displayArea.append("Doctor added: " + doctor + "\n");
//        }
//    }
//
//    private class ScheduleAppointmentListener implements ActionListener {
//        public void actionPerformed(ActionEvent e) {
//            int patientId = Integer.parseInt(appointmentPatientIdField.getText());
//            int doctorId = Integer.parseInt(appointmentDoctorIdField.getText());
//            String date = appointmentDateField.getText();
//
//            Patient patient = findPatientById(patientId);
//            Doctor doctor = findDoctorById(doctorId);
//
//            if (patient != null && doctor != null) {
//                Appointment appointment = new Appointment(patient, doctor, date);
//                appointments.add(appointment);
//                displayArea.append("Appointment scheduled: " + appointment + "\n");
//            } else {
//                displayArea.append("Invalid Patient ID or Doctor ID.\n");
//            }
//        }
//    }
//
//    private Patient findPatientById(int id) {
//        for (Patient patient : patients) {
//            if (patient.getId() == id) {
//                return patient;
//            }
//        }
//        return null;
//    }
//
//    private Doctor findDoctorById(int id) {
//        for (Doctor doctor : doctors) {
//            if (doctor.getId() == id) {
//                return doctor;
//            }
//        }
//        return null;
//    }
//
//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(new Runnable() {
//            public void run() {
//                new HospitalManagementGUI().setVisible(true);
//            }
//        });
//    }
//}
