package Service;

import Entity.*;
import Interfaces.Manageable;
import Interfaces.Searchable;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class DepartmentService  implements Manageable, Searchable {
    static Scanner scanner = new Scanner(System.in);
    static List<Department> departmentList = new ArrayList<>();
    static List<Doctor> doctors = new ArrayList<>();
    static List<Nurse> nurses = new ArrayList<>();


    public static Department addDepartment(){
        System.out.println("Enter Department Id :");
        String departmentId = scanner.nextLine();
        System.out.println("Enter department Name :");
        String departmentName = scanner.nextLine();
        System.out.println("Enter department head DoctorId :");
        String headDoctorId = scanner.nextLine();
        System.out.println("Enter department  bed Capacity :");
        int bedCapacity = scanner.nextInt();
        System.out.println("Enter department available Beds :");
        int availableBeds = scanner.nextInt();
        scanner.nextLine();
        Department department = new Department(departmentId,departmentName,headDoctorId,doctors,nurses,bedCapacity,availableBeds);

        return department;

    }
    public static List<Department> addDepartments(){

        Boolean continueFlag = true;
        while (continueFlag) {

            departmentList.add(addDepartment());
            System.out.println("Department add successfully");

            System.out.println("Enter c to add more , and q to exit");

            if (scanner.nextLine().equalsIgnoreCase("q")) {
                continueFlag = false;
            }
        }
        return departmentList;

    }
    // UPDATE department

    public static void editDepartment(String departmentId){

        for(Department department : departmentList){
            if(department.getDepartmentId().equals(departmentId)){

                System.out.println("Enter updated department Name :");
                department.setDepartmentName(scanner.nextLine());

                System.out.println("Enter updated department head DoctorId :");
                department.setHeadDoctorId(scanner.nextLine());

                System.out.println("Enter updated department  bed Capacity :");
                department.setBedCapacity(scanner.nextInt());

                System.out.println("Enter updated department available Beds :");
                department.setAvailableBeds(scanner.nextInt());
                scanner.nextLine();


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

        Doctor doctor = DoctorService.getDoctorById(doctorId);

        for (Department department : departmentList) {

            if (department.getDepartmentId().equals(departmentId)) {

                department.getDoctors().add(doctor);
            }
        }
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

                if (department != null){
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

        departmentList.add((Department) entity);

        System.out.println(
                "Department added successfully");
    }
    @Override
    public void remove(String id) {

        removeDepartment(id);
    }
    @Override
    public List<Patient> getAll() {

        return departmentList;
    }
    @Override
    public void search(String keyword) {

        Department department = getDepartmentById(keyword);

        if (department != null){

            department.displayInfo();
        }
    }
    @Override
    public void searchById(String id) {

        Department department =
                getDepartmentById(id);

        if (department != null){

            department.displayInfo();
        }
    }

}


