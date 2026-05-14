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
    public static void loadSampleNurses() {

        nurseList.add(new Nurse(
                HelperUtils.generateId("PER"),
                "Aisha",
                "Salim",
                LocalDate.of(1995, 3, 10),
                "Female",
                "90001001",
                "aisha@gmail.com",
                "Muscat",
                HelperUtils.generateId("NUR"),
                "DEP1",
                "Morning",
                "BSN",
                new ArrayList<>()
        ));

        nurseList.add(new Nurse(
                HelperUtils.generateId("PER"),
                "Fatma",
                "Ali",
                LocalDate.of(1992, 7, 20),
                "Female",
                "90001002",
                "fatma@gmail.com",
                "Seeb",
                HelperUtils.generateId("NUR"),
                "DEP2",
                "Evening",
                "BSN",
                new ArrayList<>()
        ));

        nurseList.add(new Nurse(
                HelperUtils.generateId("PER"),
                "Sara",
                "Hassan",
                LocalDate.of(1990, 1, 15),
                "Female",
                "90001003",
                "sara@gmail.com",
                "Bawshar",
                HelperUtils.generateId("NUR"),
                "DEP3",
                "Night",
                "Diploma",
                new ArrayList<>()
        ));

        nurseList.add(new Nurse(
                HelperUtils.generateId("PER"),
                "Noor",
                "Ahmed",
                LocalDate.of(1998, 5, 5),
                "Female",
                "90001004",
                "noor@gmail.com",
                "Muscat",
                HelperUtils.generateId("NUR"),
                "DEP1",
                "Morning",
                "BSN",
                new ArrayList<>()
        ));

        nurseList.add(new Nurse(
                HelperUtils.generateId("PER"),
                "Huda",
                "Salim",
                LocalDate.of(1993, 11, 25),
                "Female",
                "90001005",
                "huda@gmail.com",
                "Seeb",
                HelperUtils.generateId("NUR"),
                "DEP2",
                "Evening",
                "BSN",
                new ArrayList<>()
        ));

        System.out.println(" Sample Nurses Loaded Successfully!");
    }


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
        String departmentId = HelperUtils.generateId("DPR");
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
                displayAllNurses();
            }
            case 3 -> {
                String department = InputHandler.getStringInput("Enter Department Id:");
                for (Nurse nurse : getNursesByDepartment(department)) {
                    nurse.displayInfo();
                }
            }

            case 4 -> {
                String shift = InputHandler.getStringInput("Enter shift:");

                for (Nurse nurse : getNursesByShift(shift)) {
                    nurse.displayInfo();
                }
            }

            case 5 -> {
                String nurseId = InputHandler.getStringInput("Enter nurse ID:");
                String patientId = InputHandler.getStringInput("Enter patient ID:");

                assignNurseToPatient(nurseId, patientId);
            }

            case 6 -> {
                String nurseId = InputHandler.getStringInput("Enter nurse ID:");
                editNurse(nurseId);
            }

            case 7 -> {
                String nurseId = InputHandler.getStringInput("Enter nurse ID:");
                removeNurse(nurseId);
            }
            case 8 -> {

                return true;
            }

                default -> {

                    System.out.println("Invalid option."
                    );
                }
        }

        return false;
    }
}





