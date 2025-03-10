import java.util.*;

// Patient class representing a hospital patient
class Patient {
    String name;
    List<Doctor> doctors; // A patient can consult multiple doctors

    public Patient(String name) {
        this.name = name;
        this.doctors = new ArrayList<>();
    }

    // Method to associate a doctor with a patient
    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    @Override
    public String toString() {
        return "Patient: " + name;
    }
}

// Doctor class representing a hospital doctor
class Doctor {
    String name;
    List<Patient> patients; // A doctor can have multiple patients

    public Doctor(String name) {
        this.name = name;
        this.patients = new ArrayList<>();
    }

    // Method for a doctor to consult a patient
    public void consult(Patient patient) {
        if (!patients.contains(patient)) {
            patients.add(patient); // Add patient to the doctor's list
            patient.addDoctor(this); // Establish bidirectional relationship
        }
        System.out.println(name + " is consulting " + patient.name);
    }

    @Override
    public String toString() {
        return "Doctor: " + name;
    }
}

// Hospital class managing doctors and patients
class Hospital {
    String name;
    List<Doctor> doctors; // List of doctors in the hospital
    List<Patient> patients; // List of patients in the hospital

    public Hospital(String name) {
        this.name = name;
        this.doctors = new ArrayList<>();
        this.patients = new ArrayList<>();
    }

    // Method to add a doctor to the hospital
    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    // Method to add a patient to the hospital
    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    // Method to display hospital details
    public void showDetails() {
        System.out.println("Hospital: " + name);
        System.out.println("Doctors:");
        for (Doctor d : doctors) {
            System.out.println("  " + d);
        }
        System.out.println("Patients:");
        for (Patient p : patients) {
            System.out.println("  " + p);
        }
    }
}

// Main class to test the implementation
public class HospitalManagementSystem {
    public static void main(String[] args) {
        // Create a hospital instance
        Hospital hospital = new Hospital("City Hospital");

        // Create doctors
        Doctor d1 = new Doctor("Dr. Smith");
        Doctor d2 = new Doctor("Dr. Johnson");

        // Create patients
        Patient p1 = new Patient("Alice");
        Patient p2 = new Patient("Bob");

        // Add doctors and patients to the hospital
        hospital.addDoctor(d1);
        hospital.addDoctor(d2);
        hospital.addPatient(p1);
        hospital.addPatient(p2);

        // Doctors consult patients (establishing association)
        d1.consult(p1); // Dr. Smith consults Alice
        d1.consult(p2); // Dr. Smith consults Bob
        d2.consult(p1); // Dr. Johnson consults Alice

        // Display hospital details
        hospital.showDetails();
    }
}
