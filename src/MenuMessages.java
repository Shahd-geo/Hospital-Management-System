public class MenuMessages {
    public static String MAIN_MENU_MESSAGE = """
            
            ===== Hospital Management System =====
            
            1- Patient Menu
            2- Doctor Menu
            3- Nurse Menu
            4- Medical Record Menu 
            5- Appointment Menu
            6- Department Menu
            7- Exit
            
            """;


    public static String PATIENT_MENU_MESSAGE = """
            
         ======== Patient Management ========

        1- Register New Patient
        2- Register InPatient
        3- Register OutPatient
        4- Register Emergency Patient
        5- View All Patients
        6- Search Patient
        7- Update Patient Information
        8- Remove Patient
        9- View Patient Medical History
     10- Back To Main Menu

""";
    public static String DOCTOR_MENU_MESSAGE = """

            ======== Doctor Management ========

        1- Add Doctor
        2- Add Surgeon
        3- Add Consultant
        4- Add General Practitioner
        5 - View All Doctors
        6- Search Doctor by Specialization
        7- View Available Doctors
        8- Assign Patient to Doctor
        9- Update Doctor Information
        10- Remove Doctor
        11- Back To Main Menu

        """;
    public static String NURSE_MENU_MESSAGE = """

        ===== Nurse Management=====

       
        1- Add Nurse
        2- View All Nurses
        3- View Nurses by Department
        4- View Nurses by Shift
        5- Assign Nurse to Patient
        6- Update Nurse Information
        7- Remove Nurse
        8- Back To Main Menu
     

        """;


    public static String APPOINTMENT_MENU_MESSAGE = """

        ===== Appointment Management  =====

            1- Schedule New Appointment
            2- View All Appointments
            3- View Appointments by Patient
            4- View Appointments by Doctor
            5- View Appointments by Date
            6- Reschedule Appointment
            7- Cancel Appointment
            8- Complete Appointment
            9- View Upcoming Appointments
            10- Back To Main Menu1- Add Medical Record

        """;
    public static String MEDICAL_RECORD_MENU_MESSAGE = """

        ===== Medical Record Management =====
        
            1- Create Medical Record
            2- View All Records
            3- View Records by Patient
            4- View Records by Doctor
            5- Update Medical Record
            6- Delete Medical Record
            7- Generate Patient History Report
            8- Back To Main Menu
        
        
        """;
    public static String DEPARTMENT_MENU_MESSAGE = """

        ===== Department  Management  =====

            1- Add Department
            2- View All Departments
            3- View Department Details
            4- Assign Doctor to Department
            5- Assign Nurse to Department
            6- Update Department Information
            7- View Department Statistics
            8- Back To Main Menu

        """;

}

