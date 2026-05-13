package Entity;

import Interfaces.Displayable;
import utility.HelperUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
//Level 1 Inheritance
public class Nurse extends Person implements Displayable {
    private String nurseId;
    private String departmentId;
    private String shift;
    private String qualification;
    private List<String> assignedPatients = new ArrayList<>();
    //Constructor Chaining:
//  Nurse-> Person
    public Nurse(String id, String firstName, String lastName, LocalDate dateOfBirth, String gender, String phoneNumber, String email, String address, String nurseId, String departmentId, String shift, String qualification, List<String> assignedPatients) {
        super(id, firstName, lastName, dateOfBirth, gender, phoneNumber, email, address);
        this.nurseId = nurseId;
        this.departmentId = departmentId;
        this.shift = shift;
        this.qualification = qualification;
        this.assignedPatients = assignedPatients;
    }

    public String getNurseId() {
        return nurseId;
    }

    public void setNurseId(String nurseId) {

        if(HelperUtils.isNull(nurseId)){
            System.out.println("Invalid nurse ID.");
            return;
        }

        this.nurseId = nurseId;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {

        if(HelperUtils.isNull(departmentId)){
            System.out.println("Invalid department ID.");
            return;
        }

        this.departmentId = departmentId;
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
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
        System.out.println("nurseId: " + nurseId);
        System.out.println("departmentId: " + departmentId);
        System.out.println("shift: " + shift);
        System.out.println("qualification: " + qualification);
        System.out.println("assignedPatients: " + assignedPatients);
    }
    public void assignPatient(String patient){
        assignedPatients.add(patient);
    }
    @Override
    public void displaySummary(){

        System.out.println("Nurse : " + getFirstName() + " " + getLastName());
    }


}
