package Entity;

import utility.HelperUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Surgeon extends Doctor {
   private int surgeriesPerformed;
   private List<String> surgeryTypes=new ArrayList<>();
    private boolean operationTheatreAccess;
    // Constructor Chaining:
// Surgeon -> Doctor -> Person
    public Surgeon(String id, String firstName, String lastName, LocalDate dateOfBirth, String gender, String phoneNumber, String email, String address, String doctorId, String specialization, String qualification, int experienceYears, String departmentId, Double consultationFee, List<String> availableSlots, List<String> assignedPatients, int surgeriesPerformed, List<String> surgeryTypes, boolean operationTheatreAccess) {
        super(id, firstName, lastName, dateOfBirth, gender, phoneNumber, email, address, doctorId, specialization, qualification, experienceYears, departmentId, consultationFee, availableSlots, assignedPatients);
        this.surgeriesPerformed = surgeriesPerformed;
        this.surgeryTypes = surgeryTypes;
        this.operationTheatreAccess = operationTheatreAccess;
    }

    public int getSurgeriesPerformed() {
        return surgeriesPerformed;
    }

    public void setSurgeriesPerformed(int surgeriesPerformed) {
        if(!HelperUtils.isPositive(surgeriesPerformed)
                && surgeriesPerformed != 0){

            System.out.println(
                    "Invalid surgeries count.");

            return;
        }
        this.surgeriesPerformed = surgeriesPerformed;
    }

    public List<String> getSurgeryTypes() {
        return surgeryTypes;
    }

    public void setSurgeryTypes(List<String> surgeryTypes) {

        if(HelperUtils.isNull(surgeryTypes)){
            System.out.println(
                    "Surgery types cannot be null.");
            return;
        }this.surgeryTypes = surgeryTypes;
    }

    public boolean isOperationTheatreAccess() {
        return operationTheatreAccess;
    }

    public void setOperationTheatreAccess(boolean operationTheatreAccess) {
        this.operationTheatreAccess = operationTheatreAccess;
    }
    public boolean  performSurgery(String surgeryType){
        if(!surgeryTypes.contains(surgeryType)){
            System.out.println("Surgery type not supported");
            return false;
        }
        if(!operationTheatreAccess){
            System.out.println("No operation theatre access");
            return false;
        }
        surgeriesPerformed++;
        return true;
    }
    // updateSurgeryCount()
    public void updateSurgeryCount(int count) {

        if(HelperUtils.isNegative(count)) {
            System.out.println("Invalid surgery count.");
            return;
        }

        this.surgeriesPerformed = count;
    }


    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("surgeries Performed : " + surgeriesPerformed);
        System.out.println("surgery Types : " + surgeryTypes);
        System.out.println("operation Theatre Access : " + operationTheatreAccess);
    }


}
