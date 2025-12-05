package main.java.studentmgmt.model;

public class Department {
    private String departmentName;
    private String departmentId;

    public Department(String departmentName, String departmentId) {
        this.departmentName = departmentName;
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    @Override
    public String toString() {
        return "Department Name: " + departmentName + " Department ID: " + departmentId;
    }
}
