package Entity;

import Interfaces.Displayable;

import java.time.LocalDate;
import java.time.LocalDateTime;
import utility.HelperUtils;


public class Appointment  implements Displayable {
    private String appointmentId;
    private String patientId;
    private String doctorId;
    private LocalDate appointmentDate;
    private String appointmentTime;
    private String status; // Scheduled/Completed/Cancelled/Rescheduled
    private String reason;
    private String notes;

    public Appointment(String appointmentId, String patientId, String doctorId, LocalDate appointmentDate, String appointmentTime, String status, String reason, String notes) {
        this.appointmentId = appointmentId;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
        this.status = status;
        this.reason = reason;
        this.notes = notes;
    }

    public Appointment() {

    }

    public String getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(String appointmentId) {
        if(!HelperUtils.isValidString(appointmentId)){

            System.out.println("Invalid appointment ID.");

            return;
        }
        this.appointmentId = appointmentId;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {

        if(!HelperUtils.isValidString(patientId)){
            System.out.println("Invalid patient ID.");
            return;
        }this.patientId = patientId;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {

        if(!HelperUtils.isValidString(doctorId)){
            System.out.println("Invalid doctor ID.");
            return;
        } this.doctorId = doctorId;
    }

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDate appointmentDate) {
        if(!HelperUtils.isValidDate(
                appointmentDate)){

            System.out.println("Invalid appointment date.");

            return;
        }
        this.appointmentDate = appointmentDate;
    }

    public String getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(String appointmentTime) {

        if(!HelperUtils.isValidString(appointmentTime)){

            System.out.println("Invalid appointment time.");

            return;
        }this.appointmentTime = appointmentTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {

        if(!HelperUtils.isValidString(status)){
            System.out.println("Invalid status.");
            return;
        }this.status = status;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        if(!HelperUtils.isValidString(reason)){
            System.out.println("Invalid reason.");
            return;
        }
        this.reason = reason;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {

        if(!HelperUtils.isValidString(notes)){
            System.out.println("Invalid notes.");
            return;
        }this.notes = notes;
    }

    // Display method
    public void displayInfo() {
        System.out.println("Appointment ID: " + appointmentId);
        System.out.println("Patient ID: " + patientId);
        System.out.println("Doctor ID: " + doctorId);
        System.out.println("Date: " + appointmentDate);
        System.out.println("Time: " + appointmentTime);
        System.out.println("Status: " + status);
        System.out.println("Reason: " + reason);
        System.out.println("Notes: " + notes);
    }

    public void reschedule(LocalDate newDate, String newTime) {
        if(!HelperUtils.isValidDate(newDate) || !HelperUtils.isValidString(newTime)){

            System.out.println("Invalid reschedule data.");

            return;
        }

        this.appointmentDate = newDate;
        this.appointmentTime = newTime;
        this.status = "Rescheduled";
    }


    public void cancel() {
        this.status = "Cancelled";
    }

    public void complete() {
        this.status = "Completed";
    }

    // overloaded addNotes(String notes)
    public void addNotes(String notes) {

        // Validate notes
        if(HelperUtils.isNull(notes)) {

            System.out.println("Notes cannot be empty.");

            return;
        }

        this.notes = notes;

        System.out.println("Notes added successfully.");
    }

    // overload addNotes(String notes, String addedBy)
    public void addNotes(String notes, String addedBy) {
        // Validate notes
        if(HelperUtils.isNull(notes)){

            System.out.println("Notes cannot be empty.");

            return;
        }

        // Validate addedBy
        if(HelperUtils.isNull(addedBy)){

            System.out.println("AddedBy cannot be empty.");

            return;
        }

        this.notes = notes + " | Added By : " + addedBy;

        System.out.println("Notes added successfully.");
    }
    // overloaded addNotes(String notes, String addedBy, LocalDateTime timestamp)

    public void addNotes(String notes, String addedBy, LocalDateTime timestamp) {

        // Validate notes
        if(HelperUtils.isNull(notes)) {

            System.out.println("Notes cannot be empty.");

            return;
        }

        // Validate addedBy
         if(HelperUtils.isNull(addedBy)) {

            System.out.println("AddedBy cannot be empty.");

            return;
        }

        // Validate timestamp
        if(HelperUtils.isNull(timestamp)) {

            System.out.println("Timestamp cannot be null.");

            return;
        }

        this.notes = notes + " | Added By : " + addedBy + " | Time : " + timestamp;

        System.out.println("Notes added successfully.");
    }

    @Override
    public void displaySummary() {

        System.out.println("Appointment : " + appointmentId + " | Status : " + status);
    }
}





