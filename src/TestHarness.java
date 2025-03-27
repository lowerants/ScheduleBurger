/* In your course application project, create a call called  "TestHarness".
Modify the TestHarness constructor so that it instantiates and tests two of your model classes.
The tests should be complete relative to the functionality of the classes,
i.e., they should test every method in each class.
 */


import java.io.FileNotFoundException;
import java.util.ArrayList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.File;

public class TestHarness {

    public static void main(String[] args) {
        TestHarness th = new TestHarness();
    }

    public TestHarness() {

        System.out.println("Test CourseControls");
        CourseControls cc = new CourseControls("ist130", 2);
        System.out.println(cc.getCourses());
        System.out.println(cc.getSem());
        System.out.println(cc);

        System.out.println();

        System.out.println("Test Course");
        Course ist261 = new Course("App Dev Studio 1", "ist261", 3, false, cc, null);
        System.out.println(ist261.fullString());
        System.out.println(ist261.summerAvailable());
        System.out.println(ist261.getName());
        System.out.println(ist261.getCourseCode());
        System.out.println(ist261.getNumCredits());
        System.out.println(ist261.getcourseControls());
        System.out.println(ist261.getAttributes());
        System.out.println(ist261.isAvailable());


        System.out.println(ist261);

        //        File courses = new File("C:\\Users\\misce\\OneDrive\\Documents\\GitHub\\ScheduleBurger\\text_files\\courses.txt");
//        CourseList cL = new CourseList("All Courses", courses);
//
//        System.out.println("test:");
//        System.out.println(cL.toString());


    }


    @Test
    public void createCourse() throws FileNotFoundException {
//        SemesterPlan semPlan = new SemesterPlan(Semester.FALL, 2025, new ArrayList<>());
//        semPlan.addCourse()


    }
}
