package Models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static Models.Enums.CourseAttribute.*;

public class LiteralListOfCourses {
    public static LiteralListOfCourses INSTANCE;


    // ETM for HCDD
    public static Course ist210 = new Course("Organization of Data", "IST210", 3, false, null, null);

    public static Course hcdd113 = new Course("Foundations of Human-Centered Design and Development", "HCDD113", 3, false, null, null);

    public static Course ist140  = new Course("Introduction to Application Development", "IST140", 3, true, null, null);

    public static CourseControls ccIST242 = new CourseControls(new ArrayList<>(Arrays.asList("IST140", "CMPSC 131")));
    public static Course ist242 = new Course("Intermediate & Object-Oriented Application Development", "IS264", 3, false, ccIST242, null);

    public static Course ist220 = new Course("Networking and Telecommunications", "IST220", 3, true, null, null);

    public static Course stat200 = new Course("Elementary Statistics", "STAT200", 4, true, null, GQ);

    // other program reqs for HCDD
    public static CourseControls ccIST230 = new CourseControls(new ArrayList<>(Arrays.asList("MATH110", "MATH140")));
    public static Course ist230 = new Course("Language, Logic, and Discrete Mathematics", "IST230", 3, false, null, null);

    public static CourseControls ccIST261 = new CourseControls("IS242");
    public static Course ist261 = new Course("Application Development Design Studio I", "IST261", 3, false, ccIST261, null);

    public static CourseControls ccHCDD264 = new CourseControls("HCDD113");
    public static Course hcdd264 = new Course("Design Practice in Human-Centered Design and Development", "HCDD264", 3, false, ccHCDD264, null);

    public static CourseControls ccHCDD340 = new CourseControls(new ArrayList<>(Arrays.asList("HCDD264", "IST 256")));
    public static Course hcdd340 = new Course("Human-Centered Design for Mobile Computing", "HCDD340", 3, false, ccHCDD340, null);

    public static CourseControls ccHCDD364W = new CourseControls("HCDD264");
    public static Course hcdd364W = new Course("Methods for Studying Users", "HCDD364W", 3, false, ccHCDD364W, null);

    public static CourseControls ccHCDD440 = new CourseControls("HCDD364W");
    public static Course hcdd440 = new Course("Human-Centered Design and Development Capstone Course", "HCDD440", 3, false, ccHCDD440, null);

    public static Course engl15 = new Course("Rhetoric and Composition", "ENGL15", 3, true, null, GWS);

    public static ArrayList<Course> allCourses = new ArrayList<>(Arrays.asList(ist210, hcdd113, ist140, ist242, ist220, stat200, ist230, ist261, hcdd264, hcdd340, hcdd364W, hcdd440));

    public static HashMap<String, Course> coursesMap = new HashMap<>();



    public LiteralListOfCourses() {}

//    public static ListOfCoursesSingleton getInstance() {
//        if(INSTANCE == null) {
//            INSTANCE = new ListOfCoursesSingleton();
//        }
//        return INSTANCE;
//    }


    public static HashMap<String, Course> getCoursesMap() {
        coursesMap.put("IST210", ist210);
        coursesMap.put("HCDD113", hcdd113);
        coursesMap.put("IST140", ist140);
        coursesMap.put("IST242", ist242);
        coursesMap.put("IST220", ist220);
        coursesMap.put("STAT200", stat200);
        coursesMap.put("IST230", ist230);
        coursesMap.put("IST261", ist261);
        coursesMap.put("HCDD264", hcdd264);
        coursesMap.put("HCDD340", hcdd340);
        coursesMap.put("HCDD364W", hcdd364W);
        coursesMap.put("HCDD440", hcdd440);
        coursesMap.put("ENGL15", engl15);

        return coursesMap;
    }


}
