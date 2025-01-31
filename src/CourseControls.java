import java.util.ArrayList;

// tempted to make this class final, but I don't want to remove the possibility to update
// ugh, this app should be for Students, I shouldn't worry about how maintenance will manage this
public class CourseControls {
    // courses will have these as an ArrayList of requirements for them
    private ArrayList<Course> courses; // when the control is taking another course
    // for now, I won't worry about concurrent vs prereq (probably won't do it for the final assignment either)

    private int sem; // when a class can only be taken a certain semester or later

    private ArrayList<College> college; // when a course can only be taken by students in a certain college

    // when constructing, 2 of these will likely be null, as many courses only have one of these as a CourseControl
    // better design is to probably make 3 more constructors, each with one parameter, but Idc rn
    public CourseControls(ArrayList<Course> courses, int sem, ArrayList<College> college) {
        this.courses = courses;
        this.sem = sem;
        this.college = college;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public int getSem() {
        return sem;
    }

    // for displaying the Colleges that a Student must be in to be in the class
    public ArrayList<College> getCollege() {
        return college;
    }

    // this would only be for updating the requirements set by the university and not function the Student should have
    // likely REMOVING this
    public void setCollege(ArrayList<College> college) {
        this.college = college;
    }
}
