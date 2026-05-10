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
    public Patient addPatient() {
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
        String patientID = scanner.nextLine();
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
            System.out.println("Enter c to continue or q to quit");
            if (scanner.nextLine()
                    .equalsIgnoreCase("q")) {

                allergiesloop = false;
            }
        }
        Patient patient = new Patient(id,
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

    //update existing patient
    public void editPatient(String patientId, Patient updatedPatient){

        for (int i = 0; i < patients.size(); i++){

            if (patients.get(i)
                    .getPatientId()
                    .equals(patientId)){

                patients.set(i, updatedPatient);

                System.out.println(
                        "Patient updated successfully");

                return;
            }
        }

        System.out.println("Patient not found");
    }


//
public void editPatient() {

    System.out.println("Enter patient ID to update:");
    String patientId = scanner.nextLine();

    for (Patient patient : patients) {

        if (patient.getPatientId().equalsIgnoreCase(patientId)) {

            System.out.println("Enter updated first name:");
            patient.setFirstName(scanner.nextLine());

            System.out.println("Enter updated last name:");
            patient.setLastName(scanner.nextLine());

            System.out.println("Enter updated phone number:");
            patient.setPhoneNumber(scanner.nextLine());

            System.out.println("Enter updated email:");
            patient.setEmail(scanner.nextLine());

            System.out.println("Enter updated address:");
            patient.setAddress(scanner.nextLine());

            System.out.println("Enter updated blood group:");
            patient.setBloodGroup(scanner.nextLine());

            System.out.println("Enter updated insurance id:");
            patient.setInsuranceId(scanner.nextLine());

            System.out.println("Patient updated successfully");

            return;
        }
    }

    System.out.println("Patient not found");
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
