package Entity;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private String departmentId;
    private String departmentName;
    private String headDoctorId;
    private List<String> doctors = new ArrayList<>();
    private List<String> nurses = new ArrayList<>();
    private int bedCapacity;
    private int availableBeds;


}
