package Service;

import Entity.MedicalRecord;
import Interfaces.Manageable;
import Interfaces.Searchable;
import utility.HelperUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MedicalRecordService implements Manageable, Searchable {
    static Scanner scanner = new Scanner(System.in);
    static List<MedicalRecord> medicalRecordList = new ArrayList<>();
    public static MedicalRecord addMedicalRecord() {

        System.out.println("Enter record Id :");
        String recordId = scanner.nextLine();
        System.out.println("Enter patient Id :");
        String patientId = scanner.nextLine();
        System.out.println("Enter doctor Id :");
        String doctorId = scanner.nextLine();
        System.out.println("Enter visit Date:");
        String visitDate = scanner.nextLine();
        LocalDate date = LocalDate.parse(visitDate);
        System.out.println("Enter diagnosis :");
        String diagnosis = scanner.nextLine();
        System.out.println("Enter prescription :");
        String prescription = scanner.nextLine();
        System.out.println("Enter test Results :");
        String testResults = scanner.nextLine();
        System.out.println("Enter notes :");
        String notes = scanner.nextLine();
        MedicalRecord medicalRecord =
                new MedicalRecord(
                        recordId,
                        patientId,
                        doctorId,
                        date,
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

                System.out.println("Enter updated patient Id :");
                medicalRecord.setPatientId(scanner.nextLine());

                System.out.println("Enter updated doctor Id :");
                medicalRecord.setDoctorId(scanner.nextLine());

                System.out.println("Enter updated visit Date:");
                String visitDate = scanner.nextLine();
                LocalDate date = LocalDate.parse(visitDate);
                medicalRecord.setVisitDate(date);

                System.out.println("Enter updated diagnosis :");
                medicalRecord.setDiagnosis(scanner.nextLine());

                System.out.println("Enter updated prescription :");
                medicalRecord.setPrescription(scanner.nextLine());

                System.out.println("Enter updated test Results :");
                medicalRecord.setTestResults(scanner.nextLine());

                System.out.println("Enter updated notes :");
                medicalRecord.setNotes(scanner.nextLine());

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


