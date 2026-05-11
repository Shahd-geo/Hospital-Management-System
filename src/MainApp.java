import Service.PatientService;

import java.awt.*;
import java.util.Scanner;

import static Service.PatientService.handlePatientMenu;

public class MainApp {
    static Menu menu = new Menu();
    static Scanner input = new Scanner(System.in);


    static void main(String[] args) {
        Object handlePatientMenu;
        handlePatientMenu();

        PatientService PatientService = new PatientService();

    }
}
