package Entity;

import Interfaces.Billable;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import utility.HelperUtils;

public class InPatient extends Patient implements Billable {
    private LocalDate admissionDate;
    private LocalDate dischargeDate;
    private String roomNumber;
    private String bedNumber;
    private String admittingDoctorId;
    private double dailyCharges;
    // Constructor Chaining:
// InPatient -> Patient -> Person
    public InPatient(String id, String firstName, String lastName, LocalDate dateOfBirth, String gender, String phoneNumber, String email, String address, LocalDate registrationDate, String patientId, List<MedicalRecord> medicalRecords, String insuranceId, String emergencyContact, String bloodGroup, List<Appointment> appointments, List<String> allergies, LocalDate admissionDate, LocalDate dischargeDate, String roomNumber, String bedNumber, String admittingDoctorId, double dailyCharges) {
        super(id, firstName, lastName, dateOfBirth, gender, phoneNumber, email, address, registrationDate, patientId, medicalRecords, insuranceId, emergencyContact, bloodGroup, appointments, allergies);
        this.admissionDate = admissionDate;
        this.dischargeDate = dischargeDate;
        this.roomNumber = roomNumber;
        this.bedNumber = bedNumber;
        this.admittingDoctorId = admittingDoctorId;
        this.dailyCharges = dailyCharges;
    }

    public LocalDate getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(LocalDate admissionDate) {

        if(!HelperUtils.isValidDate(admissionDate)){
            System.out.println("Invalid admission date.");
            return;
        }
        this.admissionDate = admissionDate;
    }

    public LocalDate getDischargeDate() {
        return dischargeDate;
    }

    public void setDischargeDate(LocalDate dischargeDate) {
        this.dischargeDate = dischargeDate;
    }

    public String getRoomNumber() {

        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        if(!HelperUtils.isValidString(roomNumber)){
            System.out.println("Invalid room number.");
            return;
        }
        this.roomNumber = roomNumber;
    }

    public String getBedNumber() {
        return bedNumber;
    }

    public void setBedNumber(String bedNumber) {
        if(!HelperUtils.isValidString(bedNumber)){
            System.out.println("Invalid bed number.");
            return;
        }
        this.bedNumber = bedNumber;
    }

    public String getAdmittingDoctorId() {
        return admittingDoctorId;
    }

    public void setAdmittingDoctorId(String admittingDoctorId) {
        this.admittingDoctorId = admittingDoctorId;
    }

    public double getDailyCharges() {
        return dailyCharges;
    }

    public void setDailyCharges(double dailyCharges) {
        this.dailyCharges = dailyCharges;
    }
    @Override
    public void displayInfo() {
        super.displayInfo();

        System.out.println("admission Date : " + admissionDate);
        System.out.println("discharge Date :"+ dischargeDate);
        System.out.println("room Number: " + roomNumber);
        System.out.println("bedNumber :" + bedNumber);
        System.out.println("admitting Doctor Id : "+ admittingDoctorId);
        System.out.println("daily Charges: "+ dailyCharges);
        System.out.println("Stay Duration      : " + calculateStayDuration() + " days");
        System.out.println("Total Charges      : " + calculateTotalCharges());
    }
    //calculate Stay Duration
    public long  calculateStayDuration(){

        if (admissionDate == null || dischargeDate == null) {
            return 0;
        }

        return ChronoUnit.DAYS.between(admissionDate, dischargeDate);

    }
    // calculateTotalCharges()
    public double calculateTotalCharges() {

        return calculateStayDuration() * dailyCharges;
    }
    @Override
    public double calculateCharges() {

        return calculateTotalCharges();
    }
    @Override
    public void generateBill() {

        System.out.println("===== Patient Bill =====");

        System.out.println("Patient ID : " + getPatientId());

        System.out.println("Room Number : " + roomNumber);

        System.out.println("Stay Duration : " + calculateStayDuration() + " days");

        System.out.println("Total Charges : " + calculateTotalCharges());
    }
    @Override
    public void processPayment(double amount) {

        if (amount <= 0){

            System.out.println("Invalid payment amount.");

            return;
        }

        System.out.println("Payment processed successfully.");

        System.out.println("Paid Amount : " + amount);
    }


}
