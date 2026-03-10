import java.util.List;
import java.util.ArrayList;


public class Department {
	
	public final String departmentID;
	private List<Integer> profs = new ArrayList<>();
	private List<Integer> courses = new ArrayList<>();
	private List<String> programs = new ArrayList<>();
	
	
	Department(String departmentID) {
		this.departmentID = departmentID;
	}
	
	
	public boolean addProf(int profID) {
		profs.add(profID);
		return true;
	}
	
	
	public boolean addCourse(int courseID) {
		courses.add(courseID);
		return true;
	}
	
	
	public boolean addProgram(String programID) {
		programs.add(programID);
		return true;
	}
	
	
	public boolean removeProf(int profID) {
		if (!profs.contains(Integer.valueOf(profID))) {
			System.out.println("Professor not in department");
			return false;
		}
		profs.remove(Integer.valueOf(profID));
		return true;
	}
	
	
	public boolean removeCourse(int courseID) {
		if (!profs.contains(Integer.valueOf(courseID))) {
			System.out.println("Course not in department");
			return false;
		}
		profs.remove(Integer.valueOf(courseID));
		return true;
	}
	
	
	public boolean removeProgram(int programID) {
		if (!profs.contains(Integer.valueOf(programID))) {
			System.out.println("Program not in department");
			return false;
		}
		profs.remove(Integer.valueOf(programID));
		return true;
	}
	
	
	public List<Integer> getProfs() {
		return profs;
	}
	
	
	public List<Integer> getCourses() {
		return courses;
	}
	
	
	public List<String> getPrograms() {
		return programs;
	}
	
	
	public String toString() {
        return "Department Summary \n"
        		+ "Professors: " + profs + "\n"
                + "Programs: " + programs + "\n"
                + "Courses: " + courses;
    }
	
}
