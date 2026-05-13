package Service;

import Entity.*;
import Interfaces.Manageable;
import Interfaces.Searchable;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import utility.HelperUtils;

public class PatientService  implements Manageable, Searchable {
    public static Scanner scanner = new Scanner(System.in);
    public static List<Patient> patients = new ArrayList<>();

    static List<MedicalRecord> medicalRecords = new ArrayList<>();
    static List<Appointment> appointments = new ArrayList<>();


    //add new patient
    public static Patient addPatient() {
        String id = HelperUtils.generateId("PER");
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

        String patientID = HelperUtils.generateId("PAT");


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
        String patientID = HelperUtils.generateId("PAT");
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
    public PatientService() {
    }

    // OVERLOAAD addPatient(String firstName, String lastName, String phone) - minimal info
    public void addPatient(String firstName, String lastName, String phone) {
        Patient patient = new Patient();
        patient.setFirstName(firstName);
        patient.setLastName(lastName);
        patient.setPhoneNumber(phone);
        patients.add(patient);
        System.out.println("Patient add successfully");

    }
    //Overloaded addPatient(String firstName, String lastName, String phone, String bloodGroup, String email) - with blood group
    public void addPatient(String firstName, String lastName, String phone, String bloodGroup, String email) {
        Patient patient = new Patient();
        patient.setFirstName(firstName);
        patient.setLastName(lastName);
        patient.setPhoneNumber(phone);
        patient.setBloodGroup(bloodGroup);
        patient.setEmail(email);
        patients.add(patient);
        System.out.println("Patient add successfully");

    }
    //OVERLOADED searchPatients(String keyword) - search by any field
    public List<Patient> searchPatients(String keyword) {
        List<Patient> matchedPatients = new ArrayList<>();
        for (Patient patient : patients) {
            if (patient.getPatientId().toLowerCase().contains(keyword.toLowerCase())
                    || patient.getFirstName().toLowerCase().contains(keyword.toLowerCase())
                    || patient.getLastName().toLowerCase().contains(keyword.toLowerCase())
                    || patient.getPhoneNumber().contains(keyword)
                    || patient.getBloodGroup().toLowerCase().contains(keyword.toLowerCase())
                    || patient.getEmail().toLowerCase().contains(keyword.toLowerCase())) {

                matchedPatients.add(patient);

            }

        }
        return matchedPatients;
    }
    //OVERLOAAD search by name
    public List<Patient> searchPatients(String firstName, String lastName) {
        List<Patient> matchedPatients = new ArrayList<>();
        for (Patient patient : patients) {

            if(patient.getFirstName().equalsIgnoreCase(firstName) && patient.getLastName().equalsIgnoreCase(lastName)){

                matchedPatients.add(patient);
            }


        }
        return matchedPatients;
    }


    //update existing patient
    public static void UpdatePatient(String patientId, Patient updatedPatient) {
        System.out.println("enter patient Id");
        patientId = scanner.nextLine();
        if(HelperUtils.isNotNull(patientId)){
            for (Patient p : patients) {
                if (p.getId().equals(patientId)) {
                    System.out.println("Enter new phone number:");
                    p.setPhoneNumber(scanner.nextLine());

                    System.out.println("Enter new Email ");
                    p.setEmail(scanner.nextLine());

                    System.out.println("Enter new Address Line:");
                    p.setAddress(scanner.nextLine());

                    System.out.println("Enter new Emergency Contact Name:");
                    p.setEmergencyContact(scanner.nextLine());

                    System.out.println("Enter new Insurance ID:");
                    p.setInsuranceId(scanner.nextLine());

                    System.out.println("Enter new Registration Date (YYYY-MM-DD):");
                    p.setRegistrationDate(LocalDate.parse(scanner.nextLine()));

                }
            }
        }
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
    // display filtered by criteria
    public void displayPatients(String filter){
        if(HelperUtils.isNull(filter)){
            System.out.println("Invalid filter.");
            return;
        }
        for (Patient patient : patients) {
            boolean matches = false;

            // filter by ID
            if (patient.getPatientId().toLowerCase().contains(filter.toLowerCase())) {
                matches = true;
            }

            // filter by first name
            else if (patient.getFirstName().toLowerCase().contains(filter.toLowerCase())) {
                matches = true;
            }

            // filter by last name
            else if (patient.getLastName().toLowerCase().contains(filter.toLowerCase())) {
                matches = true;
            }

            // filter by phone
            else if (patient.getPhoneNumber().contains(filter)) {
                matches = true;
            }

            // filter by gender
            else if (patient.getGender().toLowerCase().contains(filter.toLowerCase())) {
                matches = true;
            }

            if (matches) {
                patient.displayInfo();
            }
        }
        }
        //display limited number
        public void displayPatients(int limit){
            int count = 0;

            for(Patient patient :patients){

                if(count >= limit) {
                    break;
                }
                patient.displayInfo();
                count++;
            }
        }
    // OVERLOADED displayPatients()
    public void displayPatients(){

        for(Patient patient : patients){

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
    @Override
    public void add(Object entity){
        if(HelperUtils.isNull(entity)){
            System.out.println("Patient cannot be null.");
            return;
        }

        patients.add((Patient) entity);

        System.out.println("Patient added successfully.");
    }
    @Override
    public void remove(String id){

        removePatient(id);
    }

    public List<Patient> getAll(){

        return  patients;
    }
    @Override
    public void search(String keyword){
        if(HelperUtils.isNull(keyword)){
            return;
        }

        searchPatients(keyword);
    }
    @Override
    public void searchById(String id){

        getPatientById(id);
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
                Patient patient = getPatientById(patientId);

                if (patient != null){
                    patient.displayInfo();
                }

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








