package Models;

import java.io.*;
import java.util.ArrayList;

public class StudentList {
    private ArrayList<Student> listOfStudents = new ArrayList<>();
    private String listOfStudentsFileName = "listOfStudents.ser";
    public StudentList() {
        this.readStudentListFile();
        if(listOfStudents.isEmpty() || listOfStudents == null){
            this.createTestStudentList();
            this.writeStudentListFile();
            this.readStudentListFile();
        }
        this.printStudentList();
    }

    public ArrayList<Student> getListOfStudents() {
        return listOfStudents;
    }

    public void readStudentListFile() {
        FileInputStream fis = null;
        ObjectInputStream in = null;
        try {
            fis = new FileInputStream(listOfStudentsFileName);
            in = new ObjectInputStream(fis);
            listOfStudents = (ArrayList) in.readObject();
            in.close();
            if (!listOfStudents.isEmpty()) {
                System.out.println("There are Students in the Student list");
            }
        } catch (FileNotFoundException fne) {
            System.out.println("File was not found, a new one will be created");
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public void writeStudentListFile() {
        FileOutputStream fos = null;
        ObjectOutputStream out = null;
        try {
            fos = new FileOutputStream(listOfStudentsFileName);
            out = new ObjectOutputStream(fos);
            out.writeObject(listOfStudents);
            out.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void createTestStudentList() {
        for (int i = 0; i < 20; i++) {
            listOfStudents.add(new Student("Test Student " + i));
        }
        System.out.println("Test StudentList created");
        System.out.println("The StudentList is: " + listOfStudents.toString());
    }

    public void printStudentList() {
        for(Student s : this.listOfStudents) {
            System.out.println(s.toString());
        }
    }
}
