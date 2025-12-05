package main.java.studentmgmt.model;

public class Student extends Person {
    private String major;
    private double gpa;
    private int credit;

    public Student(String name, int age, String id, String major, double gpa, int credit) {
        super(name, age, id);
        this.major = major;
        this.gpa = gpa;
        this.credit = credit;
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println(" - Major: " + major);
        System.out.println(" - GPA: " + gpa);
        System.out.println(" - Credit: " + credit);
    }

    public void gpaUpdate(double newGpa) {
        this.gpa = newGpa;
    }

    public double getGpa() {
        return gpa;
    }

    public void changeMajor(String newMajor) {
        this.major = newMajor;
    }
}
