import java.io.Serializable;

public class Lecturer implements Serializable {

    private String lecturerId;
    private String firstName;
    private String lastName;
    private String department;

    public Lecturer(String lecturerId, String firstName, String lastName, String department) {
        this.lecturerId = lecturerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
    }

    // Getters
    public String getLecturerId() {
        return lecturerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDepartment() {
        return department;
    }

    // Setters
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return lecturerId + " - " + firstName + " " + lastName + " (" + department + ")";
    }
}