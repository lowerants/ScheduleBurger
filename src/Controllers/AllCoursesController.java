package Controllers;

import Models.*;
import Models.Enums.CourseStatus;
import ViewUIs.AllCoursesUI;
import ViewUIs.GraduationPlanUI;
import ViewUIs.SingleCourseUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import static Models.LiteralListOfCourses.allCourses;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;


public class AllCoursesController
//        implements ActionListener
{

    //Arrays.asList(ist230, ist261, hcdd264, hcdd340, hcdd364W, hcdd440)
    private CourseList allCoursesList = new CourseList("All Courses", allCourses);
    private AllCoursesTableModel table;
    private AllCoursesUI ui;

    public AllCoursesController() {

        //        The controller class creates and shows an instance of the view class. The view class should include JTextFields to display data accessed from the model objects.
        ui = new AllCoursesUI(this);
        this.addActionListenerButtons();

        ui.setTitle("All Courses");
        ui.setDefaultCloseOperation(EXIT_ON_CLOSE);
        ui.setSize(3000, 2000);
        ui.setVisible(true);

    }

    public AllCoursesTableModel getAllCoursesTableModel() {
        return table;
    }

    public void addActionListenerButtons() {
//        ui.newButton.addActionListener(this);
//        ui.showDetailsButton.addActionListener(this);
//        ui.doneButton.addActionListener(this);
    }




}
