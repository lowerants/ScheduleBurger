package Controllers;

import Models.Course;
import Models.Enums.CourseStatus;
import Models.Student;
import ViewUIs.SingleCourseUI;
import ViewUIs.StudentCourseUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class StudentCourseController implements ActionListener {
    private Student student;
//    private Student.CourseProgress courseProgress;
    // courseProgress (encapsulates HashMap) gets updated in Student.addCourse()
//    private ArrayList<Course> courses;

    private StudentCourseUI ui;

    public StudentCourseController(Student s) {
        this.student = s;
//        this.courseProgress = s.getCourseProgress();
//        this.courses = s.getGradPlan().getCourses();
        this.ui = new StudentCourseUI(this);

        this.addActionListenerButtons();

        ui.setTitle("Student Course View");
        ui.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        ui.setSize(500 , 500);
        ui.setVisible(true);
    }

    public void addActionListenerButtons() {
        ui.searchButton.addActionListener(this);
        ui.addCourseButton.addActionListener(this);
        ui.removeCourseButton.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        Object obj = e.getSource();
        String search = ui.searchBarTextField.getText();
        Course c = this.searchCourse(search);
        if (obj == ui.searchButton) {
            if(c != null) {
                JOptionPane.showMessageDialog(ui, c.fullString());
            }
            else {
                JOptionPane.showMessageDialog(ui, search + " is not a valid course");
            }
        }
        else if(obj == ui.addCourseButton) {
            if(c != null) {
                this.student.addCourse(c);
                JOptionPane.showMessageDialog(ui, c.getCourseCode() + " added!");
            }
            else {
                JOptionPane.showMessageDialog(ui, search + " is not a valid course");
            }
        }
        else if(obj == ui.removeCourseButton) {
            if(c != null && student.getCourseStatus(c) == CourseStatus.LATE_DROPPED) {
                JOptionPane.showMessageDialog(ui, c.getCourseCode() + " was ALREADY late dropped");
            }
            else if(c != null &&
                    (student.getCourseStatus(c) == CourseStatus.CURRENTLY_TAKING)) {
                this.student.lateDropCourse(c);
                JOptionPane.showMessageDialog(ui, c.getCourseCode() + " was late dropped");
            }
            else {
                JOptionPane.showMessageDialog(ui, search + " was not in your course list");
            }
        }
    }

    private Course searchCourse(String search) {
        return Course.makeCourse(search); // can be null
    }

    private void addCourse(Course c) {

    }
}
