package Service;

import Entity.Appointment;
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

}
