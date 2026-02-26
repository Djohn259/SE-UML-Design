import java.util.Arrays;

public class Course {
    public String name;
    public String professor;
    public int capacity;
    public int classId;
    public String desc;
    public String[] time;
    public String semester;
    public int creditNum;
    public String creditType;
    public Course[] prereq;
    private final String[] prereqNames;

    public Course(String name, String professor, int capacity, int classId, String desc,
                  String[] time, String semester, String creditType, Course[] prereq) {
        this.name = name;
        this.professor = professor;
        this.capacity = capacity;
        this.classId = classId;
        this.desc = desc;
        this.time = time;
        this.semester = semester;
        this.creditNum = 4;
        this.creditType = creditType;
        this.prereq = prereq;
        prereqNames = new String[prereq.length];
        for (int i = 0; i < prereq.length; i++) {
            prereqNames[i] = prereq[i].name;
        }
    }

    public Course(String name, String professor, int capacity, int classId, String desc,
                  String[] time, String semester, String creditType) {
        this.name = name;
        this.professor = professor;
        this.capacity = capacity;
        this.classId = classId;
        this.desc = desc;
        this.time = time;
        this.semester = semester;
        this.creditNum = 4;
        this.creditType = creditType;
        this.prereq = new Course[]{};
        prereqNames = new String[]{};
    }

    public String toString() {
        return "Name: " + name + "\n"
                + "Professor: " + professor + "\n"
                + "Capacity: " + capacity + "\n"
                + "Description: " + desc + "\n"
                + "Time: " + Arrays.toString(time).replace("[", "").replace("]", "") + "\n"
                + "Semester: " + semester + "\n"
                + "Total Credits: " + creditNum + "\n"
                + "Credit Type: " + creditType + "\n"
                + "Prerequisites: " + Arrays.toString(prereqNames).replace("[", "").replace("]", "") + "\n";
    }

    public static void main(String[] args) {
        Course c1 = new Course("CS1", "Louis Yu", 30, 177, "This", new String[]{"Monday 12:00pm-1:00pm", "Wednesday 12:00pm-1:00pm", "Friday 12:00pm-1:00pm"}, "Fall", "Q");
        Course c2 = new Course("CS2", "Louis Yu", 30, 178, "This", new String[]{"Monday 12:00pm-1:00pm", "Wednesday 12:00pm-1:00pm", "Friday 12:00pm-1:00pm"}, "Fall", "Q", new Course[]{c1});
        Course c3 = new Course("Software Engineering", "Louis Yu", 30, 374, "This", new String[]{"Tuesday 12:00pm-1:35pm", "Thursday 12:00pm-1:35pm"}, "Spring", "Q", new Course[]{c1, c2});
        Course c4 = new Course("Video Game Development", "Guario", 30, 394, "This", new String[]{"Tuesday 1:45pm-3:20pm", "Thursday 1:45pm-3:20pm"}, "Spring", "Q", new Course[]{c1, c2});
        Course c5 = new Course("Calc 1", "Professor #2", 30, 121, "This", new String[]{"Monday 12:00pm-1:00pm", "Wednesday 12:00pm-1:00pm", "Friday 12:00pm-1:00pm"}, "Fall", "Q");
        Course c6 = new Course("Calc 2", "Professor #4", 15, 122, "This", new String[]{"Monday 11:45am-12:50pm", "Wednesday 11:45am-12:50pm", "Friday 11:45am-12:50pm"}, "Spring", "Q", new Course[]{c5});
        Course c7 = new Course("Multi-variable Calc", "Professor #5", 222, 177, "This", new String[]{"Monday 8:00am-9:05am", "Wednesday 8:00am-9:05am", "Friday 8:00am-9:05am"}, "Fall", "Q", new Course[]{c5, c6});
        Course c8 = new Course("Discrete Math", "Professor #6", 30, 150, "This", new String[]{"Monday 12:00pm-1:00pm", "Wednesday 12:00pm-1:00pm", "Friday 12:00pm-1:00pm"}, "Fall", "Q");
        Course c9 = new Course("Systems", "Professor #2", 30, 276, "This", new String[]{"Monday 12:00pm-1:00pm", "Wednesday 12:00pm-1:00pm", "Friday 12:00pm-1:00pm"}, "Spring", "Q", new Course[]{c1, c2, c8});
        Course c10 = new Course("Random Class", "Professor #1", 25, 211, "This", new String[]{"Monday 12:00pm-1:00pm", "Wednesday 12:00pm-1:00pm", "Friday 12:00pm-1:00pm"}, "Spring", "Q");
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);
        System.out.println(c4);
        System.out.println(c5);
        System.out.println(c6);
        System.out.println(c7);
        System.out.println(c8);
        System.out.println(c9);
        System.out.println(c10);
        for (int i = 0; i < 29; i++) {
            c3.capacity--;
        }
        System.out.println(c3);
    }
}
