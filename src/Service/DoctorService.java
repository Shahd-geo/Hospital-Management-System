package Service;

import Entity.Doctor;
import Entity.Patient;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DoctorService {
    static Scanner scanner = new Scanner(System.in);
    public List <Doctor>  doctors=new ArrayList<>();


    public static Doctor addDector() {
        System.out.println("Enter ID : ");
        String id = scanner.nextLine();
        System.out.println("Enter Patient First Name : ");
        String fristPatientName = scanner.nextLine();
        System.out.println("Enter Patient Last  Name : ");
        String lastPatientName = scanner.nextLine();
        System.out.println("Enter patient DOB (yyyy-mm-dd): ");
        String dateOfBirth = scanner.nextLine();
        LocalDate DOB = LocalDate.parse(dateOfBirth);
        System.out.println("Enter patient gender :");
        String gender = scanner.nextLine();
        System.out.println("Enter patient phone number :");
        String phone = scanner.nextLine();
        System.out.println("Enter patient email :");
        String email = scanner.nextLine();
        System.out.println("Enter patient address :");
        String address = scanner.nextLine();
        System.out.println(" Enter doctorId;");
        String dectorId=scanner.nextLine();
        System.out.println(" Enter specialization:");
        String specialization=scanner.nextLine();
        System.out.println("Enter qualification");
        String qualification=scanner.nextLine();
        System.out.println("Enter experienceYears");
        int experienceYears=scanner.nextInt();
        System.out.println("Enter departmentId :");
        String departmentId=scanner.nextLine();
        System.out.println("Enter consultationFee :");
        double consultationFee=scanner.nextDouble();
        s



        Doctor doctor = new Doctor(id,
                fristPatientName,
                lastPatientName,
                DOB,
                gender,
                phone,
                email,
                address,
                dectorId,
                specialization,
                qualification,
                experienceYears,
                departmentId,
                consultationFee,

        );
        return doctor;
    }

    public static List<Doctor> addDectores(){

        Boolean continueFlag = true;
        while (continueFlag) {

            patients.add(addPatient());
            System.out.println("Patient add successfully");

            System.out.println("Enter c to add more , and q to exit");
            if (scanner.nextLine().equalsIgnoreCase("q")) {
                continueFlag = false;
            }
        }
        return patients;

    }




}

}
