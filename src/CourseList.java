import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

// this should replace Plan
// this is for unordered, unsorted collections of courses
// sorted and organized ones will be in GraduationPlan and SemesterPlan
public class CourseList {
    private String name;
    private ArrayList<Course> courses;
    // maybe make this a map
    // actually can't do that because courses may have to be included multiple times
    // well
    // not per semester
    // fuck
    // idk
    // later problem

    private int totalCredits;

    public CourseList(String name, File file) throws FileNotFoundException {
        this.name = name;
        Scanner fileReader = new Scanner(file);
        fileReader.useDelimiter("\n\n");
        courses = new ArrayList<>();
        while (fileReader.hasNext()) {
            String[] courseInfo = fileReader.next().split("\n");
            String[] baseDetails = courseInfo[0].split(", "); // first 4 fields

            String[] controls = courseInfo[1].split(", "); // courseControls
//            String[] transferablePrograms =
//            String[] attributesArr = courseInfo[2].split(", ");

            ArrayList<CourseAttribute> attributes = new ArrayList<>();
            String attr = controls[2].substring(1, controls[2].length()-1);
            if(!attr.equals("}")){
                attributes.add(CourseAttribute.valueOf(attr)); // only one CourseAttribute for now
            }
            Course c = new Course(
                    baseDetails[0], // name
                    baseDetails[1], // courseCode
                    Integer.parseInt(baseDetails[2]), // numCredits
                    Boolean.parseBoolean(baseDetails[3]), // summer
                    new CourseControls(controls[0], Integer.parseInt(controls[1])), // courseControls (0-1 prereqs) (minSemester)
                    attributes // attributes
            );

            courses.add(c);

//            this.courseControls = new ArrayList<CourseControls>();
//            this.courseControls.add(new CourseControls(controls[0]));
        }

        for(Course c : courses) {
            totalCredits += c.getNumCredits();
        }
    }


    public CourseList(String name, ArrayList<Course> courses) {
        this.name = name;
        this.courses = courses;
        this.totalCredits = 0;
        for(Course c : courses) {
            this.totalCredits += c.getNumCredits();
        }
////            String name,
//            ArrayList<SemesterPlan> semesterPlans, int totalCredits, ArrayList<AcademicProgram> programs, int graduatingYear, Semester graduatingSemester) {
////        this.name = name;
//        this.semesterPlans = semesterPlans;
//        this.totalCredits = totalCredits;
//        this.programs = programs;
//        this.graduatingYear = graduatingYear;
//        this.graduatingSemester = graduatingSemester;
    }


    public String toString() {
        return name + " " +
                "Courses: " + courses + "\n" +
                totalCredits + " credits";

    }

    public ArrayList<Course> getCourses() {
        return this.courses;
    }


    // todo: add validation like in the graduation plan
    // temporary, mostly a reminder to updated totalCredits HERE
    public void addCourse(Course c) {
        courses.add(c);
        totalCredits += c.getNumCredits();
    }

    // todo: add reminders for the consequences of removing? That might be saved in a list when changing courses
    public void removeCourse(Course c) {
        totalCredits -= c.getNumCredits();
        courses.remove(c);
    }

    public int getTotalCredits() {
        return totalCredits;
    }


//        public ArrayList<AcademicProgram> getPrograms() {
//            return programs;
//        }
//
//
//        // change the name to Change Programs?
//        public void setPrograms(ArrayList<AcademicProgram> programs) {
//            this.programs = programs;
//        }
//
//        public int getGraduatingYear() {
//            return graduatingYear;
//        }
//
//        public void setGraduatingYear(int graduatingYear) {
//            this.graduatingYear = graduatingYear;
//        }
//
//        public Semester getGraduatingSemester() {
//            return graduatingSemester;
//        }
//
//        public void setGraduatingSemester(Semester graduatingSemester) {
//            this.graduatingSemester = graduatingSemester;
//        }
}

