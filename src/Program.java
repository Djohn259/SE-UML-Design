// Program class made by Chris Perez


import java.util.List;
import java.util.ArrayList;


public class Program {

    public final String programID; //major/minor identification
    public final String programType; //either major or minor
    private List<Integer> programReqs = new ArrayList<>(); //course requirements for this program
	
    
    public Program( //create a new program (either a major or a minor)
    		String programID,
    		String programType,
    		List<Integer> programReqs) {
    	this.programID = programID;
    	this.programType = programType;	
    	this.programReqs = programReqs;
    }
    
    
    public boolean addToProgram(int courseID) { //add additional courses to the program's requirements
    	if (programReqs.contains(courseID)) {
    		throw new IllegalArgumentException("Course already in program");
    	}
    	programReqs.add(courseID);
    	return true;
    }
    
    
    public boolean removeFromProgram(int courseID) { //remove a course from the program's requirements
    	if (programReqs.contains(courseID)) {
    		programReqs.remove(Integer.valueOf(courseID));
    		return true;
    	}
    	else { throw new IllegalArgumentException("Course not in program");
    	}
    }
    
    
    public String getProgramID() {
    	return this.programID;
    }
    
    
    public String getProgramType() {
    	return this.programType;
    }
    
    
    public List<Integer> getProgramReqs() {
    	return this.programReqs;
    }
    
    
    public String toString() {
        return "Program Summary \n"
        		+ "ID: " + this.programID + "\n"
                + "Type: " + this.programType + "\n"
                + "Requirements: " + this.programReqs;
    }
    
}