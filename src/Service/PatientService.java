package Service;

import Entity.Patient;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PatientService {
    Scanner scanner = new Scanner(System.in);
    private static List<Patient> patients = new ArrayList<>();




    //add new patient
    public void addPatient(){
        System.out.println("Enter Patient ID : ");
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
