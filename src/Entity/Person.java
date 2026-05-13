package Entity;

import utility.HelperUtils;

import java.time.LocalDate;
import java.util.Objects;

public  abstract class Person {
    private String id;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    String gender;
    private String phoneNumber;
    private String email;
    private String address;


    //empty constructor

    public Person() {
    }

    // Full constructor
    public Person(String id, String firstName, String lastName, LocalDate dateOfBirth,
                  String gender, String phoneNumber, String email, String address) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
    }

    //insert Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {

        if(HelperUtils.isNull(id)){
            System.out.println("ID cannot be empty.");
            return;
        }

        this.id = id;
    }
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {

        if(!HelperUtils.isValidString(firstName)){
            System.out.println("Invalid first name.");
            return;
        }

        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {

        if(!HelperUtils.isValidString(lastName)){
            System.out.println("Invalid last name.");
            return;
        }

        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(
            LocalDate dateOfBirth) {

        if(!HelperUtils.isValidAge(dateOfBirth)){
            System.out.println("Invalid date of birth.");
            return;
        }

        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // Display method
    public void displayInfo() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + firstName + " " + lastName);
        System.out.println("DOB: " + dateOfBirth);
        System.out.println("Gender: " + gender);
        System.out.println("Phone: " + phoneNumber);
        System.out.println("Email: " + email);
        System.out.println("Address: " + address);
    }

    // toString override


    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", gender='" + gender + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
// equals override

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}