import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Course {
    private String name;
    private String courseCode; // the letters and numbers
    private int numCredits;

    // I may simplify this to
    private boolean summer;
//    private Semester[] semAvailability; // list of semesters the class can be taken in


//    private ArrayList<courseControl> courseControl; // list of Course Controls
    private CourseControls courseControl;
    private ArrayList<CourseAttribute> attributes; // what requirements the class fills
    private boolean available; // checks if the class is still being provided by the university


    // I DONT NEED TRANSFERRABLE PROGRAMS
    // I JUST NEED TO BE ABLE TO CROSS REFERENCE LATER
    // SO I CAN JUST CHECK IF THE COURSE EXISTS IN ACADEMIC PROGRAM
    // CONTAINS FUNCTION IN ACADEMIC PROGRAM

    // this one's ambitious but feels pertinent for people that want to change majors
//    private ArrayList<AcademicProgram> transferablePrograms;
    // to help figure out which programs the course will still be counted for
    // I think I've decided this is too ambitious, will leave it in the code for now


    public Course() {}

    public Course(String name,
          String courseCode,
          int numCredits,
//                  Semester[] semAvailability,
          boolean summer,
          CourseControls courseControl,
          ArrayList<CourseAttribute> attributes) {
        this.name = name;
        this.courseCode = courseCode.toUpperCase();
        this.numCredits = numCredits;
//        this.semAvailability = semAvailability; // especially important for marking summer classes
        this.summer = summer;
        this.courseControl = courseControl;
        this.attributes = attributes;

        this.available = true;
    }

    public Course(File file) throws FileNotFoundException {
        Scanner fileReader = new Scanner(file);
        fileReader.useDelimiter("\n\n");
        while(fileReader.hasNext()) {
            String[] courseInfo = fileReader.next().split("\n");
            String[] baseDetails = courseInfo[0].split(", "); // first 4 fields

            String[] controls = courseInfo[1].split(", "); // courseControl

//            String[] attributesArr = courseInfo[2].split(", ");



            this.name = baseDetails[0];
            this.courseCode = baseDetails[1];
            this.numCredits = Integer.parseInt(baseDetails[2]);
            this.summer = Boolean.parseBoolean(baseDetails[3]);

            this.courseControl = new CourseControls(controls[0]);
//            this.courseControl = new ArrayList<courseControl>();
//            this.courseControl.add(new courseControl(controls[0]));
            // for now, this can only take 1 prereq


        }
    }

    @Override
    public String toString() {
        return courseCode + ": " + name + " [" + numCredits + "]";
        // unclear rn to add if semAvailability should be visible here
        // if needed, that will be a different method
    }

    public String fullString() {
        String returnStr = this.toString();
        if(summer) {
            returnStr += " [SUMMER AVAIL] ";

        }
        return returnStr +
                "\nCourse Controls: " + courseControl +
                "\nAttributes: " + attributes;
//                "\nTransferable Programs: " + transferablePrograms;
    }

    // returns true if a class is avaiable in the summer
    // might not ending up needing this, we'll see
    public boolean summerAvailable() {
        return summer;
//        for(Semester s : semAvailability) { // basically a contains method
//            if(s == Semester.SUMMER) {
//                return true;
//            }
//        }
//        return false;
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

//    public Semester[] getSemAvailability() {
//        return semAvailability;
//    }

    public CourseControls getcourseControls() {
        return courseControl;
    }

    public ArrayList<CourseAttribute> getAttributes() {
        return attributes;
    }

    public boolean isAvailable() {
        return available;
    }

//    public ArrayList<AcademicProgram> getTransferablePrograms() {
//        return transferablePrograms;
//    }

}