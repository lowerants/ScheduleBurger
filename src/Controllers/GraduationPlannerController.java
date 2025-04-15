package Controllers;

import Models.AcademicProgram;
import Models.Course;
import ViewUIs.GraduationPlannerUI;

public class GraduationPlannerController {
    //        The controller class creates the list of model objects, both the ArrayList and its members.
    private AcademicProgram ap; // this has an ArrayList as a field
    private Course course;
    private GraduationPlannerUI ui;

    public GraduationPlannerController() {

        AcademicProgram ap = new AcademicProgram()

        //        The controller class creates and shows an instance of the view class. The view class should include JTextFields to display data accessed from the model objects.
        GraduationPlannerUI ui = new GraduationPlannerUI();

        // The main method creates an instance of the controller class.


//    When the view class is first shown, it should display data from the object in the first position of the ArrayList.

//    All of the behavior above should be mediated by the controller class.
//    In other words, the view class should only communicate with the controller,
//    and the controller alone manages interactions with the model objects.




    }
}
