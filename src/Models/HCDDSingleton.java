package Models;

import Enums.CourseAttribute;
import Enums.ProgramType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class HCDDSingleton {
    private static HCDDSingleton INSTANCE;

    // ETM
    private static Course ist210 = new Course("Organization of Data", "IST210", 3, false, null, null);

    private static Course hcdd113 = new Course("Foundations of Human-Centered Design and Development", "HCDD113", 3, false, null, null);

    private static Course ist140  = new Course("Introduction to Application Development", "IST140", 3, true, null, null);

    private static CourseControls ccIST242 = new CourseControls(new ArrayList<>(Arrays.asList("IST140", "CMPSC 131")));
    private static Course ist242 = new Course("Intermediate & Object-Oriented Application Development", "IS264", 3, false, ccIST242, null);

    private static Course ist220 = new Course("Networking and Telecommunications", "IST220", 3, true, null, null);

    private static Course stat200 = new Course("Elementary Statistics", "STAT200", 4, true, null, new ArrayList<>(List.of(CourseAttribute.GQ)));
    ArrayList<Course> entranceToMajorCourses = new ArrayList<>(Arrays.asList(hcdd113, ist140, ist242, ist210, ist220, stat200));


    // OTHER
    private static CourseControls ccIST230 = new CourseControls(new ArrayList<>(Arrays.asList("MATH110", "MATH140")));
    private static Course ist230 = new Course("Language, Logic, and Discrete Mathematics", "IST230", 3, false, null, null);

    private static CourseControls ccIST261 = new CourseControls("IS242");
    private static Course ist261 = new Course("Application Development Design Studio I", "IST261", 3, false, ccIST261, null);

    private static CourseControls ccHCDD264 = new CourseControls("HCDD113");
    private static Course hcdd264 = new Course("Design Practice in Human-Centered Design and Development", "HCDD264", 3, false, ccHCDD264, null);

    private static CourseControls ccHCDD340 = new CourseControls(new ArrayList<>(Arrays.asList("HCDD264", "IST 256")));
    private static Course hcdd340 = new Course("Human-Centered Design for Mobile Computing", "HCDD340", 3, false, ccHCDD340, null);

    private static CourseControls ccHCDD364W = new CourseControls("HCDD264");
    private static Course hcdd364W = new Course("Methods for Studying Users", "HCDD364W", 3, false, ccHCDD364W, null);

    private static CourseControls ccHCDD440 = new CourseControls("HCDD364W");
    private static Course hcdd440 = new Course("Human-Centered Design and Development Capstone Course", "HCDD440", 3, false, ccHCDD440, null);


    ArrayList<Course> listOfCourses = new ArrayList<>(Arrays.asList(ist230, ist261, hcdd264, hcdd340, hcdd364W, hcdd440));
    AcademicProgram apHCDD = new AcademicProgram("HCDD Major", listOfCourses, ProgramType.MAJOR, 40, entranceToMajorCourses);


    private HCDDSingleton() {}

    public static HCDDSingleton getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new HCDDSingleton();
        }
        return INSTANCE;
    }


    // GETTERS
    public ArrayList<Course> getETMCourses() {
        return this.entranceToMajorCourses;
    }
    public ArrayList<Course> getAllCourses() {
        ArrayList<Course> allCourses = new ArrayList<>();
        allCourses.addAll(entranceToMajorCourses);
        allCourses.addAll(listOfCourses);
        return allCourses;
    }
    public AcademicProgram getAcademicProgram() {
        return this.apHCDD;
    }

}
