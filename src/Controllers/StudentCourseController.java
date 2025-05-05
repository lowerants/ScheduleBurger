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
import java.util.PriorityQueue;

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
        ui.setSize(700, 700);
        ui.setVisible(true);
    }

    public void addActionListenerButtons() {
        ui.searchButton.addActionListener(this);
        ui.addCourseButton.addActionListener(this);
        ui.removeCourseButton.addActionListener(this);
        ui.enterWaitlistButton.addActionListener(this);
        ui.moveFromWaitlistToButton.addActionListener(this);
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
            if (c == null){
                JOptionPane.showMessageDialog(ui, search + " is not a valid course");
            }
            else if(student.isOnWaitlist(c)) {
                JOptionPane.showMessageDialog(ui, "You are currently on the waitlist for " + c.getCourseCode());
            }
            else if(student.getCourseStatus(c) == CourseStatus.CURRENTLY_TAKING) {
                JOptionPane.showMessageDialog(ui, "You are currently already taking " + c.getCourseCode());
            }
            else {
                this.student.addCourse(c);
                JOptionPane.showMessageDialog(ui, c.getCourseCode() + " added!");
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
            else if(c!= null && student.getCourseStatus(c) == CourseStatus.WAITLISTED) {
                this.student.leaveWaitlist(c);
                JOptionPane.showMessageDialog(ui, "You have been removed from the waitlist for " + c.getCourseCode());
            }
            else {
                JOptionPane.showMessageDialog(ui, search + " was not in your course list");
            }
        }
        else if(obj == ui.enterWaitlistButton) {
            if(c == null) {
                JOptionPane.showMessageDialog(ui, search + " is not a valid course");
            }
            else if(this.student.isOnWaitlist(c)) {
                JOptionPane.showMessageDialog(ui, "You are already on the waitlist for " + c.getCourseCode());
            }
            else if(this.student.getCourseStatus(c) == CourseStatus.CURRENTLY_TAKING) {
                JOptionPane.showMessageDialog(ui, "You are already taking " + c.getCourseCode());
            }
            else {
                this.student.enterWaitlist(c);
                JOptionPane.showMessageDialog(ui, "You are now on the waitlist for " + c.getCourseCode());
            }
        }
        else if(obj == ui.moveFromWaitlistToButton) {
            if(c == null) {
                JOptionPane.showMessageDialog(ui, search + " is not a valid course");
            }
            else if(this.student.enterClassFromWaitList(c)) {
                JOptionPane.showMessageDialog(ui, "You have moved from the waitlist to the class for " + c.getCourseCode());
            }
            else {
                JOptionPane.showMessageDialog(ui, "You were not on the waitlist for " + c.getCourseCode());
            }
        }
    }

    private Course searchCourse(String search) {
        return Course.makeCourse(search); // can be null
    }
}
