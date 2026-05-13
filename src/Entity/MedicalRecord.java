package Entity;

import Interfaces.Displayable;

import java.time.LocalDate;
import utility.HelperUtils;

public class MedicalRecord implements Displayable {
    private String recordId;
    private String patientId;
    private String doctorId;
    private LocalDate visitDate;
    private String diagnosis;
    private String prescription;
    private String testResults;
    private String notes;

    public MedicalRecord(String recordId, String patientId, String doctorId, LocalDate visitDate, String diagnosis, String prescription, String testResults, String notes) {
        this.recordId = recordId;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.visitDate = visitDate;
        this.diagnosis = diagnosis;
        this.prescription = prescription;
        this.testResults = testResults;
        this.notes = notes;
    }

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {

        if(!HelperUtils.isValidString(recordId)){
            System.out.println("Invalid record ID.");
            return;
        }

        this.recordId = recordId;
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
        }this.doctorId = doctorId;
    }

    public LocalDate getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(LocalDate visitDate) {

        if(!HelperUtils.isValidDate(visitDate)){
            System.out.println("Invalid visit date.");
            return;
        } this.visitDate = visitDate;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        if(!HelperUtils.isValidString(diagnosis)){
            System.out.println("Invalid diagnosis.");
            return;
        }
        this.diagnosis = diagnosis;
    }

    public String getPrescription() {
        return prescription;
    }

    public void setPrescription(String prescription) {
        if(!HelperUtils.isValidString(prescription)){
            System.out.println("Invalid prescription.");
            return;
        }
        this.prescription = prescription;
    }

    public String getTestResults() {
        return testResults;
    }

    public void setTestResults(String testResults) {

        if(!HelperUtils.isValidString(testResults)){
            System.out.println("Invalid test results.");
            return;
        } this.testResults = testResults;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    //display
    public void displayInfo() {
        System.out.println("Record ID: " + recordId);
        System.out.println("Patient ID: " + patientId);
        System.out.println("Doctor ID: " + doctorId);
        System.out.println("Visit Date: " + visitDate);
        System.out.println("Diagnosis: " + diagnosis);
        System.out.println("Prescription: " + prescription);
        System.out.println("Test Results: " + testResults);
        System.out.println("Notes: " + notes);
    }
    @Override
    public void displaySummary(){

        System.out.println("Medical Record : " + recordId);
    }

}
