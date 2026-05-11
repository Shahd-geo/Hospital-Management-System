package Service;

import Entity.Appointment;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AppointmentService {
    static List<Appointment> appointmentList = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    //add new appointment
    public Appointment addAppointment() {

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
    public List<Appointment> addAppointments(){
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

    public void editAppointment(String appointmentId){

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
    public void removeAppointment(String appointmentId ){
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
    public Appointment getAppointment(String appointmentId){

        for(Appointment appointment: appointmentList){
            if(appointment.getAppointmentId().equals(appointmentId)){
                return appointment;
            }

        }
        System.out.println("appointment Record not found");
        return null;
    }

    //get Appointments By Patient

    public List<Appointment> getAppointmentsByPatient(String patientId){
        List<Appointment> patientAppointments = new ArrayList<>();

        for(Appointment appointment : appointmentList){

            if(appointment.getPatientId().equals(patientId)){
                patientAppointments.add(appointment);

            }
        }
        return patientAppointments;
    }
    // get Appointments By Doctor

    public List<Appointment> getAppointmentsByDoctor(String doctorId) {

        List<Appointment> doctorAppointments = new ArrayList<>();

        for(Appointment appointment : appointmentList){
            if(appointment.getDoctorId().equals(doctorId)){

                doctorAppointments.add(appointment);
            }
        }
        return doctorAppointments;
    }
    // get Appointments By Date

    public List<Appointment> getAppointmentsByDate(LocalDate date){

        List<Appointment> dateAppointments = new ArrayList<>();

        for(Appointment appointment : appointmentList){
            if(appointment.getAppointmentDate().equals(date)){
                dateAppointments.add(appointment);
            }

        }
        return dateAppointments;
    }
    // reschedule Appointment
    public void rescheduleAppointment(String appointmentId, LocalDate newDate, String newTime){

        for(Appointment appointment : appointmentList){
            if(appointment.getAppointmentId().equals(appointmentId)){
                appointment.setAppointmentDate(newDate);
                appointment.setAppointmentTime(newTime);
            }
            System.out.println("Appointment rescheduled successfully");
        }

    }
    // cancel Appointment

    public void cancelAppointment(String appointmentId){

        for(Appointment appointment : appointmentList){

            if(appointment.getAppointmentId().equals(appointmentId)){
                appointment.setStatus("Cancelled");
            }
        }

    }





}
