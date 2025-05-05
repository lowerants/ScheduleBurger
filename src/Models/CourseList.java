package Models;

import java.io.*;
import java.util.ArrayList;

// child classes are Models.SemesterPlan and Models.AcademicProgram
public class CourseList implements Serializable {
    protected String name;
    protected ArrayList<Course> courses;
    protected String listOfCoursesFileName = "listOfCourses.ser";
    // maybe make this a map
    // actually can't do that because courses may have to be included multiple times
    // well
    // not per semester
    // fuck
    // idk
    // later problem

    protected int totalCredits;

//    public CourseList(String name, File file) throws FileNotFoundException {
//        this.name = name;
//        Scanner fileReader = new Scanner(file);
//        fileReader.useDelimiter("\n\n");
//        courses = new ArrayList<>();
//        while (fileReader.hasNext()) {
//            String[] courseInfo = fileReader.next().split("\n");
//            String[] baseDetails = courseInfo[0].split(", "); // first 4 fields
//
//            String[] controls = courseInfo[1].split(", "); // courseControls
////            String[] transferablePrograms =
////            String[] attributesArr = courseInfo[2].split(", ");
//
//            ArrayList<Models.Enums.CourseAttribute> attributes = new ArrayList<>();
//            String attr = controls[2].substring(1, controls[2].length()-1);
//            if(!attr.equals("}")){
//                attributes.add(Models.Enums.CourseAttribute.valueOf(attr)); // only one Models.Enums.CourseAttribute for now
//            }
//            Models.Course c = new Models.Course(
//                    baseDetails[0], // name
//                    baseDetails[1], // courseCode
//                    Integer.parseInt(baseDetails[2]), // numCredits
//                    Boolean.parseBoolean(baseDetails[3]), // summer
//                    new Models.CourseControls(controls[0], Integer.parseInt(controls[1])), // courseControls (0-1 prereqs) (minSemester)
//                    attributes // attributes
//            );
//
//            courses.add(c);
//
////            this.courseControls = new ArrayList<Models.CourseControls>();
////            this.courseControls.add(new Models.CourseControls(controls[0]));
//        }
//
//        for(Models.Course c : courses) {
//            totalCredits += c.getNumCredits();
//        }
//    }


    public CourseList(String name, ArrayList<Course> courses) {
        this.name = name;
        this.courses = courses;
        this.totalCredits = 0;
        if(!courses.isEmpty() && !(courses == null)) {
            for(Course c : courses) {
                this.totalCredits += c.getNumCredits();
            }
        }

    }

    public CourseList(String name) {
        this.readCourseListFile();
        if(courses == null || courses.isEmpty()) {
            this.createTestCourseList();
            this.writeCourseListFile();
            this.readCourseListFile();
        }
        this.printCourseList();
    }

    public void printCourseList() {
        for(Course c : this.courses) {
            System.out.println(c.toString());
        }
    }

    public void readCourseListFile() {
        FileInputStream fis = null;
        ObjectInputStream in = null;
        try {
            fis = new FileInputStream(listOfCoursesFileName);
            in = new ObjectInputStream(fis);
            courses = (ArrayList) in.readObject();
            in.close();
            if (!courses.isEmpty()) {
                System.out.println("There are Course objects in this.courses");
            }
        } catch (FileNotFoundException fne) {
            System.out.println("File was not found, a new one will be created");
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public void writeCourseListFile() {
        FileOutputStream fos = null;
        ObjectOutputStream out = null;
        try {
            fos = new FileOutputStream(listOfCoursesFileName);
            out = new ObjectOutputStream(fos);
            out.writeObject(courses);
            out.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void createTestCourseList() {
        courses = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            courses.add(Course.makeCourse("IST210"));
        }
        System.out.println("Test CourseList created");
        System.out.println("The CourseList is: " + courses);
    }

    public String toString() {
        return name + " " +
            "Courses: " + courses + "\n" +
            totalCredits + " credits";
    }

    public String getName() {
        return name;
    }

    public ArrayList<Course> getCourses() {
        return this.courses;
    }

    public int getTotalCredits() {
        return totalCredits;
    }

    // this functionality will probably be in a CONTROLLER


    // todo: add validation like in the graduation plan
    public boolean addCourse(Course c) {
        if(courses.contains(c)) {
            return false;
        }
        courses.add(c);
        totalCredits += c.getNumCredits();
        return true;
    }

    // todo: add reminders for the consequences of removing? That might be saved in a list when changing courses
    public boolean removeCourse(Course c) {
        if(!courses.contains(c)) {
            return false;
        }
        totalCredits -= c.getNumCredits();
        courses.remove(c);
        return true;
    }




//        public ArrayList<Models.AcademicProgram> getPrograms() {
//            return programs;
//        }
//
//
//        // change the name to Change Programs?
//        public void setPrograms(ArrayList<Models.AcademicProgram> programs) {
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
//        public Models.Enums.Semester getGraduatingSemester() {
//            return graduatingSemester;
//        }
//
//        public void setGraduatingSemester(Models.Enums.Semester graduatingSemester) {
//            this.graduatingSemester = graduatingSemester;
//        }
}

