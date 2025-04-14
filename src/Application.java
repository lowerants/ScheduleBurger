import Controllers.CourseAdderController;
import ViewUIs.CourseAdderView;

import javax.swing.*;
public class Application {

    public static void main(String[] args) {


        // The main method creates an instance of the controller class.
        CourseAdderController courseAdder = new CourseAdderController();



//    When the view class is first shown, it should display data from the object in the first position of the ArrayList.
        CourseAdderView ui = new CourseAdderView();

//    All of the behavior above should be mediated by the controller class.
//    In other words, the view class should only communicate with the controller,
//    and the controller alone manages interactions with the model objects.



    }
}
