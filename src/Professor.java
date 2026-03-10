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

    @Override
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
        System.out.println(firstName + " " + lastName + " logged in.");
    }

    private void logOut() {
        // Implementation for logging out of the system
        System.out.println(firstName + " " + lastName + " logged out.");
    }

    public void assignGrade() {
        // Implementation for assigning a grade to a class
        System.out.println("Please input a grade");
        String grade = System.console().readLine();
        System.out.println("Grade assigned: "+grade);
    }

    public void submitGrades() {
        // Implementation for submitting grades for all classes to the student's transcript
        System.out.println("Grades officially submitted for all offered classes.");
    }

    // Unit Testing
    public static void main(String[] args) {
        Professor p1 = new Professor(1, "Computer Science", "Louis", "Yu", "lyu@example.edu", true);
        System.out.println("--- Testing Tenured Professor ---");
        System.out.println(p1);

        Course c1 = new Course("CS1", "Louis Yu", 30, 177, "Intro to CS", new String[]{"MWF 12-1"}, "Fall", "Q");
        Course c2 = new Course("CS2", "Louis Yu", 30, 178, "Data Structures", new String[]{"MWF 12-1"}, "Fall", "Q");

        p1.offerClass(c1);
        p1.offerClass(c2);
        System.out.println("\nAfter offering 2 classes:\n" + p1);

        p1.logIn();
        p1.assignGrade();
        p1.submitGrades();
        p1.logOut();

        p1.removeClass(c1);
        System.out.println("\nAfter removing CS1:\n" + p1);

        System.out.println("\n--- Testing Non-Tenured Professor (Limit 5) ---");
        Professor p2 = new Professor(2, "Math", "Jane", "Doe", "jdoe@example.edu", false);
        for (int i = 1; i <= 6; i++) {
            System.out.print("Offering Math" + i + ": ");
            p2.offerClass(new Course("Math" + i, "Jane Doe", 30, 100 + i, "Desc", new String[]{}, "Fall", "Q"));
        }
    }
}
