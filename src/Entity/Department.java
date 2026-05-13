package Entity;

import Interfaces.Displayable;

import java.util.ArrayList;
import java.util.List;
import utility.HelperUtils;

public class Department implements Displayable {
    private String departmentId;
    private String departmentName;
    private String headDoctorId;
    private List<Doctor> doctors = new ArrayList<>();
    private List<Nurse> nurses = new ArrayList<>();
    private int bedCapacity;
    private int availableBeds;


    public Department(String departmentId, String departmentName, String headDoctorId, List<Doctor> doctors, List<Nurse> nurses, int bedCapacity, int availableBeds) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.headDoctorId = headDoctorId;
        this.doctors = doctors;
        this.nurses = nurses;
        this.bedCapacity = bedCapacity;
        this.availableBeds = availableBeds;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        if(!HelperUtils.isValidString(departmentId)){
            System.out.println("Invalid department ID.");
            return;
        }
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {

        if(!HelperUtils.isValidString(departmentName)){
            System.out.println("Invalid department name.");
            return;
        }this.departmentName = departmentName;
    }

    public String getHeadDoctorId() {
        return headDoctorId;
    }

    public void setHeadDoctorId(String headDoctorId) {

        if(!HelperUtils.isValidString(headDoctorId)){
            System.out.println(
                    "Invalid doctor ID.");
            return;
        }
        this.headDoctorId = headDoctorId;
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<Doctor> doctors) {

        if(HelperUtils.isNull(doctors)){
            System.out.println("Doctors list cannot be null.");
            return;
        }this.doctors = doctors;
    }

    public List<Nurse> getNurses() {
        return nurses;
    }

    public void setNurses(List<Nurse> nurses) {

        if(HelperUtils.isNull(nurses)){
            System.out.println("Nurses list cannot be null.");
            return;
        }this.nurses = nurses;
    }

    public int getBedCapacity() {
        return bedCapacity;
    }

    public void setBedCapacity(int bedCapacity) {

        if(!HelperUtils.isPositive(bedCapacity)){
            System.out.println("Invalid bed capacity.");
            return;
        }this.bedCapacity = bedCapacity;
    }

    public int getAvailableBeds() {
        return availableBeds;
    }

    public void setAvailableBeds(int availableBeds) {
        if(!HelperUtils.isValidNumber(
                availableBeds,0,bedCapacity)){

            System.out.println(
                    "Invalid available beds.");

            return;
        }
        this.availableBeds = availableBeds;
    }
    public void displayInfo() {

        System.out.println("Department ID: " + departmentId);
        System.out.println("Department Name: " + departmentName);
        System.out.println("Head Doctor ID: " + headDoctorId);
        System.out.println("Doctors: " + doctors);
        System.out.println("Nurses: " + nurses);
        System.out.println("Bed Capacity: " + bedCapacity);
        System.out.println("Available Beds: " + availableBeds);
    }
    public void assignDoctor(Doctor doctor) {

        if(HelperUtils.isNull(doctor)){
            System.out.println("Doctor cannot be null.");
            return;
        }doctors.add(doctor);
    }
    public void assignNurse(Nurse nurse) {
        nurses.add(nurse);
    }
    public void updateBedAvailability(int beds) {
        this.availableBeds = beds;
    }
    @Override
    public void displaySummary(){
        System.out.println("Department : " + departmentName);
    }


}
