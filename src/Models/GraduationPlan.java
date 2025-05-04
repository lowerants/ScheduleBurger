package Models;

import Models.Enums.Semester;

import java.io.Serializable;
import java.util.ArrayList;

public class GraduationPlan implements Serializable {
    private String name; // name of the plan
    private ArrayList<SemesterPlan> semesterPlans;

    private int totalCredits;
    private ArrayList<AcademicProgram> programs;
    private int graduatingYear;
    private Semester graduatingSemester;

    public GraduationPlan(
            String name,
            ArrayList<SemesterPlan> semesterPlans,
            ArrayList<AcademicProgram> programs,
            int graduatingYear,
            Semester graduatingSemester) {
        this.name = name;
        this.semesterPlans = semesterPlans;
        this.totalCredits = 0;
        for(SemesterPlan s : semesterPlans) {
            for(Course c : s.getCourses()) {
                totalCredits += c.getNumCredits();
            }
        }
        this.programs = programs;
        this.graduatingYear = graduatingYear;
        this.graduatingSemester = graduatingSemester;
    }

    public GraduationPlan(String name) {
        this.name = name;
        this.semesterPlans = new ArrayList<SemesterPlan>();
        this.totalCredits = 0;
//        this.programs = programs;
//        this.graduatingYear = graduatingYear;
//        this.graduatingSemester = graduatingSemester;
    }


    // maybe this just calls semester plan's addCourse
    // todo: add validation in here, maybe change return type to boolean (whether validation says true or false)
        // could make that a throw tho
//    public boolean addCourse(Models.Course c) {
//        if()
//    }


    public String getName() {
        return name;
    }

    public ArrayList<SemesterPlan> getSemesterPlans() {
        return semesterPlans;
    }
    public ArrayList<Course> getCourses() {
        ArrayList<Course> c = new ArrayList<>();
        for(SemesterPlan s : this.semesterPlans) {
            c.addAll(s.getCourses());
        }
        return c;
    }

    public int getTotalCredits() {
        return totalCredits;
    }

    public void setTotalCredits(int totalCredits) {
        this.totalCredits = totalCredits;
    }

    public ArrayList<AcademicProgram> getPrograms() {
        return programs;
    }


    // change the name to Change Programs?
    public void setPrograms(ArrayList<AcademicProgram> programs) {
        this.programs = programs;
    }

    public int getGraduatingYear() {
        return graduatingYear;
    }

    public void setGraduatingYear(int graduatingYear) {
        this.graduatingYear = graduatingYear;
    }

    public Semester getGraduatingSemester() {
        return graduatingSemester;
    }

    public void setGraduatingSemester(Semester graduatingSemester) {
        this.graduatingSemester = graduatingSemester;
    }

}
