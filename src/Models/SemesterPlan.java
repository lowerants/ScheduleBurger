package Models;

import java.util.ArrayList;

// this may be superfluous
    // as in I might just make GradPlan have an ArrayList<ArrayList<Models.Course>> for the main field

// for now, keeping this
public class SemesterPlan extends CourseList implements CourseAdder {
    private Semester sem;
    private int year;

    // CONSTRUCTOR
    public SemesterPlan(String name, ArrayList<Course> courses, Semester sem, int year) {
        super(name, courses); // reminder: totalCredits calculated in here
        this.sem = sem;
        this.year = year;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
                sem + " " + year + ": " + courses.toString();
    }


    public boolean addCourse(Course c) {
        if(totalCredits <= 19 && c.isAvailable()) {
            courses.add(c);
            totalCredits += c.getNumCredits();
            return true;
        }
        return false;
    }

    // GETTERS AND SETTERS
    public Semester getSemester() {
        return sem;
    }

    public void setSemester(Semester sem) {
        this.sem = sem;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setTotalCredits(int totalCredits) {
        this.totalCredits = totalCredits;
    }


}
