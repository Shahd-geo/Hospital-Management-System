package Entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Patient extends Person {
    String patientId;
    String bloodGroup;
    List<String> allergies = new ArrayList<>();
    String emergencyContact;
    LocalDate registrationDate;
    String insuranceId;
    List<String> medicalRecords = new ArrayList<>();
    List<String> appointments = new ArrayList<>();

    public Patient(String id, String firstName, String lastName, LocalDate dateOfBirth, String gender, String phoneNumber, String email, String address, LocalDate registrationDate, String patientId, List<String> medicalRecords, String insuranceId, String emergencyContact, String bloodGroup, List<String> appointments, List<String> allergies) {
        super(id, firstName, lastName, dateOfBirth, gender, phoneNumber, email, address);
        this.registrationDate = registrationDate;
        this.patientId = patientId;
        this.medicalRecords = medicalRecords;
        this.insuranceId = insuranceId;
        this.emergencyContact = emergencyContact;
        this.bloodGroup = bloodGroup;
        this.appointments = appointments;
        this.allergies = allergies;
    }
    @Override
    public void displayInfo() {
        System.out.println("patientId: " + patientId);
        System.out.println("bloodGroup: " + bloodGroup);
        System.out.println("allergies: " + allergies);
        System.out.println("emergencyContact: " + emergencyContact);
        System.out.println("registrationDate: " + registrationDate);
        System.out.println("insuranceId: " + insuranceId);
        System.out.println("medicalRecords: " + medicalRecords);
        System.out.println("appointments: " + appointments);

    }



}
