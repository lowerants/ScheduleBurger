import Controllers.AllCoursesController;
import Controllers.GraduationPlannerController;
import Controllers.StudentCourseController;
import Models.Course;
import Models.Student;

public class Application  {

    public static void main(String[] args) {
        // The main method creates an instance of the controller class.

//        GraduationPlannerController controller = new GraduationPlannerController();

//        AllCoursesController coursesController = new AllCoursesController();

        // LinkedList implementation will be a field of the Course object, it will be the list of Student objects that are on the waitlist
//        Course ist210 = new Course("IST210");
        Student s = new Student("Lawrence");
//        Student s2 = new Student("Beaver");
//        ist210.addStudentToWaitList(s);
//        ist210.addStudentToWaitList(s2);
//        System.out.println(ist210.getWaitList());
//        System.out.println(ist210.removeStudentFromWaitList(s));
//        System.out.println(ist210.getWaitList());
//        System.out.println(ist210.getStudentFromWaitList("Beaver"));

        StudentCourseController scc = new StudentCourseController(s);


    }
}