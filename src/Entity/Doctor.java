package Entity;

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
   private List<String> assignedPatients;


}
