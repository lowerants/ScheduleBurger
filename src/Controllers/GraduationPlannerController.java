package Controllers;

import Models.AcademicProgram;
import Models.Course;
import Models.HCDDSingleton;
import ViewUIs.GraduationPlanUI;
import Models.Enums.CourseStatus;
import static Models.LiteralListOfCourses.*;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class GraduationPlannerController implements ActionListener {
    //        The controller class creates the list of model objects, both the ArrayList and its members.
    private AcademicProgram ap; // this has an ArrayList as a field
    private ArrayList<Course> courses;
    private Course course;
    private GraduationPlanUI ui;
    private int currentCourseNumber;

    private ArrayList<Course> studentCoursesList;


    public GraduationPlannerController() {

        this.ap = HCDDSingleton.getInstance().getAcademicProgram();
        this.courses = ap.getCourses();

        this.studentCoursesList = new ArrayList<>();
//        this.studentCoursesList.add(hcdd113);

        //        The controller class creates and shows an instance of the view class. The view class should include JTextFields to display data accessed from the model objects.
        ui = new GraduationPlanUI(this);
        this.addActionListenerButtons();

        ui.setTitle("Graduation Planner");
        ui.setDefaultCloseOperation(EXIT_ON_CLOSE);
        ui.setSize(3000, 2000);
        ui.setVisible(true);


    }

    public ArrayList<Course> getListOfCourses() {
        return ap.getCourses();
    }

    public void addActionListenerButtons() {
        ui.nextButton.addActionListener(this);
        ui.previousButton.addActionListener(this);
        ui.updateButton.addActionListener(this);
        ui.deleteButton.addActionListener(this);
        ui.quitButton.addActionListener(this);
        ui.addButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if(obj == ui.nextButton) {
            currentCourseNumber = ui.getCurrentCourseNumber();
            if(currentCourseNumber >= courses.size()-1) {
                currentCourseNumber = 0;
            }
            else {
                currentCourseNumber++;
            }
            ui.setCurrentCourseNumber(currentCourseNumber);
            ui.parseCourse(courses.get(currentCourseNumber));
        }
        else if(obj == ui.previousButton) {
            currentCourseNumber = ui.getCurrentCourseNumber();
            if(currentCourseNumber == 0) {
                currentCourseNumber = courses.size()-1;
            }
            else {
                currentCourseNumber--;
            }
            ui.setCurrentCourseNumber(currentCourseNumber);
            ui.parseCourse(courses.get(currentCourseNumber));
        }
        else if(obj == ui.updateButton) {
            Course c = ui.getCourse();
            c.setAvailable();
            ui.parseCourse(c);
        }
        else if(obj == ui.addButton) {
            String courseCode = ui.addACourseHereTextField.getText();
            Course c = new Course(courseCode);
            studentCoursesList.add(c);
            c.setGrade(CourseStatus.UPCOMING_COURSE);
            ui.parseStudentCourseList();
        }
        else if(obj == ui.deleteButton) {
            if(studentCoursesList != null) {
                studentCoursesList.removeLast();
            }
            ui.parseStudentCourseList();
        }
        else if(obj == ui.quitButton) {
            System.exit(0);
        }
    }

    public ArrayList<Course> getStudentCoursesList() {
        return this.studentCoursesList;
    }
}
