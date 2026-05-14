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


    public static Department addDepartment(){
        String departmentId = HelperUtils.generateId("DEP");
        String departmentName = InputHandler.getStringInput("Enter department Name:");
        String headDoctorId = InputHandler.getStringInput("Enter department head DoctorId:");
        int bedCapacity = InputHandler.getIntInput("Enter department bed Capacity:");
        int availableBeds = InputHandler.getIntInput("Enter department available Beds:");
        Department department = new Department(departmentId,departmentName,headDoctorId,doctors,nurses,bedCapacity,availableBeds);

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

    public static void editDepartment(String departmentId){

        for(Department department : departmentList){
            if(department.getDepartmentId().equals(departmentId)){
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
    public static Department getDepartmentById(String departmentId){

        for(Department department: departmentList){

            if(department.getDepartmentId().equals(departmentId)){
                return department;
            }

        }
        System.out.println("department not found");
        return null;
    }
    // display All Departments
    public static void displayAllDepartments(){

        for(Department department : departmentList){
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
    public static boolean handleDepartmentMenu(Integer departmentOption) {


        switch (departmentOption) {
            case 1 -> {
                addDepartments();
            }
            case 2 -> {
                System.out.println(
                        "Enter Department ID to update");

                String departmentId =
                        scanner.nextLine();

                editDepartment(departmentId);
            }

            case 3 -> {
                System.out.println("Enter department Id to remove");
                String departmentId = scanner.nextLine();
                removeDepartment(departmentId);
            }

            case 4 -> {
                System.out.println("Enter department Id to get department");
                String departmentId = scanner.nextLine();

                Department department = getDepartmentById(departmentId);

                if(HelperUtils.isNotNull(department)){
                    department.displayInfo();
                }


            }
            case 5 -> {
                displayAllDepartments();
            }

            case 6 -> {
                System.out.println("Enter Doctor Id  to assign doctor to department ");
                String doctorId = scanner.nextLine();
                System.out.println("Enter department Id  to assign doctor to department ");
                String departmentId = scanner.nextLine();
                assignDoctorToDepartment(doctorId, departmentId);
            }

        }
        return false;
    }
    @Override
    public void add(Object entity) {
        if(HelperUtils.isNull(entity)){
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

        if(HelperUtils.isNotNull(department)){

            department.displayInfo();
        }
    }
    @Override
    public void searchById(String id) {

        Department department =
                getDepartmentById(id);

        if(HelperUtils.isNotNull(department)){

            department.displayInfo();
        }
    }

}


