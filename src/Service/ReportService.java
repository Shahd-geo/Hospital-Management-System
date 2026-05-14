package Service;

import Entity.Appointment;

import java.time.LocalDate;
import java.util.List;

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
}
