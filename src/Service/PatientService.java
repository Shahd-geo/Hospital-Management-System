package Service;

import Entity.Appointment;
import Entity.MedicalRecord;
import Entity.Patient;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PatientService {
    Scanner scanner = new Scanner(System.in);
    private static List<Patient> patients = new ArrayList<>();
    List<MedicalRecord> medicalRecords = new ArrayList<>();
    List<Appointment> appointments = new ArrayList<>();





    //add new patient
    public Patient addPatient(){
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
        String address =scanner.nextLine();
        System.out.println("Enter patient id :");
        String patientID = scanner.nextLine();
        System.out.println("Enter patient blood group :");
        String bloodGroup = scanner.nextLine();
        System.out.println("Enter emergency contact :");
        String emergencyContact=scanner.nextLine();
        System.out.println("Enter registration date (yyyy-mm-dd): ");
        String dateOfRegistration = scanner.nextLine();
        LocalDate DOR = LocalDate.parse(dateOfRegistration);
        System.out.println("Enter insurance id :");
        String insuranceId=scanner.nextLine();
        List<String> allergies = new ArrayList<>();

        boolean allergiesloop = true;
        while (allergiesloop) {
            System.out.println("Enter allergy :");
            allergies.add(scanner.nextLine());
            System.out.println(  "Enter c to continue or q to quit");
            if (scanner.nextLine()
                    .equalsIgnoreCase("q")) {

                allergiesloop = false;
            }
        }
        Patient patient = new Patient (id,fristPatientName,DOB,lastPatientName,gender,phone,email,address,patientID,bloodGroup,allergies,emergencyContact,DOR,medicalRecords,insuranceId,appointments);

        return patient;


        }



    public List<Patient> addPatients(){

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


        while (allergiesloop) {

            System.out.println("Enter allergy :");
            allergies.add(scanner.nextLine());

            System.out.println("Enter c to continue or q to quit");

            if (scanner.nextLine().equalsIgnoreCase("q")) {
                allergiesloop = false;
            }
        }



}
    public void displayAllPatients() {
        for (Patient Patient : patients){
            Patient.displayInfo();
        }
    }
    public Patient getPatientById(String patientId){
        for (Patient patient : patients) {

            if (patient.getPatientId().equals(patientId)) {

                return patient;
            }
        }

        return null;
    }
    public void removePatient(String patientId) {
        Patient patient = getPatientById(patientId);

        if (patient != null) {

            patients.remove(patient);
        }
    }
    public void editPatient(String patientId, Patient updatedPatient) {
        Patient patient = getPatientById(patientId);

        if (patient != null) {

            patients.remove(patient);

            patients.add(updatedPatient);
        }
    }
    public void searchPatientsByName(String name) {

        for (Patient patient : patients) {

            String fullName = patient.getFirstName() + " " + patient.getLastName();

            if (fullName.toLowerCase().contains(name.toLowerCase())) {

                patient.displayInfo();

                System.out.println("----------------");
            }
        }
    }


}
