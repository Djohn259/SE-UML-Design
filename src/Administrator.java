// Administrator Class by Spencer Pearson
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Administrator{
	// Class Attributes
	private final int adminID; //Unique id number for each administrator
	private String firstName; 
	private String lastName;
	private String email; // Admin's email address 
	private boolean isLoggedin; // check if admin user is logged in
	
	
	private static Map<String, Program> programMap = new HashMap<>(); // initializing hash map of programs that admin can add to
	private List<Student> students; // List of studnets
	private List<Course> courses; // List of courses
	
	//----Class Constructors----
	
	public Administrator(int adminID, String firstName, String lastName, String email) {
		this.adminID = adminID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		
		this.isLoggedin = false;
		this.students = new ArrayList<>();
		this.courses = new ArrayList<>();
	}
		
	//---- Administrator methods---
	
	public void login() { // login to do things
		isLoggedin = true;
        System.out.println("Administrator" + firstName + lastName + " is logged in");
		
	}
	
	public void logout() { // logout once finished
		isLoggedin = false;
        System.out.println("Administrator" + firstName + lastName + " has logged out");
        		
	}
	
	//----methods for getting and setting programs---
	
	public Program setProgram(String programID, String programType, List<Integer> programReqs) {
		if (isLoggedin) {
			if (programMap.containsKey(programID)) { // check if program ID is available
	            throw new IllegalArgumentException("Program ID already in use."); 
			}
	            else { 
	            	Program program = new Program(programID, programType, programReqs);
	            	programMap.put(programID, program); // if admin is logged in, put the new program in the program map

	            	return program;
			}
		}
		
		else {
			throw new IllegalStateException("Administrator must log in to create a program.");
		} 
	}
	
	public static Program getProgram(String programID) {
		return programMap.get(programID);
	}
	
	
	//---- methods for setting and getting students---
	
	public Student setStudent(int studentID, String firstName, String lastName, String email) {
		if (isLoggedin) {

			for (Student s : students) {
				if (s.getStudentID() == studentID) {
					throw new IllegalArgumentException("A Student with this ID already exists.");
				}
			}
			// if student id is available and admin is logged in, create student and add to list of students
			Student student = new Student(studentID, firstName, lastName, email);
			students.add(student);
			return student;
		}

		else {
			// if not logged in throw an error
			throw new IllegalStateException("Administrator must log in to add a student.");
		}
	}	
	
	
	// All Administrator methods will check if the Administrator is logged in

	public Student getStudent(int studentID) {
		if (isLoggedin) {
			// if administrator is logged in and student exists, return the student
			for (Student s : students) {
				if (s.getStudentID() == studentID) {
					return s;
				}
			}

			throw new IllegalArgumentException("No Student exists with this ID.");
		}

		else {
			throw new IllegalStateException("Administrator must log in to retrieve a student.");
		}
	}

	//----Methods for setting and getting courses---
	
	public Course setCourse(String name, String professor, int capacity, int classId,
			String desc, String[] time, String semester, String creditType) {
			if (isLoggedin) {

				for (Course c : courses) {
					if (c.classId == classId) {
						throw new IllegalArgumentException("A Course with this id already exists.");
					}
				}
				// if Admin is logged in and courseID not in use, create new course and add to courses list
				Course course = new Course(name, professor, capacity, classId, desc, time, semester, creditType);
				courses.add(course);
				return course;
			}

			else {
				throw new IllegalStateException("Administrator must log in to create a course.");
				}
			}
	
	
	public Course getCourse(int classId) {// if logged in and course exists, return the course
		if (isLoggedin) {
			
		
			for (Course c : courses) {
				if (c.classId == classId) {
					return c; // return the course
				}
			}

			throw new IllegalArgumentException("Course ID does not exist.");
		}

		else {
			throw new IllegalStateException("Administrator must log in to retrieve a course.");
		}
	}
	
	
	//----getter for the Administrator's information----
	public String getAdminInfo() {
		return "Admin ID: " + adminID + "\n"
			 + "First Name: " + firstName + "\n"
			 + "Last Name: " + lastName + "\n"
			 + "Email: " + email + "\n"
			 + "Logged In: " + isLoggedin;
	}

}
