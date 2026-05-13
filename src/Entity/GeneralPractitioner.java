package Entity;

import utility.HelperUtils;

import java.time.LocalDate;
import java.util.List;

public class GeneralPractitioner  extends Doctor{
   private boolean walkinAvailable;
   private boolean homeVisitAvailable;
  private   boolean vaccinationCertified;
    // Constructor Chaining:
// GeneralPractitioner -> Doctor -> Person
    public GeneralPractitioner(String id, String firstName, String lastName, LocalDate dateOfBirth, String gender, String phoneNumber, String email, String address, String doctorId, String specialization, String qualification, int experienceYears, String departmentId, Double consultationFee, List<String> availableSlots, List<String> assignedPatients, boolean walkinAvailable, boolean homeVisitAvailable, boolean vaccinationCertified) {
        super(id, firstName, lastName, dateOfBirth, gender, phoneNumber, email, address, doctorId, specialization, qualification, experienceYears, departmentId, consultationFee, availableSlots, assignedPatients);
        this.walkinAvailable = walkinAvailable;
        this.homeVisitAvailable = homeVisitAvailable;
        this.vaccinationCertified = vaccinationCertified;
    }

    public boolean isWalkinAvailable() {
        return walkinAvailable;
    }

    public void setWalkinAvailable(boolean walkinAvailable) {
        this.walkinAvailable = walkinAvailable;
    }

    public boolean isHomeVisitAvailable() {
        return homeVisitAvailable;
    }

    public void setHomeVisitAvailable(boolean homeVisitAvailable) {
        this.homeVisitAvailable = homeVisitAvailable;
    }

    public boolean isVaccinationCertified() {
        return vaccinationCertified;
    }

    public void setVaccinationCertified(boolean vaccinationCertified) {
        this.vaccinationCertified = vaccinationCertified;
    }
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("walk in Available : "+ walkinAvailable);
        System.out.println("home Visit Available :"+ homeVisitAvailable);
        System.out.println("vaccination Certified :"+ vaccinationCertified);
    }
    //scheduleHomeVisit
    public void scheduleHomeVisit(String patientName, String address) {
        if(!HelperUtils.isValidString(patientName) || !HelperUtils.isValidString(address)){

            System.out.println("Invalid patient data.");

            return;
        }
        if(!homeVisitAvailable){
            System.out.println("Home visit is not available.");

            return;
        }
        System.out.println("Home visit scheduled successfully.");

        System.out.println("Patient Name : " + patientName);

        System.out.println("Address : " + address);
    }
    // administerVaccine()
    public void administerVaccine(String patientName, String vaccineName) {
        if(!HelperUtils.isValidString(patientName)
                || !HelperUtils.isValidString(vaccineName)){

            System.out.println("Invalid vaccine data.");

            return;
        }
        if(!vaccinationCertified){
            System.out.println("Doctor is not certified for vaccination.");

            return;
        }
        System.out.println("Vaccine administered successfully.");

        System.out.println("Patient Name : " + patientName);

        System.out.println("Vaccine : " + vaccineName);
    }

}
