package Service;

import Entity.Doctor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DoctorService {
    static Scanner scanner = new Scanner(System.in);
    public static List<Doctor> doctors = new ArrayList<>();


    public static Doctor addDector() {
        System.out.println("Enter ID : ");
        String id = scanner.nextLine();
        System.out.println("Enter Dector First Name : ");
        String firstDoctorName = scanner.nextLine();
        System.out.println("Enter Dector Last  Name : ");
        String lastDoctorName = scanner.nextLine();
        System.out.println("Enter Dector DOB (yyyy-mm-dd): ");
        String dateOfBirth = scanner.nextLine();
        LocalDate DOB = LocalDate.parse(dateOfBirth);
        System.out.println("Enter Dector gender :");
        String gender = scanner.nextLine();
        System.out.println("Enter Dector phone number :");
        String phone = scanner.nextLine();
        System.out.println("Enter Dector email :");
        String email = scanner.nextLine();
        System.out.println("Enter Dector address :");
        String address = scanner.nextLine();
        System.out.println(" Enter doctorId;");
        String doctorId = scanner.nextLine();
        System.out.println(" Enter specialization:");
        String specialization = scanner.nextLine();
        System.out.println("Enter qualification");
        String qualification = scanner.nextLine();
        System.out.println("Enter experienceYears");
        int experienceYears = scanner.nextInt();
        System.out.println("Enter departmentId :");
        String departmentId = scanner.nextLine();
        System.out.println("Enter consultationFee :");
        double consultationFee = scanner.nextDouble();
        List<String> availableSlots =
                new ArrayList<>();

        boolean slotsLoop = true;

        while (slotsLoop) {

            System.out.println(
                    "Enter available slot :");

            availableSlots.add(
                    scanner.nextLine());

            System.out.println(
                    "Enter c to continue or q to quit");

            if (scanner.nextLine()
                    .equalsIgnoreCase("q")) {

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
    public static void addDoctor() {

        Doctor doctor = addDector();

        doctors.add(doctor);

        System.out.println(
                "Doctor added successfully");
    }
    public void editDoctor(String doctorId){

        for(Doctor doctor : doctors){

            if(doctor.getDoctorId().equals(doctorId)){

                System.out.println("Enter updated Doctor first name :");
                doctor.setFirstName(scanner.nextLine());

                System.out.println("Enter updated Doctor last name :");
                doctor.setLastName(scanner.nextLine());

                System.out.println("Enter updated Doctor DOB: ");
                String dateOfBirth = scanner.nextLine();
                LocalDate DOB = LocalDate.parse(dateOfBirth);
                doctor.setDateOfBirth(DOB);

                System.out.println("Enter updated Doctor gender :");
                doctor.setGender(scanner.nextLine());

                System.out.println("Enter updated Doctor phone number :");
                doctor.setPhoneNumber(scanner.nextLine());

                System.out.println("Enter updated Doctor email :");
                doctor.setEmail(scanner.nextLine());

                System.out.println("Enter updated Doctor address :");
                String address = scanner.nextLine();

                System.out.println("Enter updated Doctor specialization :");
                doctor.setSpecialization(scanner.nextLine());

                System.out.println("Enter updated Doctor qualification :");
                doctor.setQualification(scanner.nextLine());

                System.out.println("Enter updated Doctor experienceYears :");
                doctor.setExperienceYears(scanner.nextInt());

                System.out.println("Enter updated Doctor departmentId :");
                doctor.setDepartmentId(scanner.nextLine());

                System.out.println("Enter updated Doctor consultationFee :");
                doctor.setConsultationFee(scanner.nextDouble());

                System.out.println("doctor updated successfully");

            }
        }

    }

    // remove doctor by ID
    public void removeDoctor(String doctorId){

        doctors.removeIf(b -> b.getDoctorId() == doctorId);
        System.out.println("doctor removed successfully");

        System.out.println("doctor not found");

    }

    //retrieve doctor
    public Doctor getDoctorById(String doctorId) {

        for (Doctor doctor : doctors) {
            if (doctor.getDoctorId().equals(doctorId)) {
                return doctor;
            }

        }
        System.out.println("doctor not found");
        return null;
    }


    //display all doctors with formatted output
    public void displayAllDoctors(){

        for(Doctor doctor: doctors){
            doctor.displayInfo();
        }

    }

    //get Doctors By Specialization
    public List<Doctor> getDoctorsBySpecialization(String specialization) {

        List<Doctor> specializationDoctors = new ArrayList<>();

        for(Doctor doctor : doctors){

            if(doctor.getSpecialization().equals(specialization)){
                specializationDoctors.add(doctor);
            }
        }
        return specializationDoctors;
    }

    //get Available Doctors()
    public List<Doctor> getAvailableDoctors(){

        List<Doctor> availableDoctors = new ArrayList<>();

        for(Doctor doctor : doctors){

            if (!doctor.getAvailableSlots().isEmpty()) {
                availableDoctors.add(doctor);
            }

        }

        return availableDoctors;
    }


}






