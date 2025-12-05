package main.java.studentmgmt.model;

public class Person {
    private String name;
    private int age;
    private String id;

    public Person(String name, int age, String id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void printInfo() {
        System.out.println("Name: " + name + " Age: " + age + " ID: " + id);
    }
}
