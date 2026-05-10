package Service;

import Entity.Doctor;
import Entity.Nurse;

import java.util.ArrayList;
import java.util.List;

public class NurseService {
    private static List<Nurse> nurses = new ArrayList<>();
    public void addNurse(Nurse n) {
        nurses.add(n);
        System.out.println("----------------");
    }

    public void displayAllNurse() {
        for (Nurse n : nurses) {
            n.displayInfo();
            System.out.println("----------------");
        }
    }

    public Nurse getNurseById(String nurseId) {
        for (Nurse n : nurses) {
            if (n.getNurseId().equals(nurseId)) {
                return n;
            }
        }
        return null;
    }

    public void removeNurse(String nurseId) {
        Nurse n = getNurseById(nurseId);
        if (n != null) {
            nurses.remove(n);
        }
    }

    public void editNurse(String nurseId, Nurse updateNurse) {
        Nurse n = getNurseById(nurseId);
        if (n != null) {
            nurses.remove(n);
            nurses.add(updateNurse);
            System.out.println("----------------");
        }
    }
    public void getNursesByDepartment(String departmentId){

        for (Nurse n : nurses){

            if (n.getDepartmentId()
                    .equalsIgnoreCase(departmentId)){

                n.displayInfo();

                System.out.println("----------------");
            }
        }
    }
    public void getNursesByShift(String shift){

        for (Nurse n : nurses){

            if (n.getShift()
                    .equalsIgnoreCase(shift)){

                n.displayInfo();

                System.out.println("----------------");
            }
        }
    }






}
