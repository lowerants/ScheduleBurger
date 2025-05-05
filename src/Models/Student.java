package Models;

import Models.Enums.CourseStatus;
import Models.Enums.ProgramProgress;
import Models.Enums.YearStanding;

import java.io.Serializable;
import java.util.*;

import static Models.Enums.CourseStatus.*;

public class Student implements Serializable {
    public class CourseProgress {
        private HashMap<Course, CourseStatus> courseStatuses;
        public CourseProgress(Course c) {
            this.courseStatuses = new HashMap<>();
            this.courseStatuses.put(c, CURRENTLY_TAKING);
        }
        public CourseProgress(List<Course> l) {
            this.courseStatuses = new HashMap<>();
            for(Course c : l) {
                this.courseStatuses.put(c, CURRENTLY_TAKING);
            }
        }
        public CourseProgress() {
            this.courseStatuses = new HashMap<>();
        }
        public void setCourseStatus(Course c, CourseStatus cs) {
            this.courseStatuses.put(c, cs);
        }

        public HashMap<Course, CourseStatus> getCourseStatuses() {
            return this.courseStatuses;
        }
    }


    private String name;
    private String pronouns; // shoutout trans people
    private double gpa;
    private YearStanding year; // freshman, sophomore, junior, senior
    private int creditsTaken;

    private GraduationPlan gradPlan;
//    private Map<Models.AcademicProgram, Integer> academicProgramsAndProgress;
    private HashMap<AcademicProgram, ProgramProgress> progress;
    // check Models.Enums.ProgramProgress for more details

    private HashSet<Course> waitListedCourses;

    // Collections 1 Assignment
    private CourseProgress courseProgress;

    // CONSTRUCTOR
    // add the default courses.txt for all students in here
    // maybe make that a singleton?
    public Student(String name, String pronouns, int creditsTaken, HashMap<AcademicProgram, ProgramProgress> progress) {
        this(name);
        this.pronouns = pronouns;
        this.creditsTaken = creditsTaken;
        this.progress = progress;
    }

    public CourseProgress getCourseProgress() {
        return this.courseProgress;
    }


    public HashSet<Course> getWaitListedCourses() {
        return waitListedCourses;
    }

    public void enterWaitlist(Course c) {
        this.waitListedCourses.add(c);
        this.courseProgress.setCourseStatus(c, WAITLISTED);
    }

    public boolean isOnWaitlist(Course c) {
        return this.waitListedCourses.contains(c);
    }

    public boolean leaveWaitlist(Course c) {
        if(this.waitListedCourses.contains(c)) {
            this.waitListedCourses.remove(c);
            this.courseProgress.setCourseStatus(c, NOT_TAKING);
            return true;
        }
        return false;
    }

    public boolean enterClassFromWaitList(Course c) {
        if(this.waitListedCourses.contains(c)) {
            this.addCourse(c);
            this.waitListedCourses.remove(c);
            this.courseProgress.setCourseStatus(c, CURRENTLY_TAKING);
            return true;
        }
        return false;
    }

    // for passing, failing, etc. a Student in a given Course
    public void updateCourseStatus(Course c, CourseStatus cs) {
        this.courseProgress.courseStatuses.put(c, cs);
    }


    public Student(String name) {
        this.name = name;
        this.gpa = 0;
        this.name = name;
        this.year = YearStanding.FRESHMAN;
        this.creditsTaken = 0;
        this.progress = new HashMap<AcademicProgram, ProgramProgress>();
        this.gradPlan = new GraduationPlan("[New Grad Plan]");

        this.waitListedCourses = new HashSet<>();

        this.courseProgress = new CourseProgress();
    }


    public void addCourse(Course c) {
        this.gradPlan.add(c);
        this.courseProgress.setCourseStatus(c, CURRENTLY_TAKING);
    }

    public boolean lateDropCourse(Course c) {
        this.courseProgress.setCourseStatus(c, LATE_DROPPED);
        return gradPlan.getCourses().remove(c);
    }

    public CourseStatus getCourseStatus(Course c) {
        return this.courseProgress.getCourseStatuses().get(c);
    }

    // GETTERS
    public GraduationPlan getGradPlan() {
        return this.gradPlan;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGpa() {
        return gpa;
    }

    public YearStanding getYear() {
        return year;
    }


    // todo: change this to an update year or something, for when a student has enough credits to be in their next year
    // the method will prob be more complicated, update based on creditsTaken
    public void setYear(YearStanding year) {
        this.year = year;
    }

    public int getCreditsTaken() {
        return creditsTaken;
    }

    public void setCreditsTaken(int creditsTaken) {
        this.creditsTaken = creditsTaken;
    }

    public Map<AcademicProgram, ProgramProgress> getProgress() {
        return progress;
    }

    public void setProgress(HashMap<AcademicProgram, ProgramProgress> progress) {
        this.progress = progress;
    }

    public String getPronouns() {
        return pronouns;
    }

    public void setPronouns(String pronouns) {
        this.pronouns = pronouns;
    }

    public String toString() {
        return name + " (" + pronouns + ") GPA: " + gpa + " Current Credits: " + creditsTaken + " Year: " + year + " Progress: " + progress.toString();
    }
}
