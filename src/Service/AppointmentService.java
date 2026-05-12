package Service;

import Entity.Appointment;
import Interfaces.Appointable;
import Interfaces.Manageable;
import Interfaces.Searchable;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AppointmentService  implements Manageable, Searchable, Appointable {
    static List<Appointment> appointmentList = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    //add new appointment
    public static Appointment addAppointment() {

        System.out.println("Enter appointment Id :");
        String appointmentId = scanner.nextLine();
        System.out.println("Enter patient Id :");
        String patientId = scanner.nextLine();
        System.out.println("Enter doctor Id :");
        String doctorId = scanner.nextLine();
        System.out.println("Enter appointment Date :");
        String appointmentDate = scanner.nextLine();
        LocalDate date = LocalDate.parse(appointmentDate);
        System.out.println("Enter appointment Time :");
        String appointmentTime = scanner.nextLine();
        System.out.println("Enter status :");
        String status = scanner.nextLine();
        System.out.println("Enter reason :");
        String reason = scanner.nextLine();
        System.out.println("Enter notes :");
        String notes = scanner.nextLine();
        Appointment appointment = new Appointment(appointmentId, patientId, doctorId, date, appointmentTime, status, reason, notes);
        return appointment;
    }
    public static List<Appointment> addAppointments(){
        Boolean continueFlag = true;
        while (continueFlag) {

            appointmentList.add(addAppointment());
            System.out.println("Appointment add successfully");

            System.out.println("Enter c to add more , and q to exit");
            if (scanner.nextLine().equalsIgnoreCase("q")) {
                continueFlag = false;
            }
        }
        return appointmentList;

    }
    // edit appointment by ID

    public static void editAppointment(String appointmentId){

        for(Appointment appointment : appointmentList){
            if(appointment.getAppointmentId().equals(appointmentId)){

                System.out.println("Enter updated patient Id :");
                appointment.setPatientId(scanner.nextLine());

                System.out.println("Enter updated doctor Id :");
                appointment.setDoctorId(scanner.nextLine());

                System.out.println("Enter updated appointment Date :");
                String appointmentDate = scanner.nextLine();
                LocalDate date = LocalDate.parse(appointmentDate);
                appointment.setAppointmentDate(date);

                System.out.println("Enter updated appointment Time :");
                appointment.setAppointmentTime(scanner.nextLine());

                System.out.println("Enter updated status :");
                appointment.setStatus(scanner.nextLine());

                System.out.println("Enter updated reason :");
                appointment.setReason(scanner.nextLine());

                System.out.println("Enter updated notes :");
                appointment.setNotes(scanner.nextLine());

                System.out.println("Appointment updated successfully");


            }

        }

    }
    // Remove appointment by ID
    public static void removeAppointment(String appointmentId){
        boolean removed = appointmentList.removeIf(
                b -> b.getAppointmentId()
                        .equals(appointmentId)
        );

        if (removed){

            System.out.println(
                    "Appointment removed successfully");

        } else {

            System.out.println("No Appointment found");
        }
    }
    //retrieve appointment
    public static Appointment getAppointment(String appointmentId){

        for(Appointment appointment: appointmentList){
            if(appointment.getAppointmentId().equals(appointmentId)){
                return appointment;
            }

        }
        System.out.println("appointment Record not found");
        return null;
    }

    //get Appointments By Patient

    public static List<Appointment> getAppointmentsByPatient(String patientId){
        List<Appointment> patientAppointments = new ArrayList<>();

        for(Appointment appointment : appointmentList){

            if(appointment.getPatientId().equals(patientId)){
                patientAppointments.add(appointment);

            }
        }
        return patientAppointments;
    }
    // get Appointments By Doctor

    public static List<Appointment> getAppointmentsByDoctor(String doctorId) {

        List<Appointment> doctorAppointments = new ArrayList<>();

        for(Appointment appointment : appointmentList){
            if(appointment.getDoctorId().equals(doctorId)){

                doctorAppointments.add(appointment);
            }
        }
        return doctorAppointments;
    }
    // get Appointments By Date

    public static List<Appointment> getAppointmentsByDate(LocalDate date){

        List<Appointment> dateAppointments = new ArrayList<>();

        for(Appointment appointment : appointmentList){
            if(appointment.getAppointmentDate().equals(date)){
                dateAppointments.add(appointment);
            }

        }
        return dateAppointments;
    }
    // reschedule Appointment
    public static void rescheduleAppointment(String appointmentId, LocalDate newDate, String newTime){

        for(Appointment appointment : appointmentList){
            if(appointment.getAppointmentId().equals(appointmentId)){
                appointment.setAppointmentDate(newDate);
                appointment.setAppointmentTime(newTime);
                System.out.println("Appointment rescheduled successfully");
            }

        }

    }
    // Overloaded rescheduleAppointment(String appointmentId, LocalDate newDate)

    public void rescheduleAppointment(String appointmentId, LocalDate newDate){

        Appointment appointment = getAppointment(appointmentId);

        if (appointment != null) {

            appointment.setAppointmentDate(newDate);
            appointment.setStatus("Rescheduled");

            System.out.println("Appointment rescheduled successfully.");

        } else {

            System.out.println("Appointment not found.");
        }
    }

    // Overloaded rescheduleAppointment(Appointment appointment, LocalDate newDate, String newTime, String reason)
    public void rescheduleAppointment(Appointment appointment, LocalDate newDate, String newTime, String reason){
        appointment.setAppointmentDate(newDate);
        appointment.setAppointmentTime(newTime);
        appointment.setReason(reason);
        appointment.setStatus("Rescheduled");

        System.out.println("Appointment rescheduled successfully.");

    }
    // cancel Appointment
    @Override
    public  void cancelAppointment(String appointmentId){

        for(Appointment appointment : appointmentList){

            if(appointment.getAppointmentId().equals(appointmentId)){

                appointment.setStatus("Cancelled");

                System.out.println("Appointment cancelled successfully"
                );

                return;
            }
        }

        System.out.println("Appointment not found");
    }
    // Overloaded createAppointment(String patientId, String doctorId, LocalDate date)

    public void createAppointment(String patientId, String doctorId, LocalDate date){

        Appointment appointment = new Appointment();

        appointment.setPatientId(patientId);

        appointment.setDoctorId(doctorId);

        appointment.setAppointmentDate(date);

        appointment.setStatus("Scheduled");

        appointmentList.add(appointment);

        System.out.println("Appointment add successfully");


    }

    //Overloaded createAppointment(String patientId, String doctorId, LocalDate date, String time)
    public void createAppointment(String patientId, String doctorId, LocalDate date ,String time){

        Appointment appointment = new Appointment();

        appointment.setPatientId(patientId);

        appointment.setDoctorId(doctorId);

        appointment.setAppointmentDate(date);

        appointment.setAppointmentTime(time);

        appointmentList.add(appointment);

        System.out.println("Appointment add successfully");


    }
    // Overloaded createAppointment(Appointment appointment)
    public void createAppointment(Appointment appointment){

        appointmentList.add(appointment);

        System.out.println("Appointment add successfully");


    }

    // Overloaded displayAppointments(LocalDate date)
    public void displayAppointments(LocalDate date){

        for(Appointment appointment: appointmentList){

            if(appointment.getAppointmentDate().equals(date)){

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

        appointmentList.add(
                (Appointment) entity);

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

        for (Appointment appointment : appointments){

            appointment.displayInfo();
        }
    }
    @Override
    public void searchById(String id) {

        Appointment appointment = getAppointment(id);

        if (appointment != null){

            appointment.displayInfo();
        }
    }
    @Override
    public void scheduleAppointment(Appointment appointment) {

        appointmentList.add(appointment);

        System.out.println("Appointment scheduled successfully");
    }


    public static boolean handleAppointmentdMenu(Integer AppointmantOption) {
        switch (AppointmantOption) {
            case 1 -> {
                addAppointments();
            }
            case 2 -> {
                System.out.println(
                        "Enter appointmentId to update");

                String appointmentId =
                        scanner.nextLine();

                editAppointment(appointmentId);
            }
            case 3 -> {
                System.out.println("Enter appointmentId to remove");
                String appointmentId = scanner.nextLine();
                removeAppointment(appointmentId);
            }
            case 4 -> {

            System.out.println("Enter appointmentId to getAppointment");

            String appointmentId = scanner.nextLine();

            Appointment appointment = getAppointment(appointmentId);

            if (appointment != null){
                appointment.displayInfo();
            }
        }

        case 5 -> {

            System.out.println("Enter patient Id to get Appointments");

            String patientId = scanner.nextLine();

            List<Appointment> appointments = getAppointmentsByPatient(patientId);

            for (Appointment appointment : appointments){

                appointment.displayInfo();
            }
        }


            case 6 -> {
                System.out.println("Enter Doctor Id to get Appointment");

                String doctorId = scanner.nextLine();

                List<Appointment> appointments = getAppointmentsByDoctor(doctorId);

                for (Appointment appointment : appointments){
                    appointment.displayInfo();
                }

            }
            case 7 -> {
                System.out.println("Enter date to get appointment");

                String date = scanner.nextLine();

                List<Appointment> appointments = getAppointmentsByDate(LocalDate.parse(date));

                for (Appointment appointment : appointments){
                    appointment.displayInfo();
                }
            }
            case 8 -> {
                System.out.println("Enter  appointmentId to reschedule  appointment");
                String  appointmentId = scanner.nextLine();
                System.out.println("Enter  newDate to reschedule  appointment");
                LocalDate newDate= LocalDate.parse(scanner.nextLine());
                System.out.println("Enter  newTime to reschedule  appointment");
                String newTime =scanner.nextLine();
                rescheduleAppointment(appointmentId,newDate,newTime);

            }
            case 9 -> {
                System.out.println("Enter appointmentId to cancel appointment");
                String appointmentId = scanner.nextLine();
                new AppointmentService().cancelAppointment(appointmentId);


            }


        }
        return false;
    }

}




