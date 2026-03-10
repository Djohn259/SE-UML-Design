//STUDENT CLASS IS MADE BY SPENCER SKJELSTAD
//Adjustments made to Program class interaction by Chris Perez

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Student {
    private final int studentID; // id for each student
    private final List<Course> classes; // list of classes student is in
    private int earnedCredits;
    private final List<String> major;
    private final List<String> minor; // lists of majors and minors
    private int activeCredits;
    private final Map<Course, String> grades; // stores grades for classes
    private final String firstname;
    private final String lastname;
    private final String email;
    private boolean isLoggedIn; // false or true wether logged in
    private boolean gradStatus = false; // whether or not the student is eligible for graduation

    public Student( // creating a student
            int studentID,
            String firstname,
            String lastname,
            String email) {
        if (studentID <= 0) { // id number cant be negative
            throw new IllegalArgumentException("studentID must be positive");
        }
        this.studentID = studentID;

        this.firstname = requireNonBlank(firstname, "firstname");
        this.lastname = requireNonBlank(lastname, "lastname");
        this.email = requireNonBlank(email, "email"); // they have to put in their name and email
        this.classes = new ArrayList<>();
        this.grades = new HashMap<>();
        this.major = new ArrayList<>();
        this.minor = new ArrayList<>(); // initialize lists and maps
        this.earnedCredits = 0;
        this.activeCredits = 0; // start with 0 credits
        this.isLoggedIn = false; // not logged in to start
    }

    public boolean addclass(Course course) {
        requireLoggedIn();// must be logged in
        if (course == null)
            return false;

        if (classes.contains(course)) { // no duplicate classes
            return false;
        }

        if (activeCredits + course.creditNum > 18) { // cant take more than 18 credits
            return false;
        }

        classes.add(course); // once adding a course add to the active credits
        activeCredits += course.creditNum;
        return true;
    }

    public boolean dropclass(Course course) {
        requireLoggedIn();
        if (course == null)
            return false;

        boolean removed = classes.remove(course);
        if (removed) {
            activeCredits -= course.creditNum; // if the class got remove it will take away the credits
        }
        return removed;
    }

    public boolean addmajor(String program) {
        requireLoggedIn();
        if (program == null)
            return false;
        if (major.contains(program)) // no duplicates
            return false;
        Program myProgram = Admin.getProgram(program); // added by chris
        if (myProgram != null && myProgram.getProgramType().equals("Major")) {
            major.add(program);
        } else {
            System.out.println("Error, " + program + " does not exist as a major");
            return false;
        }
        return true;
    }

    public boolean addminor(String program) {
        requireLoggedIn();
        if (program == null)
            return false;
        if (minor.contains(program))// no duplicates
            return false;
        Program myProgram = Admin.getProgram(program); // added by chris
        if (myProgram != null && myProgram.getProgramType().equals("Minor")) {
            minor.add(program);
        } else {
            System.out.println("Error, " + program + " does not exist as a minor");
            return false;
        }
        return true;
    }

    public boolean dropmajor(String program) {
        requireLoggedIn();
        if (program == null)
            return false;
        return major.remove(program);// removes the major
    }

    public boolean dropminor(String program) {
        requireLoggedIn();
        if (program == null)
            return false;
        return minor.remove(program); // removes the minor
    }

    public List<String> checkgrades() { // returns a list of grades
        requireLoggedIn();
        List<String> gradeList = new ArrayList<>();

        for (Map.Entry<Course, String> entry : grades.entrySet()) { // go through grades
            Course c = entry.getKey();
            String g = entry.getValue();
            gradeList.add(c.name + " (" + c.classId + "): " + g); // add them to the list
        }

        return gradeList;
    }

    public boolean login(String emailName) { // logs them in
        if (emailName == null)
            return false;
        if (!email.equals(emailName)) // email does not match cant log in
            return false;

        isLoggedIn = true;
        if (earnedCredits >= 128) {
            gradStatus = true;
        }
        return true;
    }

    public void logout() { // logs out
        isLoggedIn = false;
    }

    public boolean getGradStatus() {
        return gradStatus;
    }

    public int getStudentID() {
        return studentID;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public int getActiveCredits() {
        return activeCredits;
    }

    public int getEarnedCredits() {
        return earnedCredits;
    }

    public List<Course> getClasses() {
        return new ArrayList<>(classes);
    }

    public List<String> getMajors() {
        return new ArrayList<>(major);
    }

    public List<String> getMinors() {
        return new ArrayList<>(minor);
    }

    private void requireLoggedIn() {
        if (!isLoggedIn) { // if not logged in throws this error
            throw new IllegalStateException("Student must be logged in.");
        }
    }

    private static String requireNonBlank(String value, String inputName) { // checks that the inputs are not null
        if (value == null) {
            throw new IllegalArgumentException(inputName + " cant be blank"); // if input is null throws this
        }
        return value.trim(); // returns the input with outh spaces
    }

}