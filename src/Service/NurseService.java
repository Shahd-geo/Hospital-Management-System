package Service;

import Entity.Nurse;
import Entity.Patient;
import Interfaces.Manageable;
import Interfaces.Searchable;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import utility.HelperUtils;
import utility.InputHandler;

public class NurseService  implements Manageable, Searchable {
    static Scanner scanner = new Scanner(System.in);
    static List<Nurse> nurseList = new ArrayList<>();
    static List<String> assignedPatients = new ArrayList<>();


    public static Nurse addNurse() {
        String id = HelperUtils.generateId("PER");

        String firstName = InputHandler.getStringInput("Enter Nurse First Name:");
        String lastName = InputHandler.getStringInput("Enter Nurse Last Name:");
        LocalDate DOB;

        do {

            DOB = InputHandler.getDateInput("Enter nurse DOB (yyyy-mm-dd):");

            if (!HelperUtils.isValidAge(DOB)) {
                System.out.println("Invalid nurse age.");
            }

        } while (!HelperUtils.isValidAge(DOB));

        String gender = InputHandler.getStringInput("Enter Nurse gender:");
        String phone = InputHandler.getStringInput("Enter Nurse phone number:");
        String email = InputHandler.getStringInput("Enter Nurse email:");
        String address = InputHandler.getStringInput("Enter Nurse address:");
        String nurseId = HelperUtils.generateId("NUR");
        String departmentId = InputHandler.getStringInput("Enter Nurse department Id:");
        String shift = InputHandler.getStringInput("Enter Nurse shift:");
        String qualification = InputHandler.getStringInput("Enter Nurse qualification:");

        Nurse nurse = new Nurse(
                id,
                firstName,
                lastName,
                DOB,
                gender,
                phone,
                email,
                address,
                nurseId,
                departmentId,
                shift,
                qualification,
                new ArrayList<>()
        );

        return nurse;
    }
    // add doctor
    public static List<Nurse> addNurses() {

        Boolean continueFlag = true;
        while (continueFlag) {

            nurseList.add(addNurse());
            System.out.println("Nurse add successfully");
            System.out.println("Enter c to add more , and q to exit");
            if (scanner.nextLine().equalsIgnoreCase("q")) {
                continueFlag = false;
            }
        }
        return nurseList;

    }
    public static void editNurse(String nurseId) {

        for (Nurse nurse : nurseList){

            if(nurse.getNurseId().equals(nurseId)){
                nurse.setFirstName(InputHandler.getStringInput("Enter updated Nurse first name:"));
                nurse.setLastName(InputHandler.getStringInput("Enter updated Nurse last name:"));
                nurse.setDateOfBirth(InputHandler.getDateInput("Enter updated Nurse DOB:"));
                nurse.setGender(InputHandler.getStringInput("Enter updated Nurse gender:"));
                nurse.setPhoneNumber(InputHandler.getStringInput("Enter updated Nurse phone number:"));
                nurse.setEmail(InputHandler.getStringInput("Enter updated Nurse email:"));
                nurse.setAddress(InputHandler.getStringInput("Enter updated Nurse address:"));
                nurse.setDepartmentId(InputHandler.getStringInput("Enter updated Nurse department Id:"));
                nurse.setShift(InputHandler.getStringInput("Enter updated Nurse shift:"));
                nurse.setQualification(InputHandler.getStringInput("Enter updated Nurse qualification:"));
                System.out.println("Nurse updated successfully");


            }

        }

    }
    //remove nurses
    public static void removeNurse(String nurseId){

        boolean removed = nurseList.removeIf(
                b -> b.getNurseId()
                        .equals(nurseId)
        );

        if (removed){

            System.out.println("Nurse removed successfully");

        } else {

            System.out.println("Nurse not found");
        }
    }
    //retrieve nurse
    public static Nurse getNurseById(String nurseId){

        for(Nurse nurse: nurseList){
            if(nurse.getNurseId().equals(nurseId)){
                return nurse;
            }

        }
        System.out.println("Nurse not found");
        return null;
    }
    //display all nurses
    public static void displayAllNurses(){

        for(Nurse nurse: nurseList){
            nurse.displayInfo();
        }

    }
    public static List<Nurse> getNursesByDepartment(String department){
        List<Nurse> departmentNurse = new ArrayList<>();
        for(Nurse nurse : nurseList){
            if(nurse.getDepartmentId().equals(department)){
                departmentNurse.add(nurse);
            }
        }
        return departmentNurse;
    }
    // add  Nurse By Shift
    public static List<Nurse> getNursesByShift(String shift){

        List<Nurse> shiftNurse = new ArrayList<>();

        for(Nurse nurse : nurseList){
            if(nurse.getShift().equalsIgnoreCase(shift)){
                shiftNurse.add(nurse);
            }
        }
        return shiftNurse;
    }
    @Override
    public void add(Object entity) {
        if(HelperUtils.isNull(entity)){
            System.out.println("Nurse cannot be null.");
            return;
        }

        nurseList.add((Nurse) entity);

        System.out.println("Nurse added successfully");
    }
    @Override
    public void remove(String id) {

        removeNurse(id);
    }
    @Override
    public List<Nurse> getAll() {

       return nurseList;
    }
    @Override
    public void search(String keyword) {
        if(HelperUtils.isNull(keyword)){
            System.out.println("Invalid keyword.");
            return;
        }

        List<Nurse> nurses = getNursesByDepartment(keyword);
        for (Nurse nurse : nurses){

            nurse.displayInfo();
        }
    }
    @Override
    public void searchById(String id) {

        Nurse nurse = getNurseById(id);
        if(HelperUtils.isNotNull(nurse)){

            nurse.displayInfo();
        }
    }
    public static void assignNurseToPatient(String nurseId, String patientId) {

        Nurse nurse = getNurseById(nurseId);

        if (HelperUtils.isNotNull(nurse)) {

            nurse.getAssignedPatients().add(patientId);

            System.out.println("Patient assigned to nurse successfully");

        } else {
            System.out.println("Nurse not found");
        }
    }


    public static boolean handleNurseMenu(Integer NurseOption) {


        switch (NurseOption) {
            case 1 -> {
                addNurses();
            }
            case 2 -> {
                System.out.println(
                        "Enter nurse ID to update");

                String nurseId =
                        scanner.nextLine();

                editNurse(nurseId);
            }
            case 3 -> {
                System.out.println("Enter nurse Id to remove");
                String nurseId = scanner.nextLine();
                removeNurse(nurseId);
            }

            case 4 -> {
                System.out.println("Enter nurse Id to getNurseById");
                String nurseId = scanner.nextLine();
                Nurse nurse = getNurseById(nurseId);
                if(HelperUtils.isNotNull(nurse)){

                    nurse.displayInfo();
                }
            }

            case 5 -> {
                displayAllNurses();
            }

            case 6 -> {
                System.out.println("Enter Department  Id to search ");

                String department = scanner.nextLine();

                List<Nurse> nurses = getNursesByDepartment(department);
                for (Nurse nurse : nurses){

                    nurse.displayInfo();
                }
            }

            case 7 -> {
                System.out.println("Enter shift time ");
                String shift = scanner.nextLine();

                List<Nurse> nurses = getNursesByShift(shift);
                for (Nurse nurse : nurses){

                    nurse.displayInfo();
                }


            }

        }
        return false;
    }

}


