package Entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//Level 1 Inheritance
public class Patient extends Person {
   private String patientId;
    private String bloodGroup;
    private List<String> allergies = new ArrayList<>();
    private String emergencyContact;
   private LocalDate registrationDate;
    private String insuranceId;
    private List<MedicalRecord> medicalRecords;
    private  List<Appointment> appointments;


//Constructor Chaining:
// Patient -> Person
    public Patient(String id, String firstName, String lastName,  LocalDate dateOfBirth, String gender, String phoneNumber, String email, String address, LocalDate registrationDate, String patientId, List<MedicalRecord> medicalRecords, String insuranceId, String emergencyContact, String bloodGroup, List<Appointment> appointments, List<String> allergies) {
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

    public Patient() {

    }
    //GETTER AND SETTER

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getEmergencyContact() {
        return emergencyContact;
    }

    public void setEmergencyContact(String emergencyContact) {
        this.emergencyContact = emergencyContact;
    }

    public String getInsuranceId() {
        return insuranceId;
    }

    public void setInsuranceId(String insuranceId) {
        this.insuranceId = insuranceId;
    }

    public List<MedicalRecord> getMedicalRecords() {
        return medicalRecords;
    }

    public void setMedicalRecords(List<MedicalRecord> medicalRecords) {
        this.medicalRecords = medicalRecords;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public List<String> getAllergies() {
        return allergies;
    }

    public void setAllergies(List<String> allergies) {
        this.allergies = allergies;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("patientId: " + patientId);
        System.out.println("bloodGroup: " + bloodGroup);
        System.out.println("allergies: " + allergies);
        System.out.println("emergencyContact: " + emergencyContact);
        System.out.println("registrationDate: " + registrationDate);
        System.out.println("insuranceId: " + insuranceId);
        System.out.println("medicalRecords: " + medicalRecords);
        System.out.println("appointments: " + appointments);
    }
    public void  addMedicalRecord(MedicalRecord record){
        medicalRecords.add(record);

    }
    public void   addAppointment(Appointment  appointment){
        appointments.add(appointment);
    }
    public void updateInsurance(String newInsuranceId){
        this.insuranceId=newInsuranceId;
    }




}
