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
        String firstDoctorName = scanner.nextLine();
        System.out.println("Enter Patient Last  Name : ");
        String lastDoctorName = scanner.nextLine();
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
        String doctorId=scanner.nextLine();
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
        List<String> availableSlots =
                new ArrayList<>();

        boolean slotsLoop = true;

        while (slotsLoop){

            System.out.println(
                    "Enter available slot :");

            availableSlots.add(
                    scanner.nextLine());

            System.out.println(
                    "Enter c to continue or q to quit");

            if (scanner.nextLine()
                    .equalsIgnoreCase("q")){

                slotsLoop = false;
            }
        }


        // assigned patients
        List<String> assignedPatients =
                new ArrayList<>();


        Doctor doctor = new Doctor(
                id,
                firstDoctorName,
                lastDoctorName,
                DOB,
                gender,
                phone,
                email,
                address,
                doctorId,
                specialization,
                qualification,
                experienceYears,
                departmentId,
                consultationFee,
                availableSlots,
                assignedPatients
        );

        return doctor;
    }


    // add doctor
    public void addDoctor(Doctor doctor){

        doctors.add(doctor);

        System.out.println(
                "Doctor added successfully");
    }



}


