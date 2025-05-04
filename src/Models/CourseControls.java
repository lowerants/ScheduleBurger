package Models;

// lol this doesn't seem that useful tbh

import java.io.Serializable;
import java.util.ArrayList;

// tempted to make this class final, but I don't want to remove the possibility to update
// ugh, this app should be for Students, I shouldn't worry about how maintenance will manage this
public class CourseControls implements Serializable {
    // courses.txt will have these as an ArrayList of requirements for them

    private ArrayList<String> course; // when the control is taking another course
    // ArrayList because the list of courses are all "either or"
        // as in you only need to take one of these courses

    private int sem; // when a class can only be taken a certain semester or later

    public CourseControls(ArrayList<String> courses) {
        this.course = courses;
    }

//    public CourseControls(String course, int sem) {
//        this.course = new ArrayList<>();
//        this.course.add(course);
//        this.sem = sem;
//    }

    public CourseControls(String course) {
        this.course = new ArrayList<>();
        this.course.add(course);
        this.sem = 1;
    }

    public CourseControls(String course, int sem) {
        this.course = new ArrayList<>();
        this.course.add(course);
        this.sem = 1;
    }

    @Override
    public String toString() {
        String str = "";
        if(!this.course.isEmpty()) {
            str += this.course;
        }
        if(this.sem != 1) {
            str += " " + this.sem + " semester minimum";
        }
        return str;
    }

    public ArrayList<String> getCourses() {
        return course;
    }

    public int getSem() {
        return sem;
    }

}
