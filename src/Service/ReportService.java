package Service;

import Entity.Appointment;
import Entity.Department;
import Entity.MedicalRecord;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReportService {
    public static void dailyAppointmentsReport(List<Appointment> appointments, LocalDate date) {
        System.out.println("===== Daily Appointments Report =====");

        boolean found = false;

        for (Appointment a : appointments) {
            if (a.getAppointmentDate().equals(date)) {
                a.displayInfo();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No appointments found for this date.");
        }
    }
    public static void doctorPerformanceReport(List<MedicalRecord> records) {

        System.out.println("===== Doctor Performance Report =====");

        Map<String, Integer> count = new HashMap<>();

        for (MedicalRecord r : records) {
            count.put(r.getDoctorId(),
                    count.getOrDefault(r.getDoctorId(), 0) + 1);
        }

        for (String doctorId : count.keySet()) {
            System.out.println("Doctor ID: " + doctorId +
                    " | Cases: " + count.get(doctorId));
        }
    }
    public static void departmentOccupancyReport(List<Department> departments) {

        System.out.println("===== Department Occupancy Report =====");

        for (Department d : departments) {

            int occupied = d.getBedCapacity() - d.getAvailableBeds();
            double percent = (occupied * 100.0) / d.getBedCapacity();

            System.out.println(d.getDepartmentName());
            System.out.println("Occupied: " + occupied);
            System.out.println("Occupancy %: " + percent);
            System.out.println("-------------------");
        }
    }
    public static void patientStatistics(List<MedicalRecord> records) {

        System.out.println("===== Patient Statistics =====");

        long totalPatients = records.stream()
                .map(MedicalRecord::getPatientId)
                .distinct()
                .count();

        System.out.println("Total Patients: " + totalPatients);
        System.out.println("Total Records: " + records.size());
    }
    public static void emergencyCasesReport(List<MedicalRecord> records) {

        System.out.println("===== Emergency Cases Report =====");

        boolean found = false;

        for (MedicalRecord r : records) {

            if (r.getDiagnosis() != null &&
                    r.getDiagnosis().toLowerCase().contains("emergency")) {

                r.displayInfo();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No emergency cases found.");
        }
    }

}
