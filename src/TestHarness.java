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
        CourseControls cc = new CourseControls("ist130", 1);

        Course ist = new Course("App Dev Studio 1", "ist261", 3, false
        cc, 1
        {});


        /*

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

         */
    }

    public TestHarness() throws FileNotFoundException{
        File courses = new File("C:\\Users\\misce\\OneDrive\\Documents\\GitHub\\ScheduleBurger\\text_files\\courses.txt");
        CourseList cL = new CourseList("All Courses", courses);

        System.out.println("test:");
        System.out.println(cL.toString());


    }


    @Test
    public void createCourse() throws FileNotFoundException {
//        SemesterPlan semPlan = new SemesterPlan(Semester.FALL, 2025, new ArrayList<>());
//        semPlan.addCourse()


    }
}
