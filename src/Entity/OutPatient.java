package Entity;

import java.time.LocalDate;
import java.util.List;

public class OutPatient extends Patient{
    int visitCount;
    LocalDate lastVisitDate;
    String preferredDoctorId;

    public int getVisitCount() {
        return visitCount;
    }

    public void setVisitCount(int visitCount) {
        this.visitCount = visitCount;
    }

    public LocalDate getLastVisitDate() {
        return lastVisitDate;
    }

    public void setLastVisitDate(LocalDate lastVisitDate) {
        this.lastVisitDate = lastVisitDate;
    }

    public String getPreferredDoctorId() {
        return preferredDoctorId;
    }

    public void setPreferredDoctorId(String preferredDoctorId) {
        this.preferredDoctorId = preferredDoctorId;
    }

    public OutPatient(String id, String firstName, String lastName, LocalDate dateOfBirth, String gender, String phoneNumber, String email, String address, LocalDate registrationDate, String patientId, List<MedicalRecord> medicalRecords, String insuranceId, String emergencyContact, String bloodGroup, List<Appointment> appointments, List<String> allergies, int visitCount, LocalDate lastVisitDate, String preferredDoctorId) {
        super(id, firstName, lastName, dateOfBirth, gender, phoneNumber, email, address, registrationDate, patientId, medicalRecords, insuranceId, emergencyContact, bloodGroup, appointments, allergies);
        this.visitCount = visitCount;
        this.lastVisitDate = lastVisitDate;
        this.preferredDoctorId = preferredDoctorId;

    }
}
