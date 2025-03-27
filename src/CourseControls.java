import java.util.ArrayList;

// tempted to make this class final, but I don't want to remove the possibility to update
// ugh, this app should be for Students, I shouldn't worry about how maintenance will manage this
public class CourseControls {
    // courses.txt will have these as an ArrayList of requirements for them

    private String course; // when the control is taking another course
    // for now, I won't worry about concurrent vs prereq (probably won't do it for the final assignment either)
    // String instead of Course makes this WAY easier

    private int sem; // when a class can only be taken a certain semester or later


    // when constructing, 2 of these will likely be null, as many courses.txt only have one of these as a CourseControl
    // better design is to probably make 3 more constructors, each with one parameter, but Idc rn
    public CourseControls(String course, int sem) {
        this.course = course;
        this.sem = sem;
    }

    public CourseControls(String course) {
        this.course = course;
        this.sem = 1;
    }

    @Override
    public String toString() {
        ArrayList<String> str = new ArrayList<>();
        if(!this.course.isEmpty()) {
            str.add(this.course);
        }
        if(this.sem != 1) {
            str.add(" " + this.sem);
        }

        return str.toString();
    }

    public String getCourses() {
        return course;
    }

    public int getSem() {
        return sem;
    }

}
