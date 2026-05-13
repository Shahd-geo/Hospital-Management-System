package Entity;

import Interfaces.Displayable;
import utility.HelperUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

// Inheritance from person class
public class Doctor extends Person implements Displayable {
    private String doctorId;
    private String specialization;
    private String qualification;
   private int experienceYears;
   private String departmentId;
   private double consultationFee;
   private List<String> availableSlots =new ArrayList<>();
   private List<String> assignedPatients = new ArrayList<>();

   // Constructor Chaining:
// Doctor -> Person

    public Doctor(String id, String firstName, String lastName, LocalDate dateOfBirth, String gender, String phoneNumber, String email, String address, String doctorId, String specialization, String qualification, int experienceYears, String departmentId, Double consultationFee, List<String> availableSlots, List<String> assignedPatients) {
        super(id, firstName, lastName, dateOfBirth, gender, phoneNumber, email, address);
        this.doctorId = doctorId;
        this.specialization = specialization;
        this.qualification = qualification;
        this.experienceYears = experienceYears;
        this.departmentId = departmentId;
        this.consultationFee = consultationFee;
        this.availableSlots = availableSlots;
        this.assignedPatients = assignedPatients;
    }

    public Doctor() {

    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {

        if(HelperUtils.isNull(doctorId)){
            System.out.println("Invalid doctor ID.");
            return;
        }

        this.doctorId = doctorId;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {

        if(!HelperUtils.isValidString(
                specialization)){

            System.out.println("Invalid specialization.");

            return;
        }

        this.specialization = specialization;
    }
    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    public void setExperienceYears(int experienceYears) {
        this.experienceYears = experienceYears;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public Double getConsultationFee() {
        return consultationFee;
    }

    public void setConsultationFee(Double consultationFee) {
        this.consultationFee = consultationFee;
    }

    public List<String> getAvailableSlots() {
        return availableSlots;
    }

    public void setAvailableSlots(List<String> availableSlots) {
        this.availableSlots = availableSlots;
    }

    public List<String> getAssignedPatients() {
        return assignedPatients;
    }

    public void setAssignedPatients(List<String> assignedPatients) {
        this.assignedPatients = assignedPatients;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("doctorId: " + doctorId);
        System.out.println("specialization: " + specialization);
        System.out.println("qualification: " + qualification);
        System.out.println("experienceYears: " + experienceYears);
        System.out.println("departmentId: " + departmentId);
        System.out.println("consultationFee: " + consultationFee);
        System.out.println("availableSlots: " + availableSlots);
        System.out.println("assignedPatients: " + assignedPatients);
    }

    public void  assignPatient(String patient){
        assignedPatients.add(patient);
    }
    public void  removePatient(String patient){
        assignedPatients.remove(patient);
    }
    public void updateAvailability(List<String> slots) {
        this.availableSlots=slots;
    }

    // overloaded updateFee(double fee)
    public void updateFee(double fee){
        if (fee < 0) {
            System.out.println("Fee cannot be negative.");
            return;
        }

        this.consultationFee = fee;

        System.out.println("Fee updated successfully");

    }
    //overloaded updateFee(double fee, String reason)
    public void updateFee(double fee, String reason){
        // Validate fee amount
        if (fee < 0) {

            System.out.println("Fee cannot be negative.");

            return;
        }
        if (reason == null || reason.trim().isEmpty()) {
            System.out.println("Reason cannot be empty.");
            return;
        }

        this.consultationFee = fee;

        System.out.println("Fee updated successfully because of  : " + reason );

    }
    //overload addAvailability(String slot)
    public void  addAvailability(String slot){
        // Validate slot
        if (slot == null || slot.trim().isEmpty()) { //check if user inter slot correctly
            System.out.println("Availability slot cannot be empty.");
            return;
        }
        availableSlots.add(slot);
        System.out.println("Availability added successfully.");

    }
    //overload  addAvailability(List<String> slots)
    public void addAvailability(List<String> slots){  //take list of slots
        // Check if the list is empty
        if (slots == null || slots.isEmpty()) {
            System.out.println("No availability slots provided.");
            return;
        }
        // Add all slot to doctor's availability schedule
        availableSlots.addAll(slots);
        System.out.println("Availability slots added successfully.");

    }
    @Override
    public void displaySummary(){
        System.out.println("Doctor : " + getFirstName() + " " + getLastName() + " | Specialization : " + specialization);
    }

}


