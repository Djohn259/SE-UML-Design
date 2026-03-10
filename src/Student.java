//STUDENT CLASS IS MADE BY SPENCER SKJELSTAD

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Student {
    private final int studentID; // id for each student
    private final List<Course> classes; // list of classes student is in
    private int earnedCredits;
    private final List<Program> major;
    private final List<Program> minor; // lists of majors and minors
    private int activeCredits;
    private final Map<Course, String> grades; // stores grades for classes
    private final String firstname;
    private final String lastname;
    private final String email;
    private boolean isLoggedIn; // false or true wether logged in

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

    public boolean addmajor(Program program) {
        requireLoggedIn();
        if (program == null)
            return false;
        if (major.contains(program)) // no duplicates
            return false;
        major.add(program);
        return true;
    }

    public boolean addminor(Program program) {
        requireLoggedIn();
        if (program == null)
            return false;
        if (minor.contains(program))// no duplicates
            return false;
        minor.add(program);
        return true;
    }

    public boolean dropmajor(Program program) {
        requireLoggedIn();
        if (program == null)
            return false;
        return major.remove(program);// removes the major
    }

    public boolean dropminor(Program program) {
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
        return true;
    }

    public void logout() { // logs out
        isLoggedIn = false;
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

    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    public List<Program> getMajor() {
        return new ArrayList<>(major);
    }

    public List<Program> getMinor() {
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