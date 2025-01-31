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
    // as of rn it is not


    public AcademicProgram(String name, ProgramType type, int totalCredits, int minCredits, ArrayList<Course> etmReqs, ArrayList<Course> programReqs) {
        this.name = name;
        this.type = type;
        this.totalCredits = totalCredits;
        this.minCredits = minCredits;
        this.etmReqs = etmReqs;
        this.programReqs = programReqs;
    }

    // Only GETTERS because STUDENTs should not be able to change this data
    public String getName() {
        return name;
    }

    public ProgramType getType() {
        return type;
    }

    public int getTotalCredits() {
        return totalCredits;
    }

    public int getMinCredits() {
        return minCredits;
    }

    public ArrayList<Course> getEtmReqs() {
        return etmReqs;
    }

    public ArrayList<Course> getProgramReqs() {
        return programReqs;
    }
}
