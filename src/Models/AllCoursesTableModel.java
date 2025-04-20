package Models;

import Controllers.AllCoursesController;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class AllCoursesTableModel extends AbstractTableModel {
    private String[] columnNames = {"Name", "Course Code", "# Credits", "Summer Available", "Course Status"};
    private ArrayList<Course> courseList;

    public AllCoursesTableModel(ArrayList<Course> newCourseList) {
        this.courseList = newCourseList;
    }

    @Override
    public int getRowCount() {
        return courseList.size();
    }


    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return switch (columnIndex) {
            case 0 -> (Object) courseList.get(rowIndex).getName();
            case 1 -> (Object) courseList.get(rowIndex).getCourseCode();
            case 2 -> (Object) courseList.get(rowIndex).getNumCredits();
            case 3 -> (Object) courseList.get(rowIndex).getSummer();
            case 4 -> (Object) courseList.get(rowIndex).getCourseStatus();
            default -> null;
        };
    }

    @Override
    public String getColumnName(int col) {
        return columnNames[col];
    }
}
