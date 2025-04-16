package Models;

import Models.Enums.ProgramType;

import java.util.ArrayList;
import java.util.Arrays;

import static Models.LiteralListOfCourses.*;

public final class HCDDSingleton {
    private static HCDDSingleton INSTANCE;

    ArrayList<Course> entranceToMajorCourses = new ArrayList<>(Arrays.asList(hcdd113, ist140, ist242, ist210, ist220, stat200));
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
