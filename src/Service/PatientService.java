package Service;

import Entity.Appointment;
import Entity.MedicalRecord;
import Entity.Patient;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PatientService {
    public static Scanner scanner = new Scanner(System.in);
    public static List<Patient> patients = new ArrayList<>();

    static List<MedicalRecord> medicalRecords = new ArrayList<>();
    static List<Appointment> appointments = new ArrayList<>();


    //add new patient
    public static Patient addPatient() {
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

        System.out.println("Enter patient id :");
        String patientId = scanner.nextLine();


        System.out.println("Enter patient blood group :");
        String bloodGroup = scanner.nextLine();
        System.out.println("Enter emergency contact :");
        String emergencyContact = scanner.nextLine();
        System.out.println("Enter registration date (yyyy-mm-dd): ");
        String registrationDate = scanner.nextLine();
        LocalDate DOR = LocalDate.parse(registrationDate);
        System.out.println("Enter insurance id :");
        String insuranceId = scanner.nextLine();
        List<String> allergies = new ArrayList<>();

        boolean allergiesloop = true;
        while (allergiesloop) {
            System.out.println("Enter allergy :");
            allergies.add(scanner.nextLine());
            System.out.println("Enter c to continue  inter allergy or q to exist ");
            if (scanner.nextLine()
                    .equalsIgnoreCase("q")) {

                allergiesloop = false;
            }
        }
        String patientID = "";
        Patient patient;
        patient = new Patient(id,
                fristPatientName,
                lastPatientName,
                DOB,
                gender,
                phone,
                email,
                address,
                DOR,
                patientID,
                medicalRecords,
                insuranceId,
                emergencyContact,
                bloodGroup,
                appointments,
                allergies
        );
        return patient;
    }

    public static List<Patient> addPatients() {

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

    //update existing patient
    public static void UpdatePatient(String patientId, Patient updatedPatient) {
        for (Patient p : patients) {

            if (p.getPatientId()
                    .equals(patientId)) {

                p.setPhoneNumber(
                        updatedPatient.getPhoneNumber());

                p.setEmail(
                        updatedPatient.getEmail());

                p.setAddress(
                        updatedPatient.getAddress());

                p.setEmergencyContact(
                        updatedPatient.getEmergencyContact());

                p.setInsuranceId(
                        updatedPatient.getInsuranceId());

                p.setRegistrationDate(
                        updatedPatient.getRegistrationDate());

                System.out.println(
                        "Patient updated successfully");

                return;
            }
        }

        System.out.println(
                "Patient not found");
    }


    // remove patient by ID
    public static void removePatient(String patientId) {

        boolean removed =
                patients.removeIf(
                        b -> b.getPatientId()
                                .equals(patientId)
                );

        if (removed) {

            System.out.println(
                    "Patient removed successfully");

        } else {

            System.out.println("Patient not found");
        }
    }

    //PatientByIdpatient
    public static Patient getPatientById(String patientId) {

        for (Patient patient : patients) {
            if (patient.getPatientId().equals(patientId)) {
                return patient;
            }

        }
        System.out.println("patient not found");
        return null;
    }

    //display all patients with formatted output
    public static void displayAllPatients() {

        for (Patient patient : patients) {
            patient.displayInfo();
        }

    }

    //search functionality
    public static void searchPatientsByName(String name) {

        boolean found = false;


        for (Patient patient : patients) {

            String fullName = patient.getFirstName() + " " + patient.getLastName();

            if (fullName.toLowerCase().contains(name.toLowerCase())) {
                patient.displayInfo();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No patients found with this name");
        }

    }

    public static boolean handlePatientMenu(Integer PatientOption) {


        switch (PatientOption) {
            case 1 -> {
                addPatients();
            }
            case 2 -> {
                UpdatePatient(null,null);
            }
            case 3 -> {
                System.out.println("Enter patient Id to remove");
                String patientId = scanner.nextLine();
                removePatient(patientId);
            }

            case 4 -> {
                System.out.println("Enter patient Id to getDoctorById");
                String patientId = scanner.nextLine();
                getPatientById(patientId);

            }
            case 5 -> {
                displayAllPatients();

            }

            case 6 -> {
                System.out.println("Enter Name to search ");
                String name = scanner.nextLine();
                searchPatientsByName(name);


            }
        }
        return false;
    }

}








