package Service;

import Entity.Doctor;
import Entity.Patient;

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
        scanner.nextLine();
        System.out.println("Enter departmentId :");
        String departmentId = scanner.nextLine();
        System.out.println("Enter consultationFee :");
        double consultationFee = scanner.nextDouble();
        scanner.nextLine();
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
    public static void addDoctors() {

        Doctor doctor = addDector();

        doctors.add(doctor);

        System.out.println(
                "Doctor added successfully");
    }


    // Overloaded  addDoctor(String name, String specialization, String phone)

    public void addDoctor(String name, String specialization, String phone){

        Doctor doctor = new Doctor();
        doctor.setFirstName(name);
        doctor.setSpecialization(specialization);
        doctor.setPhoneNumber(phone);

        doctors.add(doctor);
    }
    // Overloaded addDoctor String name, String specialization, String phone, double consultationFee)
    public void addDoctor(String name, String specialization, String phone, double consultationFee){
        Doctor doctor = new Doctor();
        doctor.setFirstName(name);
        doctor.setSpecialization(specialization);
        doctor.setPhoneNumber(phone);
        doctor.setConsultationFee(consultationFee);

        doctors.add(doctor);
    }


    public static void editDoctor(String doctorId){

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
                scanner.nextLine();

                System.out.println("Enter updated Doctor departmentId :");
                doctor.setDepartmentId(scanner.nextLine());

                System.out.println("Enter updated Doctor consultationFee :");
                doctor.setConsultationFee(scanner.nextDouble());
                scanner.nextLine();

                System.out.println("doctor updated successfully");

            }
        }

    }

    // remove doctor by ID
    public static void removeDoctor(String doctorId){

        boolean removed = doctors.removeIf(
                b -> b.getDoctorId()
                        .equals(doctorId)
        );

        if (removed){

            System.out.println(
                    "Doctor removed successfully");

        } else {

            System.out.println(
                    "Doctor not found");
        }
    }

    //retrieve doctor
    public static Doctor getDoctorById(String doctorId) {

        for (Doctor doctor : doctors) {
            if (doctor.getDoctorId().equals(doctorId)) {
                return doctor;
            }

        }
        System.out.println("doctor not found");
        return null;
    }
    // Overloaded assignPatient(String doctorId , String patientId)
    public void assignPatient(String doctorId, String patientId) {
        for(Doctor doctor : doctors){
            if(doctor.getDoctorId().equals(doctorId)){
                doctor.getAssignedPatients().add(patientId);

                System.out.println("Patient : " + patientId + " assigned to Dr. " + doctorId);
            }
        }
    }
    // Overloaded assignPatient(Doctor doctor, Patient patient)
    public void assignPatient(Doctor doctor, Patient patient) {

        doctor.getAssignedPatients().add(patient.getPatientId());

        System.out.println("Patient : " + patient.getPatientId() + " assigned to Dr. " + doctor.getDoctorId());
    }




    //display all doctors with formatted output
    public static void displayAllDoctors(){

        for(Doctor doctor: doctors){
            doctor.displayInfo();
        }

    }

    //get Doctors By Specialization
    public static List<Doctor> getDoctorsBySpecialization(String specialization) {

        List<Doctor> specializationDoctors = new ArrayList<>();

        for(Doctor doctor : doctors){

            if(doctor.getSpecialization().equals(specialization)){
                specializationDoctors.add(doctor);
            }
        }
        return specializationDoctors;
    }

    //get Available Doctors()
    public static List<Doctor> getAvailableDoctors(){

        List<Doctor> availableDoctors = new ArrayList<>();

        for(Doctor doctor : doctors){

            if (!doctor.getAvailableSlots().isEmpty()) {
                availableDoctors.add(doctor);
            }

        }

        return availableDoctors;
    }


    public static boolean handleDectorMenu(Integer DectorOption) {


        switch (DectorOption) {
            case 1 -> {
                addDoctors();
            }
            case 2 -> {

                System.out.println("Enter Doctor ID to update");

                    String doctorId =
                            scanner.nextLine();

                    editDoctor(doctorId);
                }

            case 3 -> {
                System.out.println("Enter dector Id to remove");
                String doctorId = scanner.nextLine();
                removeDoctor(doctorId);
            }

            case 4 -> {
                System.out.println("Enter doctor Id to getDoctorById");
                String doctorId = scanner.nextLine();

                Doctor doctor = getDoctorById(doctorId);

                if (doctor != null){

                    doctor.displayInfo();
                }
            }

            case 5 -> {
                displayAllDoctors();
            }

            case 6 -> {
                System.out.println("Enter specialization to search");
                String specialization = scanner.nextLine();
                List<Doctor> doctorsList = getDoctorsBySpecialization (specialization);
                for (Doctor doctor : doctorsList){
                    doctor.displayInfo();
                }
            }

            case 7 -> {
                List<Doctor> doctorsList = getAvailableDoctors();
                for (Doctor doctor : doctorsList){

                    doctor.displayInfo();
                }
            }


        }
        return false;
    }

}










