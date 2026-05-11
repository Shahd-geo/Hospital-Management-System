import Entity.Doctor;
import Service.DoctorService;

import java.awt.*;
import java.util.Scanner;


public class MainApp {
    static Menu menu = new Menu();
    static Scanner input = new Scanner(System.in);


    static void main(String[] args) {
        //Object handlePatientMenu;12
       // handlePatientMenu();

        //DoctorService PatientService = new PatientService();
        Scanner scanner = new Scanner(System.in);
        DoctorService DoctorService = new DoctorService();
        DoctorService.addDector();



    }
}

































