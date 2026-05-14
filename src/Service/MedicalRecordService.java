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
    public static MedicalRecord addMedicalRecord() {

        String recordId = HelperUtils.generateId("REC");
        String patientId = InputHandler.getStringInput("Enter patient Id:");
        String doctorId = InputHandler.getStringInput("Enter doctor Id:");
        LocalDate visitDate;

        do {visitDate = InputHandler.getDateInput("Enter visit date (yyyy-MM-dd):");

            if(HelperUtils.isFutureDate(visitDate)){

                System.out.println("Visit Date date cannot be in the future.");
            }

        } while(HelperUtils.isFutureDate(visitDate));
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

        Boolean continueFlag = true;
        while (continueFlag) {

            medicalRecordList.add(addMedicalRecord());
            System.out.println("Medical record add successfully");

            System.out.println("Enter c to add more , and q to exit");
            if (scanner.nextLine().equalsIgnoreCase("q")) {
                continueFlag = false;
            }
        }
        return medicalRecordList;

    }
    //update function
    public static void editMedicalRecord(String recordId) {

        for(MedicalRecord medicalRecord : medicalRecordList){

            if(medicalRecord.getRecordId().equals(recordId)){
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
    public static void removeRecored(String recordId){

        boolean removed = medicalRecordList.removeIf(
                b -> b.getRecordId()
                        .equals(recordId)
        );

        if (removed){

            System.out.println(
                    "Record removed successfully");

        } else {

            System.out.println(
                    "Recored not found");
        }
    }
    //retrieve medical record
    public static MedicalRecord getMedicalRecord(String recordId){

        for(MedicalRecord medicalRecord: medicalRecordList){
            if(medicalRecord.getRecordId().equals(recordId)){
                return medicalRecord;
            }

        }
        System.out.println("medical Record not found");
        return null;
    }
    //Records By PatientId
    public static List<MedicalRecord> getRecordsByPatientId(String patientId){

        List<MedicalRecord> patientMedicalRecords = new ArrayList<>();

        for (MedicalRecord medicalRecord : medicalRecordList){

            if(medicalRecord.getPatientId().equalsIgnoreCase(patientId)){
                patientMedicalRecords.add(medicalRecord);
            }
        }

        return patientMedicalRecords;
    }
    // getRecordsByDoctorId(String doctorId)

    public static List<MedicalRecord> getRecordsByDoctorId(String doctorId){

        List<MedicalRecord> doctorMedicalRecords = new ArrayList<>();

        for (MedicalRecord medicalRecord : medicalRecordList){

            if(medicalRecord.getDoctorId().equalsIgnoreCase(doctorId)){
                doctorMedicalRecords.add(medicalRecord);
            }
        }

        return doctorMedicalRecords;
    }
    //display PatientHistory

    public static void displayPatientHistory(String patientId) {
        if(HelperUtils.isNull(patientId)){
            System.out.println("Invalid patient ID.");
            return;
        }

        for(MedicalRecord medicalRecord : medicalRecordList){
            if(medicalRecord.getPatientId().equalsIgnoreCase(patientId)){
                medicalRecord.displayInfo();
            }
        }
    }
    @Override
    public void add(Object entity) {
        if(HelperUtils.isNull(entity)){
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

        removeRecored(id);
    }
    @Override
    public List<MedicalRecord> getAll() {

        return medicalRecordList;
    }
    @Override
    public void search(String keyword) {
        if(HelperUtils.isNull(keyword)){
            System.out.println("Invalid keyword.");
            return;
        }

        List<MedicalRecord> records = getRecordsByPatientId(keyword);

        for (MedicalRecord medicalRecord : records){

            medicalRecord.displayInfo();
        }
    }
    @Override
    public void searchById(String id) {
        MedicalRecord medicalRecord = getMedicalRecord(id);
        if(HelperUtils.isNotNull(medicalRecord)){
            medicalRecord.displayInfo();
        }
    }




    public static boolean handleMedicalRecoredMenu(Integer RecordOption) {


        switch (RecordOption) {
            case 1 -> {
                addMedicalRecords();
            }
            case 2 -> {
                System.out.println(
                        "Enter Record ID to update");

                String recordId =
                        scanner.nextLine();

                editMedicalRecord(recordId);
            }
            case 3 -> {
                System.out.println("Enter record Id to remove");
                String recordId = scanner.nextLine();
                removeRecored(recordId);
            }

            case 4 -> {

                    System.out.println("Enter record Id to getMedicalRecord");

                    String recordId = scanner.nextLine();

                    MedicalRecord medicalRecord = getMedicalRecord(recordId);
                if(HelperUtils.isNotNull(medicalRecord)){

                        medicalRecord.displayInfo();
                    }
                }

            case 5 -> {
                System.out.println("Enter patient Id to getRecordsByPatientId");

                String patientId = scanner.nextLine();

                List<MedicalRecord> records = getRecordsByPatientId(patientId);

                for (MedicalRecord medicalRecord : records){

                    medicalRecord.displayInfo();
                }
            }

            case 6 -> {
                System.out.println("Enter Doctor Id to get record");

                String doctorId = scanner.nextLine();

                List<MedicalRecord> records = getRecordsByDoctorId(doctorId);

                for (MedicalRecord medicalRecord : records){

                    medicalRecord.displayInfo();
                }
            }

            case 7 -> {
                System.out.println("Enter patientId to show history ");
                String patientId = scanner.nextLine();
                displayPatientHistory(patientId);


            }

        }
        return false;
    }

}


