package Models;

import Enums.ProgramType;

import java.util.ArrayList;

// this class would greatly benefit from a singleton Models.Course[] that has requirements needed across all programs
public class AcademicProgram extends CourseList implements CourseAdder {
    private ProgramType type;
    private int minCredits; // number of credits before entering the major

    private ArrayList<Course> etmReqs; // entrance to major course requirements

// this is instead ArrayList<Models.Course> from the superclass
//    private ArrayList<Models.Course> programReqs; // all course requirements

    public AcademicProgram(String name, ArrayList<Course> programReqs, ProgramType type, int minCredits, ArrayList<Course> etmReqs) {
        super(name, programReqs); // don't forget this calculates totalCredits from the programReqs

        this.type = type;
        this.minCredits = minCredits;
        this.etmReqs = etmReqs;
    }


    public Course contains(Course c) {
         if(super.courses.contains(c)) {
             return c;
         }
         return null;
    }

    @Override
    public boolean addCourse(Course c) {
        if(courses.contains(c) || !c.isAvailable()) {
            return false;
        }
        courses.add(c);
        totalCredits += c.getNumCredits();
        return true;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
                minCredits + " minimum credits required to enter\n" +
                type + " program\n";
    }

    // Only GETTERS because STUDENTs should not be able to change this data

    public ProgramType getType() {
        return type;
    }

    public int getMinCredits() {
        return minCredits;
    }

    public ArrayList<Course> getEtmReqs() {
        return etmReqs;
    }

    // this is technically overriding getCourses
    public ArrayList<Course> getProgramReqs() {
        return super.courses;
    }
}
