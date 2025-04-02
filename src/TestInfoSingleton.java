import org.junit.jupiter.api.TestInfo;

import java.util.ArrayList;
import java.util.Arrays;

public final class TestInfoSingleton {

    private static TestInfoSingleton INSTANCE;
    private static CourseControls cc = new CourseControls("ist130", 2);
    private static Course ist261 = new Course("App Dev Studio 1", "ist261", 3, false, cc, null);
    private static Course ist230 = new Course("Discrete Math", "ist230", 3, false, null, null);
    ArrayList<Course> list = new ArrayList<>(Arrays.asList(ist261, ist230));
    CourseList cl = new CourseList("List 1", list);


    private TestInfoSingleton() {}

    public static TestInfoSingleton getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new TestInfoSingleton();
        }
        return INSTANCE;
    }

    public CourseControls getCC() {
        return cc;
    }

    public ArrayList<Course> getList() {
        return list;
    }

    public CourseList getCourseList() {
        return cl;
    }


}
