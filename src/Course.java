import java.util.ArrayList;

public class Course {
    private String name;
    private String courseCode; // the letters and numbers
    private int numCredits;
    private Semester[] semAvailability; // list of semesters the class can be taken in
    private ArrayList<CourseControls> courseControls; // list of Course Controls

    private ArrayList<CourseAttribute> attributes; // what requirements the class fills
    private boolean available; // checks if the class is still being provided by the university


    // this one's ambitious but feels pertinent for people that want to change majors
    private ArrayList<AcademicProgram> transferablePrograms;
    // to help figure out which programs the course will still be counted for


    public Course(String name, String courseCode, int numCredits, Semester[] semAvailability, ArrayList<CourseControls> courseControls, ArrayList<CourseAttribute> attributes, ArrayList<AcademicProgram> transferablePrograms) {
        this.name = name;
        this.courseCode = courseCode;
        this.numCredits = numCredits;
        this.semAvailability = semAvailability; // especially important for marking summer classes
        this.courseControls = courseControls;
        this.attributes = attributes;
        this.transferablePrograms = transferablePrograms;

        this.available = true;
    }

    @Override
    public java.lang.String toString() {
        return courseCode + ": " + name + " [" + numCredits + "]";
        // unclear rn to add if semAvailability should be visible here
        // if needed, that will be a different method
    }

    // returns true if a class is avaiable in the summer
    // might not ending up needing this, we'll see
    public boolean summerAvailable() {
        for(Semester s : semAvailability) { // basically a contains method
            if(s == Semester.SUMMER) {
                return true;
            }
        }
        return false;
    }

    // GETTERS
    // no SETTERS because STUDENTs won't change these

    // probably don't need this...
    public String getName() {
        return name;
    }
    // or this...
    public String getCourseCode() {
        return courseCode;
    }

    public int getNumCredits() {
        return numCredits;
    }

    public Semester[] getSemAvailability() {
        return semAvailability;
    }

    public ArrayList<CourseControls> getCourseControls() {
        return courseControls;
    }

    public ArrayList<CourseAttribute> getAttributes() {
        return attributes;
    }

    public boolean isAvailable() {
        return available;
    }

    public ArrayList<AcademicProgram> getTransferablePrograms() {
        return transferablePrograms;
    }

}