import java.util.ArrayList;

// this class would greatly benefit from a singleton Course[] that has requirements needed across all programs
public class AcademicProgram {
    private String name;
    private ProgramType type;
    private int totalCredits; // REMOVE?
    private int minCredits; // number of credits before entering the major
    // ignoring max credits

    // maybe make these Arrays
    // ArrayList is safer if these want to be updated Ig?
    // Unclear for now
    // I think these should prob be Arrays
    private ArrayList<Course> etmReqs; // entrance to major course requirements
    private ArrayList<Course> programReqs; // all course requirements
    // could make ^^^ the ones not in etm
}
