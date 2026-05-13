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

public class NurseService  implements Manageable, Searchable {
    static Scanner scanner = new Scanner(System.in);
    static List<Nurse> nurseList = new ArrayList<>();
    static List<String> assignedPatients = new ArrayList<>();


    public static Nurse addNurse() {
        String id = HelperUtils.generateId("PER");
        System.out.println("Enter Nurse First Name : ");
        String firstNurseName = scanner.nextLine();
        System.out.println("Enter Nurse Last  Name : ");
        String lastNurseName = scanner.nextLine();
        System.out.println("Enter Nurse DOB (yyyy-mm-dd): ");
        String dateOfBirth = scanner.nextLine();
        LocalDate DOB = LocalDate.parse(dateOfBirth);
        System.out.println("Enter Nurse gender :");
        String gender = scanner.nextLine();
        System.out.println("Enter Nurse phone number :");
        String phone = scanner.nextLine();
        System.out.println("Enter Nurse email :");
        String email = scanner.nextLine();
        System.out.println("Enter Nurse address :");
        String address = scanner.nextLine();
        String nurseId = HelperUtils.generateId("NUR");
        System.out.println("Enter Nurse department Id :");
        String departmentId = scanner.nextLine();
        System.out.println("Enter Nurse shift :");
        String shift = scanner.nextLine();
        System.out.println("Enter Nurse qualification :");
        String qualification = scanner.nextLine();
        Nurse nurse = new Nurse(id, firstNurseName,lastNurseName, DOB,  gender, phone, email, address, nurseId, departmentId, shift, qualification, assignedPatients);

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

                System.out.println("Enter updated Nurse first name :");
                nurse.setFirstName(scanner.nextLine());

                System.out.println("Enter updated Nurse last name :");
                nurse.setLastName(scanner.nextLine());

                System.out.println("Enter updated Nurse DOB: ");
                String dateOfBirth = scanner.nextLine();
                LocalDate DOB = LocalDate.parse(dateOfBirth);
                nurse.setDateOfBirth(DOB);

                System.out.println("Enter updated Nurse gender :");
                nurse.setGender(scanner.nextLine());

                System.out.println("Enter updated Nurse phone number :");
                nurse.setPhoneNumber(scanner.nextLine());

                System.out.println("Enter updated Nurse email :");
                nurse.setEmail(scanner.nextLine());

                System.out.println("Enter updated Nurse address :");
                nurse.setAddress(scanner.nextLine());

                System.out.println("Enter updated Nurse department Id :");
                nurse.setDepartmentId(scanner.nextLine());

                System.out.println("Enter updated Nurse shift :");
                nurse.setShift(scanner.nextLine());

                System.out.println("Enter updated Nurse qualification :");
                nurse.setQualification(scanner.nextLine());

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
    public List<Patient> getAll() {

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


