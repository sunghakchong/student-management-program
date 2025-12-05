package main.java.studentmgmt.model;

public class Professor extends Person {
    private String department;
    private double salary;

    public Professor(String name, int age, String id, String department, double salary) {
        super(name, age, id);
        this.department = department;
        this.salary = salary;
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println(" - Department: " + department);
        System.out.println(" - Salary: " + salary);
    }

    public String getDepartment() {
        return department;
    }
}
