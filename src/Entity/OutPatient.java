package Entity;

import java.time.LocalDate;
import java.util.List;
import utility.HelperUtils;

public class OutPatient extends Patient{
   private int visitCount;
    private LocalDate lastVisitDate;
    private String preferredDoctorId;

    // Constructor Chaining:
// OutPatient -> Patient -> Person
    public OutPatient(String id, String firstName, String lastName, LocalDate dateOfBirth, String gender, String phoneNumber, String email, String address, LocalDate registrationDate, String patientId, List<MedicalRecord> medicalRecords, String insuranceId, String emergencyContact, String bloodGroup, List<Appointment> appointments, List<String> allergies, int visitCount, LocalDate lastVisitDate, String preferredDoctorId) {
        super(id, firstName, lastName, dateOfBirth, gender, phoneNumber, email, address, registrationDate, patientId, medicalRecords, insuranceId, emergencyContact, bloodGroup, appointments, allergies);
        this.visitCount = visitCount;
        this.lastVisitDate = lastVisitDate;
        this.preferredDoctorId = preferredDoctorId;
    }
        public int getVisitCount() {
            return visitCount;
        }

        public void setVisitCount(int visitCount) {
            if(HelperUtils.isNegative(visitCount)){
                System.out.println("Invalid visit count.");
                return;
            }
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
        @Override
        public void displayInfo() {
            super.displayInfo();
            System.out.println("Visit Count        : " + visitCount);
            System.out.println("Last Visit Date    : " + lastVisitDate);
            System.out.println("Preferred DoctorId : " + preferredDoctorId);


        }
    // scheduleFollowUp()
    public void scheduleFollowUp(LocalDate followUpDate ) {
        System.out.println("Preferred Doctor ID : " + preferredDoctorId);
        System.out.println("Follow-up scheduled successfully.");
        System.out.println("Follow-up Date : " + followUpDate);
    }
    // update Visit Count
    public void updateVisitCount(){
        visitCount++;
        lastVisitDate = LocalDate.now();
        System.out.println("Visit count updated successfully.");
        System.out.println("Total Visits : " + visitCount);
        System.out.println("Last Visit Date : " + lastVisitDate);

    }

}
