

// Main class
import java.util.*;
public class HospitalManagementSystem {
    public static void main(String[] args) {
        List<Patient> patients = new ArrayList<>();
        
        InPatient inpatient = new InPatient("P001", "John Doe", 45, 2000, 5);
        OutPatient outpatient = new OutPatient("P002", "Jane Smith", 30, 500);
        
        inpatient.addRecord("Blood Test: Normal");
        inpatient.addRecord("X-Ray: No issues");
        outpatient.addRecord("Routine Checkup: Healthy");
        
        patients.add(inpatient);
        patients.add(outpatient);
        
        for (Patient patient : patients) {
            patient.getPatientDetails();
            System.out.println("Total Bill: " + patient.calculateBill());
            
            if (patient instanceof MedicalRecord) {
                ((MedicalRecord) patient).viewRecords();
            }
            System.out.println("---------------------------");
        }
    }
}

// Abstract class Patient
abstract class Patient {
    private String patientId;
    private String name;
    private int age;
    
    public Patient(String patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
    }
    
    public String getPatientId() {
        return patientId;
    }
    
    public String getName() {
        return name;
    }
    
    public int getAge() {
        return age;
    }
    
    public void getPatientDetails() {
        System.out.println("Patient ID: " + patientId);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
    
    public abstract double calculateBill();
}

// Interface MedicalRecord
interface MedicalRecord {
    void addRecord(String record);
    void viewRecords();
}

// InPatient class
class InPatient extends Patient implements MedicalRecord {
    private double dailyCharge;
    private int daysAdmitted;
    private List<String> records;
    
    public InPatient(String patientId, String name, int age, double dailyCharge, int daysAdmitted) {
        super(patientId, name, age);
        this.dailyCharge = dailyCharge;
        this.daysAdmitted = daysAdmitted;
        this.records = new ArrayList<>();
    }
    
    @Override
    public double calculateBill() {
        return dailyCharge * daysAdmitted;
    }
    
    @Override
    public void addRecord(String record) {
        records.add(record);
    }
    
    @Override
    public void viewRecords() {
        System.out.println("Medical Records: " + records);
    }
}

// OutPatient class
class OutPatient extends Patient implements MedicalRecord {
    private double consultationFee;
    private List<String> records;
    
    public OutPatient(String patientId, String name, int age, double consultationFee) {
        super(patientId, name, age);
        this.consultationFee = consultationFee;
        this.records = new ArrayList<>();
    }
    
    @Override
    public double calculateBill() {
        return consultationFee;
    }
    
    @Override
    public void addRecord(String record) {
        records.add(record);
    }
    
    @Override
    public void viewRecords() {
        System.out.println("Medical Records: " + records);
    }
}
