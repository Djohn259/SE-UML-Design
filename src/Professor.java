// Nic Patterson
import java.util.ArrayList;
import java.util.List;

public class Professor {
    public int professorID;
    private List<Course> classes;
    public String department;
    private String firstName;
    private String lastName;
    private String email;
    private boolean tenure;

    public Professor(int professorID, String department, String firstName, String lastName, String email, boolean tenure) {
        this.professorID = professorID;
        this.department = department;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.tenure = tenure;
        this.classes = new ArrayList<>();
    }

    // Getters and Setters
    public List<Course> getClasses() {
        return classes;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public boolean isTenured() {
        return tenure;
    }

    // toString Functions
    private String toStringTest() {
        return "Professor ID: " + professorID + "\n"
                + "Department: " + department + "\n"
                + "First Name: " + firstName + "\n"
                + "Last Name: " + lastName + "\n"
                + "Email: " + email + "\n"
                + "Tenure: " + (tenure ? "Yes" : "No") + "\n"
                + "Classes: " + classes;
    }

    public String toString() {
        return "Professor ID: " + professorID + "\n"
                + "Department: " + department + "\n"
                + "First Name: " + firstName + "\n"
                + "Last Name: " + lastName + "\n"
                + "Email: " + email + "\n"
                + "Classes: " + classes;
    }

    // Other Planned Methods
    public void offerClass(Course course) {
        // Implementation for offering a class to the students
        int limit = tenure ? 7 : 5;
        if (classes.size() < limit) {
            classes.add(course);
        } else {
            System.out.println("Class limit reached for this professor.");
        }
    }

    public void removeClass(Course course) {
        // Implementation for removing a class once it has been offered
        classes.remove(course);
    }

    private void logIn() {
        // Implementation for logging in to the system

    }

    private void logOut() {
        // Implementation for logging out of the system
    }

    public void assignGrade() {
        // Implementation for assigning a grade to a class


    }

    public void submitGrades() {
        // Implementation for submitting grades for all classes to the student's transcript
    }
}
