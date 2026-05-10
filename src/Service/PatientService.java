package Service;

import Entity.Patient;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PatientService {
    Scanner scanner = new Scanner(System.in);
    private static List<Patient> patients = new ArrayList<>();
    public void addPatient(Patient patient){
        patients.add(patient);
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
