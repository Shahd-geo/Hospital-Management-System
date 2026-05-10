package Service;

import Entity.Patient;
import java.util.ArrayList;
import java.util.List;

public class PatientService {
    private static List<Patient> patients = new ArrayList<>();
    public void addPatient(Patient patient){
        patients.add(patient);
    }
    public void displayAllPatients() {
        for (Patient Patient : patients){
            Patient.displayInfo();
        }
    }
}
