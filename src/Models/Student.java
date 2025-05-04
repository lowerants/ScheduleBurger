package Models;

import Models.Enums.ProgramProgress;
import Models.Enums.Semester;
import Models.Enums.YearStanding;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Student implements Serializable {
    private String name;
    private String pronouns; // shoutout trans people
    private double gpa;
    private YearStanding year; // freshman, sophomore, junior, senior
    private int creditsTaken;

    private GraduationPlan gradPlan;
//    private Map<Models.AcademicProgram, Integer> academicProgramsAndProgress;
    private HashMap<AcademicProgram, ProgramProgress> progress;
    // check Models.Enums.ProgramProgress for more details

    private CourseList waitListedCourses;


    // CONSTRUCTOR
    // add the default courses.txt for all students in here
    // maybe make that a singleton?
    public Student(String name, String pronouns, int creditsTaken, HashMap<AcademicProgram, ProgramProgress> progress) {
        this(name);
        this.pronouns = pronouns;
        this.creditsTaken = creditsTaken;
        this.progress = progress;
    }

    public Student(String name) {
        this.name = name;
        this.gpa = 0;
        this.name = name;
        this.year = YearStanding.FRESHMAN;
        this.creditsTaken = 0;
        this.progress = new HashMap<AcademicProgram, ProgramProgress>();
        this.gradPlan = new GraduationPlan("[New Grad Plan]");

        this.waitListedCourses = new CourseList(this.name + "'s waitlist");
    }

    // GETTERS

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGpa() {
        return gpa;
    }

    public YearStanding getYear() {
        return year;
    }


    // todo: change this to an update year or something, for when a student has enough credits to be in their next year
    // the method will prob be more complicated, update based on creditsTaken
    public void setYear(YearStanding year) {
        this.year = year;
    }

    public int getCreditsTaken() {
        return creditsTaken;
    }

    public void setCreditsTaken(int creditsTaken) {
        this.creditsTaken = creditsTaken;
    }

    public Map<AcademicProgram, ProgramProgress> getProgress() {
        return progress;
    }

    public void setProgress(HashMap<AcademicProgram, ProgramProgress> progress) {
        this.progress = progress;
    }

    public String getPronouns() {
        return pronouns;
    }

    public void setPronouns(String pronouns) {
        this.pronouns = pronouns;
    }

    public String toString() {
        return name + " (" + pronouns + ") GPA: " + gpa + " Current Credits: " + creditsTaken + " Year: " + year + " Progress: " + progress.toString();
    }
}
