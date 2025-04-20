package Controllers;

import Models.AcademicProgram;
import Models.Course;
import Models.Enums.CourseStatus;
import Models.HCDDSingleton;
import ViewUIs.AllCoursesUI;
import ViewUIs.GraduationPlanUI;
import ViewUIs.SingleCourseUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class SingleCourseController implements ActionListener {
    //        The controller class creates the list of model objects, both the ArrayList and its members.
    private AcademicProgram ap; // this has an ArrayList as a field
    private ArrayList<Course> courses;
    private Course course;
    private SingleCourseUI ui;
    private AllCoursesUI allCoursesUI;
    private int currentCourseNumber;

    private ArrayList<Course> studentCoursesList;


    public SingleCourseController() {

        this.ap = HCDDSingleton.getInstance().getAcademicProgram();
        this.courses = ap.getCourses();

        this.studentCoursesList = new ArrayList<>();
//        this.studentCoursesList.add(hcdd113);

        //        The controller class creates and shows an instance of the view class. The view class should include JTextFields to display data accessed from the model objects.
        ui = new SingleCourseUI(this, 0);
//        this.addActionListenerButtons();

        ui.setTitle("Single Course View");
        ui.setDefaultCloseOperation(EXIT_ON_CLOSE);
        ui.setSize(3000, 2000);
        ui.setVisible(true);


    }

    public ArrayList<Course> getListOfCourses() {
        return ap.getCourses();
    }

    public Course getCourse(int selectedRow) {
        return this.courses.get(selectedRow);
    }

    public void addActionListenerButtons() {
        ui.saveButton.addActionListener(this);
        ui.editButton.addActionListener(this);
        ui.cancelEditButton.addActionListener(this);
        ui.exitButton.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();

        if (obj == ui.saveButton) {
            // Grab values from fields and update course
            Course c = courses.get(currentCourseNumber); // or a new one
            c.setGrade((CourseStatus) ui.statusComboBox.getSelectedItem());
            c.setAvailable(); // you might add a setSummer(boolean) if you want
            // Parse other fields as needed
            // Optional: validate fields before updating
        } else if (obj == ui.editButton) {
            // Enable fields for editing
            ui.newCourseTextField.setEditable(true);
        } else if (obj == ui.deleteButton) {
            courses.remove(currentCourseNumber);
            ui.dispose();
            // optionally show AllCoursesUI again
        } else if (obj == ui.cancelButton) {

        } else if (obj == ui.exitButton) {
//            ui.dispose(); // go back to AllCoursesUI
            ui.setVisible(false); // go back to AllCoursesUI
            allCoursesUI.setVisible(true);
        }
    }


    public void getCourseDetailsUI(int selectedRow) {
        ui = new SingleCourseUI(this, selectedRow);
        allCoursesUI.setVisible(false);
        ui.setVisible(true);
    }
 }


