package Entity;

import java.time.LocalDate;
import java.util.List;
import utility.HelperUtils;
//
public class EmergencyPatient extends InPatient{
   private String emergencyType;
   private String arrivalMode;
   private  int triageLevel;
   private boolean admittedViaER;
    // Constructor Chaining:
// EmergencyPatient -> InPatient -> Patient -> Person
    public EmergencyPatient(String id, String firstName, String lastName, LocalDate dateOfBirth, String gender, String phoneNumber, String email, String address, LocalDate registrationDate, String patientId, List<MedicalRecord> medicalRecords, String insuranceId, String emergencyContact, String bloodGroup, List<Appointment> appointments, List<String> allergies, LocalDate admissionDate, LocalDate dischargeDate, String roomNumber, String bedNumber, String admittingDoctorId, double dailyCharges, String emergencyType, String arrivalMode, int triageLevel, boolean admittedViaER) {
        super(id, firstName, lastName, dateOfBirth, gender, phoneNumber, email, address, registrationDate, patientId, medicalRecords, insuranceId, emergencyContact, bloodGroup, appointments, allergies, admissionDate, dischargeDate, roomNumber, bedNumber, admittingDoctorId, dailyCharges);
        this.emergencyType = emergencyType;
        this.arrivalMode = arrivalMode;
        this.triageLevel = triageLevel;
        this.admittedViaER = admittedViaER;
    }

    public String getEmergencyType() {
        return emergencyType;
    }

    public void setEmergencyType(String emergencyType) {

        if(!HelperUtils.isValidString(emergencyType)){
            System.out.println("Invalid emergency type.");
            return;
        }
        this.emergencyType = emergencyType;
    }

    public String getArrivalMode() {
        return arrivalMode;
    }

    public void setArrivalMode(String arrivalMode) {

        if(!HelperUtils.isValidString(arrivalMode)){
            System.out.println("Invalid arrival mode.");
            return;
        }this.arrivalMode = arrivalMode;
    }

    public int getTriageLevel() {
        return triageLevel;
    }

    public void setTriageLevel(int triageLevel){

        if(triageLevel < 1 || triageLevel > 5){

            System.out.println("Invalid triage level");
            return;
        }

        this.triageLevel = triageLevel;
    }

    public boolean isAdmittedViaER() {
        return admittedViaER;
    }

    public void setAdmittedViaER(boolean admittedViaER) {
        this.admittedViaER = admittedViaER;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();

        System.out.println("emergencyType : " + emergencyType);
        System.out.println("arrivalMode :" + arrivalMode);
        System.out.println("triageLevel: " + triageLevel);
        System.out.println("admittedViaER :" + admittedViaER);
    }
    @Override
    public void addMedicalRecord(MedicalRecord record){
        super.addMedicalRecord(record);
        System.out.println("Emergency medical record added.");
    }

}
