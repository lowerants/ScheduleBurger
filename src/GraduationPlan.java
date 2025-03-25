import java.util.ArrayList;

public class GraduationPlan {
    private String name; // name of the plan
    private ArrayList<SemesterPlan> semesterPlans;
    // private ArrayList<ArrayList<Course>>

    private int totalCredits;
    private ArrayList<AcademicProgram> programs;
    private int graduatingYear; // should I make semester and year into one object?
    private Semester graduatingSemester; // do I have to add Winter?


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


    // todo: add validation in here, maybe change return type to boolean (whether validation says true or false)
        // could make that a throw tho
    void addCourse(Course c) {

    }

    public String getName() {
        return name;
    }

    public ArrayList<SemesterPlan> getSemesterPlans() {
        return semesterPlans;
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
