package main.java.studentmgmt.manager;

import main.java.studentmgmt.model.*;
import main.java.studentmgmt.util.InputValidator;

public class UniversityManager {            //TODO: 깃허브 코밋
    private final int MAX_STUDENT = 100;
    private final int MAX_PROFESSOR = 100;
    private final int MAX_MAJOR = 100;
    private final int MAX_DEPARTMENT = 100;

    private int studentCount;
    private int professorCount;
    private int majorCount;
    private int departmentCount;

    Student[] students = new Student[MAX_STUDENT];
    Professor[] professors = new Professor[MAX_PROFESSOR];
    Major[] majors = new Major[MAX_MAJOR];
    Department[] departments = new Department[MAX_DEPARTMENT];

//    UniversityManager universityManager = new UniversityManager(); --> reason for StackOverFlow cyka

    public void registerDepartment(String departmentName, String departmentId) {
        if (!this.checkIfTheDepartmentRegistered(departmentName) && this.repeatDepartmentIdCheck(departmentId) && InputValidator.departmentIdValidator(departmentId)) {
            Department department = new Department(departmentName, departmentId);
            departments[departmentCount++] = department;
            System.out.println("Successfully Registered!");
        }
    }

    public void registerMajor(String majorName, String majorId, String majorProf, String profId) {
        if (this.professorCheckById(profId.toLowerCase().strip()) && InputValidator.majorIdValidator(majorId.toLowerCase().strip())) {
            for (int i = 0; i < majorCount; i++) {
                if (majorName.toLowerCase().strip().equals(majors[i].getMajorName())) {
                    System.out.println("Already Registered!");
                    return;
                }
            }
            Major major = new Major(majorName, majorId, majorProf);
            majors[majorCount++] = major;
            System.out.println("Successfully Registered!");
        }
    }

    public void addStudentToTheArray(String name, int age, String id, String major, double gpa, int credit) {
        if (InputValidator.studentIdValidator(id.toLowerCase().strip()) && InputValidator.gpaValidator(gpa) && this.repeatStudentIdCheck(id.toLowerCase().strip()) && this.checkIfTheMajorRegistered(major.toLowerCase().strip())) {
            Student student = new Student(name, age, id.toLowerCase().strip(), major, gpa, credit);
            students[studentCount++] = student;
            System.out.println("Successfully Registered!");
            return;
        }
        System.out.println("Something went wrong!");
    }

    public void addProfessorToTheArray(String name, int age, String id, String department, double salary) { // Register Professor as well;
        if (InputValidator.professorIdValidator(id.toLowerCase().strip()) && this.repeatProfessorIdCheck(id.toLowerCase().strip())) {
            Professor professor = new Professor(name, age, id.toLowerCase(), department.toLowerCase(), salary);
            professors[professorCount++] = professor;
            System.out.println("Successfully Registered!");
            return;
        }
        System.out.println("Something went wrong!");
    }

    public void updateStudentGpa(double newGpa, String studentId) {
        if (this.studentCheckById(studentId.toLowerCase().strip()) && InputValidator.gpaValidator(newGpa)) {
            for (int i = 0; i < studentCount; i++) {
                if (students[i].getId().equals(studentId)) {
                    students[i].gpaUpdate(newGpa);
                    System.out.println("Successfully Updated!");
                    return;
                }
            }
        }
        System.out.println("Not Found!");
    }

    public void changeStudentMajor(String studentId, String newMajor) {
        if (this.studentCheckById(studentId)) {
            for (int i = 0; i < studentCount; i++) {
                if (students[i].getId().equals(studentId)) {
                    if (this.checkIfTheMajorRegistered(newMajor)) {
                        students[i].changeMajor(newMajor.toLowerCase().strip());
                        System.out.println("Successfully Changed!");
                        return;
                    }
                }
            }
        }
        System.out.println("Not Found!");
    }

    public void printAllStudent() {
        if (studentCount > 0) {
            for (int i = 0; i < studentCount; i++) {
                students[i].printInfo();
            }
        } else {
            System.out.println("No Student Enrolled!");
        }
    }

    public void printAllProfessor() {
        if (professorCount > 0) {
            for (int i = 0; i < professorCount; i++) {
                professors[i].printInfo();
            }
        } else {
            System.out.println("No Professor Enrolled!");
        }
    }


    public boolean professorCheckById(String profId) {
        if (InputValidator.professorIdValidator(profId.toLowerCase().strip())) {
            for (int i = 0; i < professorCount; i++) {
                if (professors[i].getId().equals(profId.toLowerCase().strip())) {
                    return true;
                }
            }
            System.out.println("Not Found!");
            return false;
        }
        System.out.println("Invalid Professor ID!");
        return false;
    }

    public boolean studentCheckById(String studentId) {
        if (InputValidator.studentIdValidator(studentId.toLowerCase().strip())) {
            for (int i = 0; i < studentCount; i++) {
                if (students[i].getId().equals(studentId.toLowerCase().strip())) {
                    return true;
                }
            }
            System.out.println("Student Not Found!!");
            return false;
        }
        return false;
    }

    public void searchStudentByGpa(double inputGpa) {
        for (int i = 0; i < studentCount; i++) {
            if (students[i].getGpa() > inputGpa) {
                students[i].printInfo();
            }
        }
    }

    public void topGpaStudentFind() {
        if (studentCount > 0) {
            double tempGpa = 0;
            Student topStudent = null;

            for (int i = 0; i < studentCount; i++) {
                if (students[i].getGpa() > tempGpa) {
                    tempGpa = students[i].getGpa();
                    topStudent = students[i];
                }
            }

            System.out.println("Top Student: ");
            assert topStudent != null;
            topStudent.printInfo();
            return;
        }
        System.out.println("No Student Enrolled!");
    }

    public boolean repeatStudentIdCheck(String studentId) {
        for (int i = 0; i < studentCount; i++) {
            if (studentId.toLowerCase().strip().equals(students[i].getId())) {
                System.out.println("ID Already Registered!");
                return false;
            }
        }
        return true;
    }

    public boolean repeatProfessorIdCheck(String profId) {
        for (int i = 0; i < professorCount; i++) {
            if (professors[i].getId().equals(profId.toLowerCase().strip())) {
                System.out.println("ID Already Registered!");
                return false;
            }
        }
        return true;
    }

    public boolean checkIfTheMajorRegistered(String major) {
        for (int i = 0; i < majorCount; i++) {
            if (majors[i].getMajorName().toLowerCase().strip().equals(major.toLowerCase().strip())) {
                return true;
            }
        }
        System.out.println("Major Not Found!");
        return false;
    }

    public boolean checkIfTheDepartmentRegistered(String department) {
        for (int i = 0; i < departmentCount; i++) {
            if (departments[i].getDepartmentName().equals(department.toLowerCase().strip())) {
                return true;
            }
        }
        return false;
    }

    public boolean repeatDepartmentIdCheck(String departmentId) {
        for (int i = 0; i < departmentCount; i++) {
            if (departmentId.toLowerCase().strip().equals(departments[i].getDepartmentId())) {
                System.out.println("Already Registered!");
                return false;
            }
        }

        return true;
    }

    public void searchingStudentById(String studentId) {
        if (this.studentCheckById(studentId.toLowerCase().strip()) && studentCount > 0) {
            for (int i = 0; i < studentCount; i++) {
                if (students[i].getId().equals(studentId.toLowerCase().strip())) {
                    students[i].printInfo();
                    return;
                }
            }
            System.out.println("Not Found! ");
            return;
        }
        System.out.println("Wrong ID or No Student Enrolled!");
    }

    public void searchingStudentByName(String studentName) {
        if (studentCount > 0) {
            for (int i = 0; i < studentCount; i++) {
                if (students[i].getName().toLowerCase().strip().equals(studentName.strip().toLowerCase())) {
                    students[i].printInfo();
                }
            }
        } else {
            System.out.println("No Student Enrolled!");
        }
    }

    public void searchingProfessorById(String profId) {
        if (professorCount > 0 && InputValidator.professorIdValidator(profId.toLowerCase().strip())) {
            for (int i = 0; i < professorCount; i++) {
                if (professors[i].getId().toLowerCase().strip().equals(profId.toLowerCase().strip())) {
                    professors[i].printInfo();
                    return;
                }
            }
            System.out.println("Not Found!");
            return;
        }
        System.out.println("Wrong ID or No Professor Enrolled!");
    }

    public void searchingProfessorByName(String profName) {
        if (professorCount > 0) {
            for (int i = 0; i < professorCount; i++) {
                if (professors[i].getName().toLowerCase().strip().equals(profName.toLowerCase().strip())) {
                    professors[i].printInfo();
                }
            }
        } else {
            System.out.println("No Student Enrolled!");
        }
    }

    public void searchingProfessorDepartment(String department) {
        if (professorCount > 0 && departmentCount > 0) {
            for (int i = 0; i < professorCount; i++) {
                if (professors[i].getDepartment().toLowerCase().strip().equals(department.toLowerCase().strip())) {
                    professors[i].printInfo();
                    return;
                }
            }
            System.out.println("Not Found!");
            return;
        }
        System.out.println("No Department Enrolled!");
    }

    public void searchingProfessorByMajor(String major) {
        if (professorCount > 0 && majorCount > 0) {
            for (int i = 0; i < majorCount; i++) {
                if (majors[i].getMajorName().toLowerCase().strip().equals(major)) {
                    System.out.println(majors[i].toString());
                    return;
                }
            }
            System.out.println("Not Found!");
            return;
        }
        System.out.println("No Major Enrolled!");
    }

    public void searchingMajorById(String majorId) {
        if (majorCount > 0 && InputValidator.majorIdValidator(majorId.toLowerCase().strip())) {
            for (int i = 0; i < majorCount; i++) {
                if (majors[i].getMajorId().toLowerCase().strip().equals(majorId.toLowerCase().strip())) {
                    System.out.println(majors[i].toString());
                    return;
                }
            }
            System.out.println("Not Found!");
            return;
        }
        System.out.println("No Major Enrolled!");
    }

    public void searchingMajorByName(String name) {
        if (majorCount > 0) {
            for (int i = 0; i < majorCount; i++) {
                if (majors[i].getMajorName().toLowerCase().strip().equals(name.toLowerCase().strip())) {
                    System.out.println(majors[i].toString());
                    return;
                }
            }
            System.out.println("Not Found!");
            return;
        }
        System.out.println("No Major Enrolled!");
    }


    public void searchingDepartmentById(String departmentId) {
        if (departmentCount > 0 && InputValidator.departmentIdValidator(departmentId.toLowerCase().strip())) {
            for (int i = 0; i < departmentCount; i++) {
                if (departments[i].getDepartmentId().toLowerCase().strip().equals(departmentId.toLowerCase().strip())) {
                    System.out.println(departments[i].toString());
                    return;
                }
            }
            System.out.println("Not Found!");
            return;
        }
        System.out.println("No Major Enrolled!");
    }

    public void searchingDepartmentByName(String name) {
        if (departmentCount > 0) {
            for (int i = 0; i < departmentCount; i++) {
                if (departments[i].getDepartmentName().toLowerCase().strip().equals(name.toLowerCase().strip())) {
                    System.out.println(departments[i].toString());
                    return;
                }
            }
            System.out.println("Not Found!");
            return;
        }
        System.out.println("No Major Enrolled!");
    }


    public static void theBasicList() {
        System.out.println("1. Registration");
        System.out.println("2. Searching");
        System.out.println("3. etc.");
    }

    public static void theRegistrationList() {
        System.out.println("---- Registration ----");
        System.out.println("1. Student");
        System.out.println("2. Professor");
        System.out.println("3. Major");
        System.out.println("4. Department");
    }

    public static void theSearchingList() {
        System.out.println("---- Searching ----");
        System.out.println("1. Student");
        System.out.println("2. Professor");
        System.out.println("3. Major");
        System.out.println("4. Department");
    }

    public static void studentSearchingList() {
        System.out.println("--- Student Searching ---");
        System.out.println("1. ID");
        System.out.println("2. Name");
        System.out.println("3. GPA");
        System.out.println("4. Highest GPA");
        System.out.println("5. Print All Student");
    }

    public static void professorSearchingList() {
        System.out.println("--- Professor Searching ---");
        System.out.println("1. ID");
        System.out.println("2. Name");
        System.out.println("3. Department");
        System.out.println("4. Major");
        System.out.println("5. Print All Professor");
    }

    public static void majorSearchingList() {
        System.out.println("--- Major Searching ---");
        System.out.println("1. ID");
        System.out.println("2. Name");
    }


    public static void departmentSearchingList() {
        System.out.println("--- Department Searching ---");
        System.out.println("1. ID");
        System.out.println("2. Name");
    }

    public static void etcList() {
        System.out.println("--- ETC ---");
        System.out.println("1. Update Student GPA");
        System.out.println("2. Change Student Major");
    }

}