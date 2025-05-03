package Controllers;

import Models.AcademicProgram;
import Models.Course;
import Models.Enums.CourseStatus;
import Models.HCDDSingleton;
import ViewUIs.AllCoursesUI;
import ViewUIs.SingleCourseUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class SingleCourseController implements ActionListener {
    //        The controller class creates the list of model objects, both the ArrayList and its members.
    private static AcademicProgram ap = HCDDSingleton.getInstance().getAcademicProgram(); // this has an ArrayList as a field
    private ArrayList<Course> courses;
    private Course course;
    private SingleCourseUI ui;
    private AllCoursesUI allCoursesUI;
    private int currentCourseNumber;

    private ArrayList<Course> studentCoursesList;
    private AllCoursesController aController;

    public SingleCourseController(Course c, AllCoursesController ac, AllCoursesUI acUI) {
        this.course = c;
        this.aController = ac;
        this.courses = aController.getAllCoursesList().getCourses();
        this.allCoursesUI = acUI;

        this.studentCoursesList = new ArrayList<>();
//        this.studentCoursesList.add(hcdd113);

        //        The controller class creates and shows an instance of the view class. The view class should include JTextFields to display data accessed from the model objects.
        ui = new SingleCourseUI(this, 0);
//        this.addActionListenerButtons();

        ui.setTitle("Single Course View");
        ui.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        ui.setSize(500 , 500);
        ui.setVisible(true);

        this.aController.updateUI();
    }

    public ArrayList<Course> getListOfCourses() {
        return ap.getCourses();
    }

    public Course getCourse(int selectedRow) {
        return this.courses.get(selectedRow);
    }

    public void addActionListenerButtons() {
        ui.saveEditsButton.addActionListener(this);
        ui.editButton.addActionListener(this);
        ui.deleteButton.addActionListener(this);
        ui.exitButton.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();

        String newName = ui.editNameTextField.getText();
        String newCourseCode = ui.editCourseCodeTextField.getText();
        int newCredits = (int) ui.numCreditsSpinner.getValue();
//        String newCourseStatus = String.valueOf(ui.editNameTextField);

        Course newCourse = new Course(newName, newCourseCode, newCredits, false, null, null);

        if (obj == ui.deleteButton) {
            this.courses.remove(this.course);
            ui.dispose();
        }
        else if(obj == ui.saveEditsButton) {
            int index = courses.indexOf(this.course);
            if (index != -1) {
                courses.set(index, newCourse);
                this.course = newCourse;
                JOptionPane.showMessageDialog(ui, "Edits saved!");
            }
        }
        else if(obj == ui.exitButton) {
            this.ui.dispose(); // close this.ui
            allCoursesUI.setVisible(true); //
        }
        else if(obj == ui.publishButton) {
            aController.addCourse(newCourse);
            courses.add(newCourse);
        }
        aController.updateUI();
    }


    public void getCourseDetailsUI(int selectedRow) {
        ui = new SingleCourseUI(this, selectedRow);
        allCoursesUI.setVisible(false);
        ui.setVisible(true);
    }
 }


