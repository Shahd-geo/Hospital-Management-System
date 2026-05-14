package Service;

import Entity.*;
import Interfaces.Manageable;
import Interfaces.Searchable;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import utility.HelperUtils;
import utility.InputHandler;

public class DepartmentService  implements Manageable, Searchable {
    static List<Department> departmentList = new ArrayList<>();
    static List<Doctor> doctors = new ArrayList<>();
    static List<Nurse> nurses = new ArrayList<>();


    public static Department addDepartment() {
        String departmentId = HelperUtils.generateId("DEP");
        String departmentName = InputHandler.getStringInput("Enter department Name:");
        String headDoctorId = InputHandler.getStringInput("Enter department head DoctorId:");
        int bedCapacity = InputHandler.getIntInput("Enter department bed Capacity:");
        int availableBeds = InputHandler.getIntInput("Enter department available Beds:");
        Department department = new Department(departmentId, departmentName, headDoctorId, doctors, nurses, bedCapacity, availableBeds);

        return department;

    }

    public static List<Department> addDepartments() {

        boolean continueFlag = true;

        while (continueFlag) {

            departmentList.add(addDepartment());
            System.out.println("Department added successfully");

            String choice = InputHandler.getStringInput(
                    "Enter 'c' to continue adding or 'q' to quit:");

            if (choice.equalsIgnoreCase("q")) {
                continueFlag = false;
            }
        }

        return departmentList;
    }
    // UPDATE department

    public static void editDepartment(String departmentId) {

        for (Department department : departmentList) {
            if (department.getDepartmentId().equals(departmentId)) {
                String newName = InputHandler.getStringInput("Enter updated department Name:");
                department.setDepartmentName(newName);
                String newHeadDoctorId = InputHandler.getStringInput("Enter updated department head DoctorId:");
                department.setHeadDoctorId(newHeadDoctorId);
                int newBedCapacity = InputHandler.getIntInput("Enter updated department bed Capacity:");
                department.setBedCapacity(newBedCapacity);
                int newAvailableBeds = InputHandler.getIntInput("Enter updated department available Beds:");
                department.setAvailableBeds(newAvailableBeds);

                System.out.println("department updated successfully");

            }

        }

    }

    // remove department by ID
    public static void removeDepartment(String departmentId) {
        boolean removed = departmentList.removeIf(
                b -> b.getDepartmentId()
                        .equals(departmentId)
        );

        if (removed) {

            System.out.println(
                    "Department removed successfully");

        } else {

            System.out.println("No Department found");
        }
    }

    //retrieve department
    public static Department getDepartmentById(String departmentId) {

        for (Department department : departmentList) {

            if (department.getDepartmentId().equals(departmentId)) {
                return department;
            }

        }
        System.out.println("department not found");
        return null;
    }

    // display All Departments
    public static void displayAllDepartments() {

        for (Department department : departmentList) {
            department.displayInfo();
        }
    }
    // assign Doctor To Department(String doctorId, String departmentId)

    public static void assignDoctorToDepartment(String doctorId, String departmentId) {

        if (HelperUtils.isNull(doctorId) || HelperUtils.isNull(departmentId)) {
            System.out.println("Invalid data.");
            return;
        }

        Doctor doctor = DoctorService.getDoctorById(doctorId);

        if (HelperUtils.isNull(doctor)) {
            System.out.println("Doctor not found.");
            return;
        }

        for (Department department : departmentList) {

            if (department.getDepartmentId().equalsIgnoreCase(departmentId)) {

                department.getDoctors().add(doctor);
                System.out.println("Doctor assigned successfully.");
                return;
            }
        }

        System.out.println("Department not found.");
    }

    @Override
    public void add(Object entity) {
        if (HelperUtils.isNull(entity)) {
            System.out.println(
                    "Department cannot be null.");
            return;
        }

        departmentList.add((Department) entity);

        System.out.println(
                "Department added successfully");
    }

    @Override
    public void remove(String id) {

        removeDepartment(id);
    }

    @Override
    public List<Department> getAll() {

        return departmentList;
    }

    @Override
    public void search(String keyword) {

        Department department = getDepartmentById(keyword);

        if (HelperUtils.isNotNull(department)) {

            department.displayInfo();
        }
    }

    @Override
    public void searchById(String id) {

        Department department =
                getDepartmentById(id);

        if (HelperUtils.isNotNull(department)) {

            department.displayInfo();
        }
    }

    public static void assignNurseToDepartment(String nurseId, String departmentId) {

        if (HelperUtils.isNull(nurseId) || HelperUtils.isNull(departmentId)) {
            System.out.println("Invalid data.");
            return;
        }

        Nurse nurse = NurseService.getNurseById(nurseId);

        if (HelperUtils.isNull(nurse)) {
            System.out.println("Nurse not found.");
            return;
        }

        for (Department department : departmentList) {

            if (department.getDepartmentId().equalsIgnoreCase(departmentId)) {

                department.getNurses().add(nurse);
                System.out.println("Nurse assigned successfully.");
                return;
            }
        }

        System.out.println("Department not found.");
    }

    public static void viewDepartmentStatistics(String departmentId) {

        Department department = getDepartmentById(departmentId);

        if (HelperUtils.isNull(department)) {
            System.out.println("Department not found.");
            return;
        }

        System.out.println("===== Department Statistics =====");
        System.out.println("Name: " + department.getDepartmentName());
        System.out.println("Doctors: " + department.getDoctors().size());
        System.out.println("Nurses: " + department.getNurses().size());
        System.out.println("Bed Capacity: " + department.getBedCapacity());
        System.out.println("Available Beds: " + department.getAvailableBeds());

        int occupied = department.getBedCapacity() - department.getAvailableBeds();
        System.out.println("Occupied Beds: " + occupied);
    }

    public static boolean handleDepartmentMenu(Integer departmentOption) {

        switch (departmentOption) {
            case 1 -> {
                addDepartments();
            }

            case 2 -> {
                displayAllDepartments();
            }


            case 3 -> {
                String departmentId = InputHandler.getStringInput("Enter Department ID:");
                Department department = getDepartmentById(departmentId);

                if (HelperUtils.isNotNull(department)) {
                    department.displayInfo();
                }
            }


            case 4 -> {
                String doctorId = InputHandler.getStringInput("Enter Doctor ID:");
                String departmentId = InputHandler.getStringInput("Enter Department ID:");

                assignDoctorToDepartment(doctorId, departmentId);
            }


            case 5 -> {
                String nurseId = InputHandler.getStringInput("Enter Nurse ID:");
                String departmentId = InputHandler.getStringInput("Enter Department ID:");

                assignNurseToDepartment(nurseId, departmentId);
            }


            case 6 -> {
                String departmentId = InputHandler.getStringInput("Enter Department ID:");
                editDepartment(departmentId);
            }

            case 7 -> {
                String departmentId = InputHandler.getStringInput("Enter Department ID:");
                viewDepartmentStatistics(departmentId);
            }

            default -> {
                System.out.println("Invalid option.");
            }
        }

        return false;
    }
}


