package Service;

import Entity.MedicalRecord;
import Entity.Patient;
import Interfaces.Manageable;
import Interfaces.Searchable;
import utility.HelperUtils;
import utility.InputHandler;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MedicalRecordService implements Manageable, Searchable {
    static List<MedicalRecord> medicalRecordList = new ArrayList<>();
    public static void loadSampleMedicalRecords() {

        System.out.println("Loading Medical Records sample data...");

        medicalRecordList.add(new MedicalRecord(
                HelperUtils.generateId("REC"),
                "PAT-1001",
                "DOC-1001",
                LocalDate.of(2026, 1, 10),
                "Flu",
                "Paracetamol",
                "Normal",
                "Rest and fluids"
        ));

        medicalRecordList.add(new MedicalRecord(
                HelperUtils.generateId("REC"),
                "PAT-1002",
                "DOC-1002",
                LocalDate.of(2026, 1, 12),
                "Asthma",
                "Inhaler",
                "Mild condition",
                "Follow up required"
        ));

        medicalRecordList.add(new MedicalRecord(
                HelperUtils.generateId("REC"),
                "PAT-1003",
                "DOC-1003",
                LocalDate.of(2026, 1, 15),
                "Fracture",
                "Cast applied",
                "X-ray confirmed fracture",
                "6 weeks recovery"
        ));

        medicalRecordList.add(new MedicalRecord(
                HelperUtils.generateId("REC"),
                "PAT-1004",
                "DOC-1001",
                LocalDate.of(2026, 1, 18),
                "Diabetes Check",
                "Insulin adjustment",
                "High sugar level",
                "Diet control"
        ));

        medicalRecordList.add(new MedicalRecord(
                HelperUtils.generateId("REC"),
                "PAT-1005",
                "DOC-1004",
                LocalDate.of(2026, 1, 20),
                "Headache",
                "Painkillers",
                "Normal CT scan",
                "Stress related"
        ));

        medicalRecordList.add(new MedicalRecord(
                HelperUtils.generateId("REC"),
                "PAT-1001",
                "DOC-1002",
                LocalDate.of(2026, 1, 22),
                "Follow up Flu",
                "No medication",
                "Recovered",
                "Discharged"
        ));

        medicalRecordList.add(new MedicalRecord(
                HelperUtils.generateId("REC"),
                "PAT-1006",
                "DOC-1005",
                LocalDate.of(2026, 1, 25),
                "Chest Pain",
                "ECG done",
                "Mild issue",
                "Observation"
        ));

        medicalRecordList.add(new MedicalRecord(
                HelperUtils.generateId("REC"),
                "PAT-1007",
                "DOC-1003",
                LocalDate.of(2026, 1, 27),
                "Allergy",
                "Antihistamine",
                "Skin rash",
                "Avoid allergen"
        ));

        medicalRecordList.add(new MedicalRecord(
                HelperUtils.generateId("REC"),
                "PAT-1008",
                "DOC-1006",
                LocalDate.of(2026, 2, 1),
                "Back Pain",
                "Physiotherapy",
                "Muscle strain",
                "Exercise recommended"
        ));

        medicalRecordList.add(new MedicalRecord(
                HelperUtils.generateId("REC"),
                "PAT-1009",
                "DOC-1002",
                LocalDate.of(2026, 2, 3),
                "Fever",
                "Paracetamol",
                "Viral infection",
                "Hydration"
        ));

        medicalRecordList.add(new MedicalRecord(
                HelperUtils.generateId("REC"),
                "PAT-1010",
                "DOC-1007",
                LocalDate.of(2026, 2, 5),
                "Eye Infection",
                "Eye drops",
                "Bacterial infection",
                "Hygiene important"
        ));

        medicalRecordList.add(new MedicalRecord(
                HelperUtils.generateId("REC"),
                "PAT-1002",
                "DOC-1001",
                LocalDate.of(2026, 2, 7),
                "Asthma Review",
                "Inhaler adjustment",
                "Improving",
                "Continue treatment"
        ));

        System.out.println("Medical Records sample data loaded successfully.");
    }

    public static MedicalRecord addMedicalRecord() {

        String recordId = HelperUtils.generateId("REC");
        String patientId = InputHandler.getStringInput("Enter patient Id:");
        String doctorId = InputHandler.getStringInput("Enter doctor Id:");
        LocalDate visitDate;

        do {
            visitDate = InputHandler.getDateInput("Enter visit date (yyyy-MM-dd):");

            if (HelperUtils.isFutureDate(visitDate)) {

                System.out.println("Visit Date date cannot be in the future.");
            }

        } while (HelperUtils.isFutureDate(visitDate));
        String diagnosis = InputHandler.getStringInput("Enter diagnosis:");
        String prescription = InputHandler.getStringInput("Enter prescription:");
        String testResults = InputHandler.getStringInput("Enter test results:");
        String notes = InputHandler.getStringInput("Enter notes:");
        MedicalRecord medicalRecord =
                new MedicalRecord(
                        recordId,
                        patientId,
                        doctorId,
                        visitDate,
                        diagnosis,
                        prescription,
                        testResults,
                        notes
                );

        return medicalRecord;
    }

    public static List<MedicalRecord> addMedicalRecords() {
        boolean continueFlag = true;

        while (continueFlag) {

            medicalRecordList.add(addMedicalRecord());
            System.out.println("Medical record added successfully");

            String choice = InputHandler.getStringInput("Enter 'c' to continue or 'q' to quit:");

            if (choice.equalsIgnoreCase("q")) {
                continueFlag = false;
            }
        }

        return medicalRecordList;

    }

    //update function
    public static void editMedicalRecord(String recordId) {

        for (MedicalRecord medicalRecord : medicalRecordList) {

            if (medicalRecord.getRecordId().equals(recordId)) {
                medicalRecord.setPatientId(InputHandler.getStringInput("Enter new patient Id:"));
                medicalRecord.setDoctorId(InputHandler.getStringInput("Enter new doctor Id:"));
                medicalRecord.setVisitDate(InputHandler.getDateInput("Enter new visit date:"));
                medicalRecord.setDiagnosis(InputHandler.getStringInput("Enter new diagnosis:"));
                medicalRecord.setPrescription(InputHandler.getStringInput("Enter new prescription:"));
                medicalRecord.setTestResults(InputHandler.getStringInput("Enter new test results:"));
                medicalRecord.setNotes(InputHandler.getStringInput("Enter new notes:"));
                System.out.println("Medical record updated successfully");


            }

        }

    }

    // remove doctor by ID
    public static void removeRecord(String recordId) {

        boolean removed = medicalRecordList.removeIf(
                b -> b.getRecordId()
                        .equals(recordId)
        );

        if (removed) {

            System.out.println(
                    "Record removed successfully");

        } else {

            System.out.println(
                    "Recored not found");
        }
    }

    //retrieve medical record
    public static MedicalRecord getMedicalRecord(String recordId) {

        for (MedicalRecord medicalRecord : medicalRecordList) {
            if (medicalRecord.getRecordId().equals(recordId)) {
                return medicalRecord;
            }

        }
        System.out.println("medical Record not found");
        return null;
    }

    //Records By PatientId
    public static List<MedicalRecord> getRecordsByPatientId(String patientId) {

        List<MedicalRecord> patientMedicalRecords = new ArrayList<>();

        for (MedicalRecord medicalRecord : medicalRecordList) {

            if (medicalRecord.getPatientId().equalsIgnoreCase(patientId)) {
                patientMedicalRecords.add(medicalRecord);
            }
        }

        return patientMedicalRecords;
    }
    // getRecordsByDoctorId(String doctorId)

    public static List<MedicalRecord> getRecordsByDoctorId(String doctorId) {

        List<MedicalRecord> doctorMedicalRecords = new ArrayList<>();

        for (MedicalRecord medicalRecord : medicalRecordList) {

            if (medicalRecord.getDoctorId().equalsIgnoreCase(doctorId)) {
                doctorMedicalRecords.add(medicalRecord);
            }
        }

        return doctorMedicalRecords;
    }
    //display PatientHistory

    public static void displayPatientHistory(String patientId) {
        if (HelperUtils.isNull(patientId)) {
            System.out.println("Invalid patient ID.");
            return;
        }

        for (MedicalRecord medicalRecord : medicalRecordList) {
            if (medicalRecord.getPatientId().equalsIgnoreCase(patientId)) {
                medicalRecord.displayInfo();
            }
        }
    }

    @Override
    public void add(Object entity) {
        if (HelperUtils.isNull(entity)) {
            System.out.println(
                    "Medical record cannot be null.");
            return;
        }

        medicalRecordList.add((MedicalRecord) entity);
        System.out.println(
                "Medical record added successfully");
    }

    @Override
    public void remove(String id) {

        removeRecord(id);
    }

    @Override
    public List<MedicalRecord> getAll() {

        return medicalRecordList;
    }

    @Override
    public void search(String keyword) {
        if (HelperUtils.isNull(keyword)) {
            System.out.println("Invalid keyword.");
            return;
        }

        List<MedicalRecord> records = getRecordsByPatientId(keyword);

        for (MedicalRecord medicalRecord : records) {

            medicalRecord.displayInfo();
        }
    }

    @Override
    public void searchById(String id) {
        MedicalRecord medicalRecord = getMedicalRecord(id);
        if (HelperUtils.isNotNull(medicalRecord)) {
            medicalRecord.displayInfo();
        }
    }

    public static void viewAllRecords() {

        if (medicalRecordList.isEmpty()) {
            System.out.println("No records found.");
            return;
        }

        for (MedicalRecord record : medicalRecordList) {
            record.displayInfo();
        }
    }


    public static boolean handleMedicalRecoredMenu(Integer RecordOption) {


        switch (RecordOption) {
            case 1 -> {
                addMedicalRecords();
            }
            case 2 -> {
                viewAllRecords();
            }
            case 3 -> {
                String patientId = InputHandler.getStringInput("Enter Patient ID:");
                List<MedicalRecord> records = getRecordsByPatientId(patientId);

                if (records.isEmpty()) {
                    System.out.println("No records found for this patient.");
                    return false;
                }

                for (MedicalRecord r : records) {
                    r.displayInfo();
                }
            }

            case 4 -> {

                String doctorId = InputHandler.getStringInput("Enter Doctor ID:");
                List<MedicalRecord> records = getRecordsByDoctorId(doctorId);

                if (records.isEmpty()) {
                    System.out.println("No records found for this doctor.");
                    return false;
                }

                for (MedicalRecord r : records) {
                    r.displayInfo();
                }
            }


            case 5 -> {
                String recordId = InputHandler.getStringInput("Enter Record ID:");
                editMedicalRecord(recordId);
            }

                case 6 -> {
                    String recordId = InputHandler.getStringInput("Enter Record ID:");
                    removeRecord(recordId);
                }


            case 7 -> {
                String patientId = InputHandler.getStringInput("Enter Patient ID:");
                displayPatientHistory(patientId);
            }


            default -> {
                System.out.println("Invalid option.");
            }
        }

        return false;
    }
}