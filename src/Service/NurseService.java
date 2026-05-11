package Service;

import Entity.Doctor;
import Entity.Nurse;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NurseService {
    static Scanner scanner = new Scanner(System.in);
    static List<Nurse> nurseList = new ArrayList<>();
    static List<String> assignedPatients = new ArrayList<>();


    public static Nurse addNurse() {
        System.out.println("Enter ID : ");
        String id = scanner.nextLine();
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
        System.out.println("Enter Nurse nurse Id :");
        String nurseId = scanner.nextLine();
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
    public List<Nurse> addNurses() {

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

}
