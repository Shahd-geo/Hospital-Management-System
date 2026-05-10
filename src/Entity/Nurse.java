package Entity;

import java.util.ArrayList;
import java.util.List;

public class Nurse extends Person{
    private String nurseId;
    private String departmentId;
    private String shift;
    private String qualification;
    private List<String> assignedPatients = new ArrayList<>();

}
