import java.util.ArrayList;

// this may be superfluous
    // as in I might just make GradPlan have an ArrayList<ArrayList<Course>> for the main field

// for now, keeping this
public class SemesterPlan extends CourseList {
    private Semester sem;
    private int year;
    private ArrayList<Course> courses;
    private int totalCredits;

    // CONSTRUCTOR
    public SemesterPlan(String name, ArrayList<Course> courses, Semester sem, int year) {
        super(name, courses); // reminder: totalCredits calculated in here
        this.sem = sem;
        this.year = year;
    }

    public String toString() {
        return sem + ": " + courses.toString() + ": " + totalCredits + " cr.";
    }




    // GETTERS AND SETTERS

    public Semester getSem() {
        return sem;
    }

    public void setSem(Semester sem) {
        this.sem = sem;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public int getTotalCredits() {
        return totalCredits;
    }

    public void setTotalCredits(int totalCredits) {
        this.totalCredits = totalCredits;
    }


}
