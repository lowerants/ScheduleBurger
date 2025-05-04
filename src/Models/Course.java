package Models;

import Models.Enums.CourseAttribute;
import Models.Enums.CourseStatus;

import java.io.Serializable;
import java.util.HashMap;

import static Models.Enums.CourseStatus.*;

public class Course implements Serializable {
    private String name;
    private String courseCode; // the letters and numbers
    private int numCredits;

    private boolean summer;

    private CourseControls courseControl;
    private CourseAttribute attribute; // what requirements the class fills
    private boolean available; // checks if the class is still being provided by the university

    public CourseStatus getCourseStatus() {
        return courseStatus;
    }

    public void setCourseStatus(CourseStatus courseStatus) {
        this.courseStatus = courseStatus;
    }

    private CourseStatus courseStatus;


    // I DONT NEED TRANSFERRABLE PROGRAMS
    // I JUST NEED TO BE ABLE TO CROSS REFERENCE LATER
    // SO I CAN JUST CHECK IF THE COURSE EXISTS IN ACADEMIC PROGRAM
    // CONTAINS FUNCTION IN ACADEMIC PROGRAM

    public Course(String name) {
        HashMap<String, Course> map = LiteralListOfCourses.getCoursesMap();
        Course c = map.get(name);
        this(c.name, c.courseCode, c.numCredits, c.summer, c.courseControl, c.attribute);
    }

    public Course(String name,
          String courseCode,
          int numCredits,
//                  Models.Enums.Semester[] semAvailability,
          boolean summer,
          CourseControls courseControl,
          CourseAttribute attributes) {
        this.name = name;
        this.courseCode = courseCode.toUpperCase();
        this.numCredits = numCredits;
//        this.semAvailability = semAvailability; // especially important for marking summer classes
        this.summer = summer;
        this.courseControl = courseControl;
        this.attribute = attributes;

        this.available = true;

        this.courseStatus = NOT_TAKING;
    }
//
//    public Course(File file) throws FileNotFoundException {
//        Scanner fileReader = new Scanner(file);
//        fileReader.useDelimiter("\n\n");
//        while(fileReader.hasNext()) {
//            String[] courseInfo = fileReader.next().split("\n");
//            String[] baseDetails = courseInfo[0].split(", "); // first 4 fields
//
//            String[] controls = courseInfo[1].split(", "); // courseControl
//
////            String[] attributesArr = courseInfo[2].split(", ");
//
//
//
//            this.name = baseDetails[0];
//            this.courseCode = baseDetails[1];
//            this.numCredits = Integer.parseInt(baseDetails[2]);
//            this.summer = Boolean.parseBoolean(baseDetails[3]);
//
//            this.courseControl = new CourseControls(controls[0]);
////            this.courseControl = new ArrayList<courseControl>();
////            this.courseControl.add(new courseControl(controls[0]));
//            // for now, this can only take 1 prereq
//
//
//        }
//    }

    @Override
    public String toString() {
        return courseCode + ": " + name + " [" + numCredits + "]";
//                + " " + courseStatus;
        // unclear rn to add if semAvailability should be visible here
        // if needed, that will be a different method
    }

    public String fullString() {
        String returnStr = this.toString();
        if(summer) {
            returnStr += " [SUMMER AVAIL] ";

        }
        return returnStr +
                "\nModels.Course Controls: " + courseControl +
                "\nAttributes: " + attribute +
                "\nStatus: " + courseStatus +
                "Available: " + available;
//                "\nTransferable Programs: " + transferablePrograms;
    }


    // GETTERS

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

//    public Models.Enums.Semester[] getSemAvailability() {
//        return semAvailability;
//    }

    public CourseControls getCourseControls() {
        return courseControl;
    }

    public CourseAttribute getAttributes() {
        return attribute;
    }

    public boolean isAvailable() {
        return available;
    }

    public boolean getSummer() {
        return summer;
    }

    public CourseStatus getGrade() {
        return courseStatus;
    }

    // SETTERS
    public void setGrade(CourseStatus g) {
        this.courseStatus = g;
    }

    public void setAvailable() {
        this.available = !this.available;
    }



//    public ArrayList<Models.AcademicProgram> getTransferablePrograms() {
//        return transferablePrograms;
//    }

}