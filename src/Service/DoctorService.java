package Service;

import Entity.Doctor;
import Entity.Patient;

import java.util.ArrayList;
import java.util.List;

public class DoctorService {
    private static List<Doctor> doctors = new ArrayList<>();
    public void aaddDoctor(Doctor d){
        doctors.add(d);
    }
    public void ddisplayAllDoctors(){
        for(Doctor d: doctors){
            d.displayInfo();
        }
    }


}
