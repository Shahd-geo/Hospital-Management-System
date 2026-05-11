package Service;

import Entity.MedicalRecord;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MedicalRecordService {
    Scanner scanner = new Scanner(System.in);
    static List<MedicalRecord> medicalRecordList = new ArrayList<>();
    public MedicalRecord addMedicalRecord() {

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
}
