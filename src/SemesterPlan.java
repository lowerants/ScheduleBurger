import java.util.ArrayList;

// this may be superfluous
    // as in I might just make GradPlan have an ArrayList<ArrayList<Course>> for the main field
// if so, Plan no longer needs to exist
public class SemesterPlan extends Plan {
    private Semester sem;
    private int year;
    private ArrayList<Course> courses;
    private int totalCredits;

    public String toString() {
        return sem + ": " + courses.toString() + ": " + totalCredits + " cr.";
    }

    // todo: add validation like in the graduation plan
    // temporary, mostly a reminder to updated totalCredits HERE
    public void addCourse(Course c) {
        courses.add(c);
        totalCredits += c.getNumCredits();
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
