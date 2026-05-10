package Service;

import Entity.Doctor;
import Entity.Patient;

import java.util.ArrayList;
import java.util.List;

public class DoctorService {
    private static List<Doctor> doctors = new ArrayList<>();

    public void addDoctor(Doctor d) {
        doctors.add(d);
        System.out.println("----------------");
    }

    public void displayAllDoctors() {
        for (Doctor d : doctors) {
            d.displayInfo();
            System.out.println("----------------");
        }
    }

    public Doctor getDoctorById(String doctorId) {
        for (Doctor d : doctors) {
            if (d.getDoctorId().equals(doctorId)) {
                return d;
            }
        }
        return null;
    }

    public void removeDoctor(String doctorId) {
        Doctor d = getDoctorById(doctorId);
        if (d != null) {
            doctors.remove(d);
        }
    }

    public void editDoctor(String doctorId, Doctor updatedDoctor) {
        Doctor d = getDoctorById(doctorId);
        if (d != null) {
            doctors.remove(d);
            doctors.add(updatedDoctor);
            System.out.println("----------------");
        }
    }

    public void getDoctorsBySpecialization(String specialization) {
        for (Doctor d : doctors) {
            if (d.getSpecialization()
                    .equalsIgnoreCase(specialization)) {
                d.displayInfo();
                System.out.println("----------------");
            }
        }
    }

    public void getAvailableDoctors() {
        for (Doctor d : doctors) {
            if (!d.getAvailableSlots().isEmpty()) {
                d.displayInfo();
                System.out.println("----------------");
            }
        }
    }
}
