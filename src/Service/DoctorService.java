package Service;

import Entity.*;
import Interfaces.Manageable;
import Interfaces.Searchable;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import utility.HelperUtils;
import utility.InputHandler;

public class DoctorService implements Manageable, Searchable {
    static Scanner scanner = new Scanner(System.in);
    public static List<Doctor> doctors = new ArrayList<>();


    public static Doctor addDector() {
        String id = HelperUtils.generateId("PER");

        String firstName = InputHandler.getStringInput("Enter doctor first name:");

        String lastName = InputHandler.getStringInput("Enter doctor last name:");
        LocalDate dob;

        do {

            dob = InputHandler.getDateInput("Enter doctor DOB (yyyy-mm-dd):");

            if (!HelperUtils.isValidAge(dob)) {
                System.out.println("Invalid doctor age.");
            }

        } while (!HelperUtils.isValidAge(dob));

        String gender = InputHandler.getStringInput("Enter doctor gender:");

        String phone = InputHandler.getStringInput("Enter doctor phone:");

        String email = InputHandler.getStringInput("Enter doctor email:");

        String address = InputHandler.getStringInput("Enter doctor address:");

        String doctorId = HelperUtils.generateId("DOC");
        ;

        String specialization = InputHandler.getStringInput("Enter specialization:");

        String qualification = InputHandler.getStringInput("Enter qualification:");

        int experienceYears = InputHandler.getIntInput("Enter experience years:", 0, 60);

        String departmentId = InputHandler.getStringInput("Enter department ID:");
        double consultationFee = InputHandler.getDoubleInput("Enter consultation fee:");

        List<String> availableSlots =
                new ArrayList<>();

        boolean slotsLoop = true;

        while (slotsLoop) {

            availableSlots.add(InputHandler.getStringInput("Enter available slot:")
            );

            String choice = InputHandler.getStringInput("Enter c to continue or q to quit:"
            );

            if (choice.equalsIgnoreCase("q")) {
                slotsLoop = false;
            }

        }

        // assigned patients
        List<String> assignedPatients =
                new ArrayList<>();


        Doctor doctor = new Doctor(
                id,
                firstName,
                lastName,
                dob,
                gender,
                phone,
                email,
                address,
                doctorId,
                specialization,
                qualification,
                experienceYears,
                departmentId,
                consultationFee,
                availableSlots,
                assignedPatients
        );

        return doctor;
    }


    // add doctor
    public static void addDoctors() {

        Doctor doctor = addDector();

        doctors.add(doctor);

        System.out.println(
                "Doctor added successfully");
    }


    // Overloaded  addDoctor(String name, String specialization, String phone)

    public void addDoctor(String name, String specialization, String phone) {

        Doctor doctor = new Doctor();
        doctor.setFirstName(name);
        doctor.setSpecialization(specialization);
        doctor.setPhoneNumber(phone);

        doctors.add(doctor);
    }

    // Overloaded addDoctor String name, String specialization, String phone, double consultationFee)
    public void addDoctor(String name, String specialization, String phone, double consultationFee) {
        Doctor doctor = new Doctor();
        doctor.setFirstName(name);
        doctor.setSpecialization(specialization);
        doctor.setPhoneNumber(phone);
        doctor.setConsultationFee(consultationFee);

        doctors.add(doctor);
    }


    public static void editDoctor(String doctorId) {

        for (Doctor doctor : doctors) {

            if (doctor.getDoctorId().equals(doctorId)) {

                doctor.setFirstName(InputHandler.getStringInput("Enter updated doctor first name:"));
                doctor.setLastName(InputHandler.getStringInput("Enter updated Doctor last name :"));

                LocalDate dob;

                do {

                    dob = InputHandler.getDateInput("Enter updated doctor DOB:"
                    );

                    if (!HelperUtils.isValidAge(dob)) {
                        System.out.println("Invalid doctor age.");
                    }

                } while (!HelperUtils.isValidAge(dob));

                doctor.setDateOfBirth(dob);
                doctor.setGender((InputHandler.getStringInput("Enter updated Doctor gender :")));
                doctor.setPhoneNumber(InputHandler.getStringInput("Enter updated Doctor phone number :"));
                doctor.setEmail((InputHandler.getStringInput("Enter updated Doctor email :")));
                doctor.setAddress(InputHandler.getStringInput("Enter updated doctor address:"));
                doctor.setSpecialization(InputHandler.getStringInput("Enter updated Doctor specialization :"));
                doctor.setQualification(InputHandler.getStringInput("Enter updated Doctor qualification :"));
                doctor.setExperienceYears((InputHandler.getIntInput("Enter updated Doctor experienceYears :")));
                doctor.setDepartmentId(InputHandler.getStringInput(("Enter updated Doctor departmentId :")));
                doctor.setConsultationFee(InputHandler.getDoubleInput(("Enter updated Doctor consultationFee :")));
                System.out.println("doctor updated successfully");

            }
        }

    }

    // remove doctor by ID
    public static void removeDoctor(String doctorId) {

        boolean removed = doctors.removeIf(
                b -> b.getDoctorId()
                        .equals(doctorId)
        );

        if (removed) {

            System.out.println(
                    "Doctor removed successfully");

        } else {

            System.out.println(
                    "Doctor not found");
        }
    }

    //retrieve doctor
    public static Doctor getDoctorById(String doctorId) {

        for (Doctor doctor : doctors) {
            if (doctor.getDoctorId().equals(doctorId)) {
                return doctor;
            }

        }
        System.out.println("doctor not found");
        return null;
    }

    // Overloaded assignPatient(String doctorId , String patientId)
    public void assignPatient(String doctorId, String patientId) {
        for (Doctor doctor : doctors) {
            if (doctor.getDoctorId().equals(doctorId)) {
                doctor.getAssignedPatients().add(patientId);

                System.out.println("Patient : " + patientId + " assigned to Dr. " + doctorId);
            }
        }
    }

    // Overloaded assignPatient(Doctor doctor, Patient patient)
    public void assignPatient(Doctor doctor, Patient patient) {
        if (HelperUtils.isNull(doctor)
                || HelperUtils.isNull(patient)) {

            System.out.println("Invalid data.");
            return;
        }

        doctor.getAssignedPatients().add(patient.getPatientId());

        System.out.println("Patient : " + patient.getPatientId() + " assigned to Dr. " + doctor.getDoctorId());
    }

    // Overloaded assignPatient(String doctorId, List<String> patientIds) - bulk assignment
    public void assignPatient(String doctorId, List<String> patientIds) {
        if (HelperUtils.isNull(doctorId)
                || HelperUtils.isNull(patientIds)
                || patientIds.isEmpty()) {

            System.out.println("Invalid patient list.");
            return;
        }

        Doctor doctor = getDoctorById(doctorId);

        if (HelperUtils.isNotNull(doctor)) {
            for (String patientId : patientIds) {
                doctor.getAssignedPatients().add(patientId);
            }

            System.out.println("Patients assigned successfully");
        }
    }


    //display all doctors with formatted output
    public static void displayAllDoctors() {

        for (Doctor doctor : doctors) {
            doctor.displayInfo();
        }

    }

    // Overloaded displayDoctors()
    public void displayDoctors() {

        for (Doctor doctor : doctors) {

            doctor.displayInfo();
        }
    }

    // Overloaded displayDoctors(
    public void displayDoctors(String specialization) {
        if (HelperUtils.isNull(specialization)) {
            System.out.println("Invalid specialization.");
            return;
        }

        for (Doctor doctor : doctors) {

            if (doctor.getSpecialization().equalsIgnoreCase(specialization)) {
                doctor.displayInfo();
            }
        }
    }

    public void displayDoctors(String departmentId, boolean showAvailableOnly) {
        for (Doctor doctor : doctors) {
            boolean matchesDepartment = doctor.getDepartmentId().equalsIgnoreCase(departmentId);

            boolean available = !doctor.getAvailableSlots().isEmpty();

            if (matchesDepartment) {

                if (showAvailableOnly) {

                    if (available) {

                        doctor.displayInfo();
                    }

                } else {

                    doctor.displayInfo();
                }
            }
        }
    }

    //get Doctors By Specialization
    public static List<Doctor> getDoctorsBySpecialization(String specialization) {

        List<Doctor> specializationDoctors = new ArrayList<>();

        for (Doctor doctor : doctors) {

            if (doctor.getSpecialization().equals(specialization)) {
                specializationDoctors.add(doctor);
            }
        }
        return specializationDoctors;
    }

    //get Available Doctors()
    public static List<Doctor> getAvailableDoctors() {

        List<Doctor> availableDoctors = new ArrayList<>();

        for (Doctor doctor : doctors) {

            if (!doctor.getAvailableSlots().isEmpty()) {
                availableDoctors.add(doctor);
            }

        }

        return availableDoctors;
    }

    @Override
    public void add(Object entity) {
        if (HelperUtils.isNull(entity)) {
            System.out.println("Doctor cannot be null.");
            return;
        }
        doctors.add((Doctor) entity);

        System.out.println("Doctor added successfully");

    }

    @Override
    public void remove(String id) {
        removeDoctor(id);

    }

    @Override
    public List<Doctor> getAll() {

        return doctors;
    }

    @Override
    public void search(String keyword) {
        displayDoctors(keyword);

    }

    @Override
    public void searchById(String id) {
        Doctor doctor = getDoctorById(id);
        if (HelperUtils.isNotNull(doctor)) {
            doctor.displayInfo();
        }
    }

    public static Consultant addConsultant() {

        Doctor baseDoctor = addDector();

        List<String> consultationTypes = new ArrayList<>();

        boolean loop = true;

        while (loop) {

            consultationTypes.add(InputHandler.getStringInput("Enter consultation type:"));

            String choice = InputHandler.getStringInput("Enter c to continue or q to quit:"
            );

            if (choice.equalsIgnoreCase("q")) {

                loop = false;
            }
        }

        boolean onlineConsultationAvailable = InputHandler.getConfirmation("Is online consultation available?"
        );

        int consultationDuration = InputHandler.getIntInput("Enter consultation duration in minutes:", 1, 300
        );

        Consultant consultant = new Consultant(

                baseDoctor.getId(),
                baseDoctor.getFirstName(),
                baseDoctor.getLastName(),
                baseDoctor.getDateOfBirth(),
                baseDoctor.getGender(),
                baseDoctor.getPhoneNumber(),
                baseDoctor.getEmail(),
                baseDoctor.getAddress(),
                baseDoctor.getDoctorId(),
                baseDoctor.getSpecialization(),
                baseDoctor.getQualification(),
                baseDoctor.getExperienceYears(),
                baseDoctor.getDepartmentId(),
                baseDoctor.getConsultationFee(),
                baseDoctor.getAvailableSlots(),
                baseDoctor.getAssignedPatients(),

                consultationTypes,
                onlineConsultationAvailable,
                consultationDuration
        );

        doctors.add(consultant);

        System.out.println("Consultant added successfully.");

        return consultant;
    }

    public static GeneralPractitioner addGeneralPractitioner() {

        Doctor baseDoctor = addDector();

        boolean walkinAvailable = InputHandler.getConfirmation("Is walk-in available?");

        boolean homeVisitAvailable = InputHandler.getConfirmation("Is home visit available?"
        );

        boolean vaccinationCertified = InputHandler.getConfirmation("Is vaccination certified?");

        GeneralPractitioner generalPractitioner =
                new GeneralPractitioner(

                        baseDoctor.getId(),
                        baseDoctor.getFirstName(),
                        baseDoctor.getLastName(),
                        baseDoctor.getDateOfBirth(),
                        baseDoctor.getGender(),
                        baseDoctor.getPhoneNumber(),
                        baseDoctor.getEmail(),
                        baseDoctor.getAddress(),
                        baseDoctor.getDoctorId(),
                        baseDoctor.getSpecialization(),
                        baseDoctor.getQualification(),
                        baseDoctor.getExperienceYears(),
                        baseDoctor.getDepartmentId(),
                        baseDoctor.getConsultationFee(),
                        baseDoctor.getAvailableSlots(),
                        baseDoctor.getAssignedPatients(),

                        walkinAvailable,
                        homeVisitAvailable,
                        vaccinationCertified
                );

        doctors.add(generalPractitioner);

        System.out.println("General Practitioner added successfully.");

        return generalPractitioner;
    }



    public static Surgeon addSurgeon() {

        Doctor baseDoctor = addDector();

        String surgeryType = InputHandler.getStringInput("Enter surgery type:");
        int surgeriesCompleted = InputHandler.getIntInput("Enter surgeries completed:", 0, 10000);

        boolean emergencyAvailable = InputHandler.getConfirmation("Is emergency surgery available?");


        Surgeon surgeon =
                new Surgeon(
                        baseDoctor.getId(),
                        baseDoctor.getFirstName(),
                        baseDoctor.getLastName(),
                        baseDoctor.getDateOfBirth(),
                        baseDoctor.getGender(),
                        baseDoctor.getPhoneNumber(),
                        baseDoctor.getEmail(),
                        baseDoctor.getAddress(),
                        baseDoctor.getDoctorId(),
                        baseDoctor.getSpecialization(),
                        baseDoctor.getQualification(),
                        baseDoctor.getExperienceYears(),
                        baseDoctor.getDepartmentId(),
                        baseDoctor.getConsultationFee(),
                        baseDoctor.getAvailableSlots(),
                        baseDoctor.getAssignedPatients(),
                        surgeriesCompleted,
                        List.of(surgeryType),
                        emergencyAvailable
                );

        doctors.add(surgeon);

        System.out.println("Surgeon added successfully."
        );

        return surgeon;
    }


    public static boolean handleDectorMenu(Integer DectorOption) {


        switch (DectorOption) {
            case 1 -> {
                addDoctors();
            }
            case 2 -> {

                addSurgeon();
            }

            case 3 -> {
                addConsultant();
            }

            case 4 -> {
                addGeneralPractitioner();
            }

            case 5 -> {
                displayAllDoctors();
            }

            case 6 -> {
                String specialization = InputHandler.getStringInput("Enter specialization:");
                List<Doctor> doctorsList = getDoctorsBySpecialization(specialization);

                for (Doctor doctor : doctorsList) {

                    doctor.displayInfo();
                }
            }

            case 7 -> {
                List<Doctor> doctorsList = getAvailableDoctors();

                for (Doctor doctor : doctorsList) {

                    doctor.displayInfo();
                }
            }

            case 8 -> {
                String doctorId = InputHandler.getStringInput("Enter doctor ID:");

                String patientId = InputHandler.getStringInput("Enter patient ID:");

                DoctorService service = new DoctorService();

                service.assignPatient(
                        doctorId,
                        patientId
                );
            }

            case 9 -> {
                String doctorId = InputHandler.getStringInput("Enter doctor ID to update:");

                editDoctor(doctorId);
            }
            case 10 -> {
                String doctorId = InputHandler.getStringInput("Enter doctor ID to remove:");

                removeDoctor(doctorId);
            }

            case 11 -> {

                return true;
            }

            default -> {

                System.out.println(
                        "Invalid option."
                );
            }
        }

        return false;
    }
}










