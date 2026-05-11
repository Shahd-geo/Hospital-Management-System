import Entity.Doctor;
import Service.DoctorService;
import Service.NurseService;
import Service.PatientService;

import java.awt.*;
import java.util.Scanner;

import static Service.PatientService.scanner;


public class MainApp {
    static Menu menu = new Menu();
    static Scanner input = new Scanner(System.in);


    static void main(String[] args) {
        boolean running = true;

        while (running) {

            System.out.println(
                    MenuMessages.MAIN_MENU_MESSAGE
            );
            int mainOption =
                    scanner.nextInt();

            scanner.nextLine();


            switch (mainOption) {
                case 1 -> {

                    boolean patientMenu = true;

                    while (patientMenu) {

                        System.out.println(
                                MenuMessages.PATIENT_MENU_MESSAGE
                        );

                        int patientOption =
                                scanner.nextInt();

                        scanner.nextLine();


                        if (patientOption == 7) {

                            patientMenu = false;

                        } else {

                            PatientService
                                    .handlePatientMenu(
                                            patientOption
                                    );
                        }
                    }
                }
                case 2 -> {

                    boolean doctorMenu = true;

                    while (doctorMenu){

                        System.out.println(
                                MenuMessages.DOCTOR_MENU_MESSAGE
                        );

                        int doctorOption =
                                scanner.nextInt();

                        scanner.nextLine();


                        if (doctorOption == 8){

                            doctorMenu = false;

                        } else {

                            DoctorService
                                    .handleDectorMenu(
                                            doctorOption
                                    );
                        }
                    }
                }
                case 3 -> {

                    boolean nurseMenu = true;

                    while (nurseMenu){

                        System.out.println(
                                MenuMessages.NURSE_MENU_MESSAGE
                        );

                        int nurseOption =
                                scanner.nextInt();

                        scanner.nextLine();


                        if (nurseOption == 8){

                            nurseMenu = false;

                        } else {

                            NurseService
                                    .handleNurseMenu(
                                            nurseOption
                                    );
                        }
                    }
                }
                case 7 -> {

                    System.out.println(
                            "Exiting system..."
                    );

                    running = false;
                }


                default -> {

                    System.out.println(
                            "Invalid option"
                    );
                }
            }
        }
    }
}

























