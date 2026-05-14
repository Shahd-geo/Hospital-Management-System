package Service;

import Entity.Appointment;
import Entity.Patient;
import Interfaces.Appointable;
import Interfaces.Manageable;
import Interfaces.Searchable;
import utility.HelperUtils;
import utility.InputHandler;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AppointmentService  implements Manageable, Searchable, Appointable {
    static List<Appointment> appointmentList = new ArrayList<>();
    private static void loadSampleData() {

        appointmentList.add(new Appointment(
                HelperUtils.generateId("APP"),
                "PAT-1", "DOC-1",
                LocalDate.now().plusDays(1),
                "10:00",
                "Scheduled",
                "Checkup",
                "None"
        ));

        appointmentList.add(new Appointment(
                HelperUtils.generateId("APP"),
                "PAT-2",
                "DOC-2",
                LocalDate.now().plusDays(2),
                "11:00",
                "Scheduled",
                "Headache",
                "Bring reports"
        ));

        appointmentList.add(new Appointment(
                HelperUtils.generateId("APP"),
                "PAT-3",
                "DOC-3",
                LocalDate.now().plusDays(3),
                "12:00",
                "Scheduled",
                "Fever",
                "First visit"
        ));

        appointmentList.add(new Appointment(
                HelperUtils.generateId("APP"),
                "PAT-1",
                "DOC-2",
                LocalDate.now().minusDays(1),
                "09:00",
                "Completed",
                "Follow up",
                "Done"
        ));

        appointmentList.add(new Appointment(
                HelperUtils.generateId("APP"),
                "PAT-2",
                "DOC-1",
                LocalDate.now().plusDays(4),
                "13:00",
                "Scheduled",
                "Back pain",
                "MRI needed"
        ));

        appointmentList.add(new Appointment(
                HelperUtils.generateId("APP"),
                "PAT-3",
                "DOC-1",
                LocalDate.now().plusDays(5),
                "14:00",
                "Scheduled",
                "Flu",
                "Rest"
        ));

        appointmentList.add(new Appointment(
                HelperUtils.generateId("APP"),
                "PAT-1",
                "DOC-3",
                LocalDate.now().plusDays(6),
                "15:00",
                "Scheduled",
                "Eye check",
                "Glasses"
        ));

        appointmentList.add(new Appointment(
                HelperUtils.generateId("APP"),
                "PAT-2",
                "DOC-3",
                LocalDate.now().plusDays(7),
                "16:00",
                "Scheduled",
                "Skin issue",
                "Dermatology"
        ));

        appointmentList.add(new Appointment(
                HelperUtils.generateId("APP"),
                "PAT-3",
                "DOC-2",
                LocalDate.now().plusDays(8),
                "17:00",
                "Scheduled",
                "Allergy",
                "Test required"
        ));

        appointmentList.add(new Appointment(
                HelperUtils.generateId("APP"),
                "PAT-1",
                "DOC-1",
                LocalDate.now().plusDays(9),
                "10:30",
                "Scheduled",
                "Chest pain",
                "ECG"
        ));

        appointmentList.add(new Appointment(
                HelperUtils.generateId("APP"),
                "PAT-2",
                "DOC-2",
                LocalDate.now().plusDays(10),
                "11:30",
                "Scheduled",
                "Stomach pain",
                "Ultrasound"
        ));

        appointmentList.add(new Appointment(
                HelperUtils.generateId("APP"),
                "PAT-3",
                "DOC-3",
                LocalDate.now().plusDays(11),
                "12:30",
                "Scheduled",
                "Headache",
                "Neurology"
        ));

        appointmentList.add(new Appointment(
                HelperUtils.generateId("APP"),
                "PAT-1",
                "DOC-2",
                LocalDate.now().plusDays(12),
                "13:30",
                "Scheduled",
                "Cold",
                "Medication"
        ));

        appointmentList.add(new Appointment(
                HelperUtils.generateId("APP"),
                "PAT-2",
                "DOC-1",
                LocalDate.now().plusDays(13),
                "14:30",
                "Scheduled",
                "Fever",
                "Blood test"
        ));

        appointmentList.add(new Appointment(
                HelperUtils.generateId("APP"),
                "PAT-3",
                "DOC-2",
                LocalDate.now().plusDays(14),
                "15:30",
                "Scheduled",
                "Routine check",
                "Done"
        ));
    }
    public static void initData() {
        loadSampleData();
    }
    public static void testAppointments() {

        System.out.println("=== ALL APPOINTMENTS ===");
        for (Appointment a : appointmentList) {
            a.displayInfo();
        }

        System.out.println("\n=== BY PATIENT PAT-1 ===");
        for (Appointment a : getAppointmentsByPatient("PAT-1")) {
            a.displayInfo();
        }

        System.out.println("\n=== BY DOCTOR DOC-1 ===");
        for (Appointment a : getAppointmentsByDoctor("DOC-1")) {
            a.displayInfo();
        }

        System.out.println("\n=== UPCOMING APPOINTMENTS ===");
        for (Appointment a : getUpcomingAppointments()) {
            a.displayInfo();
        }

        System.out.println("\n=== TEST COMPLETE ===");
    }


    //add new appointment
    public static Appointment addAppointment() {

        String appointmentId = HelperUtils.generateId("APP");

        String patientId = InputHandler.getStringInput("Enter patient id");

        String doctorId = InputHandler.getStringInput("Enter doctor id");

        LocalDate date = InputHandler.getDateInput("Enter appointment date");

        String appointmentTime = InputHandler.getStringInput("Enter appointment time");

        String status = InputHandler.getStringInput("Enter status");

        String reason = InputHandler.getStringInput("Enter reason");

        String notes = InputHandler.getStringInput("Enter notes");

        Appointment appointment = new Appointment(
                appointmentId,
                patientId,
                doctorId,
                date,
                appointmentTime,
                status,
                reason,
                notes
        );

        return appointment;
    }

    public static List<Appointment> addAppointments() {
        Boolean continueFlag = true;
        while (continueFlag) {

            appointmentList.add(addAppointment());
            System.out.println("Appointment add successfully");

            System.out.println("Enter c to add more , and q to exit");
            String choice = InputHandler.getStringInput("Enter c to add more , and q to exit");
            if (choice.equalsIgnoreCase("q")) {
                continueFlag = false;
            }

        }
        return appointmentList;

    }
    // edit appointment by ID

    public static void editAppointment(String appointmentId) {

        for (Appointment appointment : appointmentList) {
            if (appointment.getAppointmentId().equals(appointmentId)) {
                appointment.setPatientId(InputHandler.getStringInput("Enter updated patient Id"));
                appointment.setDoctorId(InputHandler.getStringInput("Enter updated doctor Id"));
                LocalDate date = InputHandler.getDateInput("Enter updated appointment date");
                appointment.setAppointmentDate(date);
                appointment.setAppointmentTime(InputHandler.getStringInput("Enter updated appointment time"));
                appointment.setStatus(InputHandler.getStringInput("Enter updated status"));
                appointment.setReason(InputHandler.getStringInput("Enter updated reason"));
                appointment.setNotes(InputHandler.getStringInput("Enter updated notes"));
                System.out.println("Appointment updated successfully");


            }

        }

    }

    // Remove appointment by ID
    public static void removeAppointment(String appointmentId) {
        boolean removed = appointmentList.removeIf(
                b -> b.getAppointmentId()
                        .equals(appointmentId)
        );

        if (removed) {

            System.out.println(
                    "Appointment removed successfully");

        } else {

            System.out.println("No Appointment found");
        }
    }

    //retrieve appointment
    public static Appointment getAppointment(String appointmentId) {

        for (Appointment appointment : appointmentList) {
            if (appointment.getAppointmentId().equals(appointmentId)) {
                return appointment;
            }

        }
        System.out.println("appointment Record not found");
        return null;
    }

    //get Appointments By Patient

    public static List<Appointment> getAppointmentsByPatient(String patientId) {
        List<Appointment> patientAppointments = new ArrayList<>();

        for (Appointment appointment : appointmentList) {

            if (appointment.getPatientId().equals(patientId)) {
                patientAppointments.add(appointment);

            }
        }
        return patientAppointments;
    }
    // get Appointments By Doctor

    public static List<Appointment> getAppointmentsByDoctor(String doctorId) {

        List<Appointment> doctorAppointments = new ArrayList<>();

        for (Appointment appointment : appointmentList) {
            if (appointment.getDoctorId().equals(doctorId)) {

                doctorAppointments.add(appointment);
            }
        }
        return doctorAppointments;
    }
    // get Appointments By Date

    public static List<Appointment> getAppointmentsByDate(LocalDate date) {

        List<Appointment> dateAppointments = new ArrayList<>();

        for (Appointment appointment : appointmentList) {
            if (appointment.getAppointmentDate().equals(date)) {
                dateAppointments.add(appointment);
            }

        }
        return dateAppointments;
    }

    // reschedule Appointment
    public static void rescheduleAppointment(String appointmentId, LocalDate newDate, String newTime) {

        for (Appointment appointment : appointmentList) {
            if (appointment.getAppointmentId().equals(appointmentId)) {
                appointment.setAppointmentDate(newDate);
                appointment.setAppointmentTime(newTime);
                System.out.println("Appointment rescheduled successfully");
            }

        }

    }
    // Overloaded rescheduleAppointment(String appointmentId, LocalDate newDate)

    public void rescheduleAppointment(String appointmentId, LocalDate newDate) {

        Appointment appointment = getAppointment(appointmentId);

        if (HelperUtils.isNotNull(appointment)) {

            appointment.setAppointmentDate(newDate);
            appointment.setStatus("Rescheduled");

            System.out.println("Appointment rescheduled successfully.");

        } else {

            System.out.println("Appointment not found.");
        }
    }

    // Overloaded rescheduleAppointment(Appointment appointment, LocalDate newDate, String newTime, String reason)
    public void rescheduleAppointment(Appointment appointment, LocalDate newDate, String newTime, String reason) {
        appointment.setAppointmentDate(newDate);
        appointment.setAppointmentTime(newTime);
        appointment.setReason(reason);
        appointment.setStatus("Rescheduled");

        System.out.println("Appointment rescheduled successfully.");

    }

    // cancel Appointment
    @Override
    public void cancelAppointment(String appointmentId) {

        for (Appointment appointment : appointmentList) {

            if (appointment.getAppointmentId().equals(appointmentId)) {

                appointment.setStatus("Cancelled");

                System.out.println("Appointment cancelled successfully"
                );

                return;
            }
        }

        System.out.println("Appointment not found");
    }
    // Overloaded createAppointment(String patientId, String doctorId, LocalDate date)

    public void createAppointment(String patientId, String doctorId, LocalDate date) {

        Appointment appointment = new Appointment();

        appointment.setPatientId(patientId);

        appointment.setDoctorId(doctorId);

        appointment.setAppointmentDate(date);

        appointment.setStatus("Scheduled");

        appointmentList.add(appointment);

        System.out.println("Appointment add successfully");


    }

    //Overloaded createAppointment(String patientId, String doctorId, LocalDate date, String time)
    public void createAppointment(String patientId, String doctorId, LocalDate date, String time) {

        Appointment appointment = new Appointment();

        appointment.setPatientId(patientId);

        appointment.setDoctorId(doctorId);

        appointment.setAppointmentDate(date);

        appointment.setAppointmentTime(time);

        appointmentList.add(appointment);

        System.out.println("Appointment add successfully");


    }

    // Overloaded createAppointment(Appointment appointment)
    public void createAppointment(Appointment appointment) {

        appointmentList.add(appointment);

        System.out.println("Appointment add successfully");


    }

    // Overloaded displayAppointments(LocalDate date)
    public void displayAppointments(LocalDate date) {

        for (Appointment appointment : appointmentList) {

            if (appointment.getAppointmentDate().equals(date)) {

                appointment.displayInfo();
            }
        }
    }

    // Overloaded displayAppointments(String doctorId, LocalDate startDate, LocalDate endDate)

    public void displayAppointments(String doctorId, LocalDate startDate, LocalDate endDate) {


        for (Appointment appointment : appointmentList) {

            if (appointment.getDoctorId().equals(doctorId)) {

                LocalDate appointmentDate = appointment.getAppointmentDate();

                if ((appointmentDate.isEqual(startDate) || appointmentDate.isAfter(startDate)) &&
                        (appointmentDate.isEqual(endDate) || appointmentDate.isBefore(endDate))) {

                    appointment.displayInfo();

                }


            }
        }
    }

    @Override
    public void add(Object entity) {
        if (HelperUtils.isNull(entity)) {
            System.out.println("Appointment cannot be null.");
            return;
        }

        appointmentList.add((Appointment) entity);

        System.out.println("Appointment added successfully");
    }

    @Override
    public void remove(String id) {

        removeAppointment(id);
    }

    @Override
    public List<Appointment> getAll() {

        return appointmentList;
    }

    @Override
    public void search(String keyword) {

        List<Appointment> appointments = getAppointmentsByPatient(keyword);

        for (Appointment appointment : appointments) {

            appointment.displayInfo();
        }
    }

    @Override
    public void searchById(String id) {

        Appointment appointment = getAppointment(id);

        if (HelperUtils.isNotNull(appointment)) {

            appointment.displayInfo();
        }
    }

    @Override
    public void scheduleAppointment(Appointment appointment) {

        appointmentList.add(appointment);

        System.out.println("Appointment scheduled successfully");
    }

    public static void completeAppointment(String appointmentId) {

        for (Appointment appointment : appointmentList) {

            if (appointment.getAppointmentId().equals(appointmentId)) {

                appointment.setStatus("Completed");
                System.out.println("Appointment marked as completed");

                return;
            }
        }

        System.out.println("Appointment not found");
    }

    public static List<Appointment> getUpcomingAppointments() {

        List<Appointment> upcoming = new ArrayList<>();

        LocalDate today = LocalDate.now();

        for (Appointment appointment : appointmentList) {

            if (appointment.getAppointmentDate().isAfter(today)) {
                upcoming.add(appointment);
            }
        }

        return upcoming;
    }


    public static boolean handleAppointmentdMenu(Integer AppointmantOption) {
        AppointmentService service = new AppointmentService();
        switch (AppointmantOption) {

            case 1 -> {
                service.addAppointments();
            }

            case 2 -> {
                for (Appointment a : service.getAll()) {
                    a.displayInfo();
                }
            }

            case 3 -> {
                String patientId = InputHandler.getStringInput("Enter patient Id");
                List<Appointment> list = service.getAppointmentsByPatient(patientId);
                for (Appointment a : list) a.displayInfo();
            }

            case 4 -> {
                String doctorId = InputHandler.getStringInput("Enter doctor Id");
                List<Appointment> list = service.getAppointmentsByDoctor(doctorId);
                for (Appointment a : list) a.displayInfo();
            }

            case 5 -> {
                LocalDate date = InputHandler.getDateInput("Enter date");
                List<Appointment> list = service.getAppointmentsByDate(date);
                for (Appointment a : list) a.displayInfo();
            }

            case 6 -> {
                String id = InputHandler.getStringInput("Enter appointment Id");
                LocalDate newDate = InputHandler.getDateInput("Enter new date");
                String newTime = InputHandler.getStringInput("Enter new time");
                service.rescheduleAppointment(id, newDate, newTime);
            }

            case 7 -> {
                String id = InputHandler.getStringInput("Enter appointment Id");
                service.cancelAppointment(id);
            }

            case 8 -> {
                String id = InputHandler.getStringInput("Enter appointment Id");
                service.completeAppointment(id);
            }

            case 9 -> {
                List<Appointment> list = service.getUpcomingAppointments();
                for (Appointment a : list) a.displayInfo();
            }
        }

        return false;
    }
}