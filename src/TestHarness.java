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

    public static void main(String[] args) throws FileNotFoundException {

        File courses = new File("C:\\Users\\misce\\OneDrive\\Documents\\GitHub\\ScheduleBurger\\text_files\\courses.txt");
        CourseList cL = new CourseList("All Courses", courses);

        System.out.println("test:");
        System.out.println(cL.toString());
    }

    @Test
    public void createCourse() throws FileNotFoundException {
//        SemesterPlan semPlan = new SemesterPlan(Semester.FALL, 2025, new ArrayList<>());
//        semPlan.addCourse()

        File courses = new File("C:\\Users\\misce\\OneDrive\\Documents\\GitHub\\ScheduleBurger\\text_files\\courses.txt");
        CourseList cL = new CourseList("All Courses", courses);

        Assertions.assertEquals("All Courses Courses: [IST261: App Dev Studio 1 [3]]\n" +
                "3 credits", cL.toString());
        Assertions.assertEquals("IST261: App Dev Studio 1 [3]" +
            "\nCourse Controls: [[{ist140}]]"
            + "\nAttributes: []",
                cL.getCourses().get(0).fullString());
    }
}
