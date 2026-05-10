package Entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Doctor extends Person{
    private String doctorId;
    private String specialization;
    private String qualification;
   private int experienceYears;
   private String departmentId;
   private Double consultationFee;
   private List<String> availableSlots =new ArrayList<>();
   private List<String> assignedPatients = new ArrayList<>();

    public Doctor(String id, String firstName, String lastName, LocalDate dateOfBirth, String gender, String phoneNumber, String email, String address, String doctorId, String specialization, String qualification, int experienceYears, String departmentId, Double consultationFee, List<String> availableSlots, List<String> assignedPatients) {
        super(id, firstName, lastName, dateOfBirth, gender, phoneNumber, email, address);
        this.doctorId = doctorId;
        this.specialization = specialization;
        this.qualification = qualification;
        this.experienceYears = experienceYears;
        this.departmentId = departmentId;
        this.consultationFee = consultationFee;
        this.availableSlots = availableSlots;
        this.assignedPatients = assignedPatients;
    }

}
