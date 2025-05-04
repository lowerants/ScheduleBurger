import Controllers.AllCoursesController;
import Controllers.GraduationPlannerController;
import Models.Course;
import Models.Student;

public class Application  {

    public static void main(String[] args) {
        // The main method creates an instance of the controller class.

//        GraduationPlannerController controller = new GraduationPlannerController();

//        AllCoursesController coursesController = new AllCoursesController();

        // LinkedList implementation will be a field of the Course object, it will be the list of Student objects that are on the waitlist
        Course ist210 = new Course("IST210");
        Student s = new Student("Lawrence");
        Student s2 = new Student("Beaver");
        ist210.addStudentToWaitList(s);
        ist210.addStudentToWaitList(s2);
        System.out.println(ist210.getWaitList());
        System.out.println(ist210.removeStudentFromWaitList(s));
        System.out.println(ist210.getWaitList());
        System.out.println(ist210.getStudentFromWaitList("Beaver"));
    }
}


/*
    //    The view class should include the following buttons:
//        todo: Previous - to move backwards
    JButton previousButton = new JButton("Previous");


    //        todo: Next - to move forwards through the objects in the ArrayList
    JButton nextButton = new JButton("Next");

    //        todo: Add - add a new object to the list
    JButton addButton = new JButton("Add");

    //        todo: Update - make changes to an existing object
    JButton updateButton = new JButton("Update");

    //        todo: Delete - remove the current object
    JButton deleteButton = new JButton("Delete");

    //        todo: Quit - exit the application (hint: you can use System.exit(0); )
    JButton quitButton = new JButton("Quit");
    // remember to use System.exit(0) in the controller

 */