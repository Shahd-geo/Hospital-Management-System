package Entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import utility.HelperUtils;

public class Consultant extends Doctor{
   private List<String>consultationTypes=new ArrayList<>();
    private boolean onlineConsultationAvailable;
   private int consultationDuration; // in minutes

    // Constructor Chaining:
// Consultant -> Doctor -> Person

    public Consultant(String id, String firstName, String lastName, LocalDate dateOfBirth, String gender, String phoneNumber, String email, String address, String doctorId, String specialization, String qualification, int experienceYears, String departmentId, Double consultationFee, List<String> availableSlots, List<String> assignedPatients, List<String> consultationTypes, boolean onlineConsultationAvailable, int consultationDuration) {
        super(id, firstName, lastName, dateOfBirth, gender, phoneNumber, email, address, doctorId, specialization, qualification, experienceYears, departmentId, consultationFee, availableSlots, assignedPatients);
        this.consultationTypes = consultationTypes;
        this.onlineConsultationAvailable = onlineConsultationAvailable;
        this.consultationDuration = consultationDuration;
    }

    public List<String> getConsultationTypes() {
        return consultationTypes;
    }

    public void setConsultationTypes(List<String> consultationTypes) {

        if(HelperUtils.isNull(consultationTypes)){
            System.out.println("Consultation types cannot be null.");
            return;
        }this.consultationTypes = consultationTypes;
    }

    public boolean isOnlineConsultationAvailable() {
        return onlineConsultationAvailable;
    }

    public void setOnlineConsultationAvailable(boolean onlineConsultationAvailable) {
        this.onlineConsultationAvailable = onlineConsultationAvailable;
    }

    public int getConsultationDuration() {
        return consultationDuration;
    }

    public void setConsultationDuration(int consultationDuration) {

        if(!HelperUtils.isPositive(consultationDuration)) {
            System.out.println("Invalid consultation duration.");

            return;
        }
            this.consultationDuration = consultationDuration;
    }
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println(" consultation Types : " + consultationTypes);
        System.out.println(" online Consultation Available : " + onlineConsultationAvailable);
        System.out.println(" consultation Duration : " + consultationDuration);


    }
    // scheduleConsultation()

    public void scheduleConsultation(String consultationType, boolean online) {

        if (!consultationTypes.contains(consultationType)) {
            System.out.println("Consultation type not available.");
            return;
        }

        if(online && !onlineConsultationAvailable){
            System.out.println("Online consultation is not available.");
            return;
        }

        System.out.println("Consultation scheduled successfully.");
        System.out.println("Type      : " + consultationType);
        System.out.println("Mode      : " + (online ? "Online" : "Offline"));
        System.out.println("Duration  : " + consultationDuration + " minutes");

    }
    //provideSecondOpinion()
    public void provideSecondOpinion(String patientCase) {
        if(!HelperUtils.isValidString(patientCase)){
            System.out.println("Invalid patient case.");
            return;
        }
        System.out.println("Providing second opinion for case:");
        System.out.println(patientCase);
        System.out.println("Second opinion completed successfully.");
    }


}


