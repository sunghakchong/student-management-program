package main.java.studentmgmt.util;

public class InputValidator {

    public static boolean studentIdValidator(String studentId) {
        if (studentId.length() != 8) {
            System.out.println("Student ID should be 8 long");
            return false;
        }

        if (!studentId.startsWith("z")) {
            System.out.println("Student ID should begin with 'z'");
            return false;
        }

        for (int i = 1; i < studentId.length(); i++) {
            if (!Character.isDigit(studentId.charAt(i))) {
                System.out.println("Student ID contains 1 character and 7 digit!");
                return false;
            }
        }
        return true;
    }

    public static boolean professorIdValidator(String profId) {
        if (profId.length() != 5) {
            System.out.println("Professor ID should be 5 long");
            return false;
        }

        if (!profId.startsWith("y")) {
            System.out.println("Professor ID should begin with 'y'!");
            return false;
        }

        for (int i = 1; i < profId.length(); i++) {
            if (!Character.isDigit(profId.charAt(i))) {
                System.out.println("Professor ID contains 1 character and 4 digit!");
                return false;
            }
        }

        return true;
    }

    public static boolean gpaValidator(double gpaInput) {
        if (gpaInput > 0.0 && gpaInput <= 4.0) {
            return true;
        }
        System.out.println("Invalid GPA score!");
        return false;
    }

    public static boolean majorIdValidator(String id) {
        if (id.length() != 4) {
            System.out.println("Major ID should be 4 long");
            return false;
        }

        if (!id.startsWith("m")) {
            System.out.println("Major ID should begin with 'm");
            return false;
        }

        for (int i = 1; i < id.length(); i++) {
            if (!Character.isDigit(id.charAt(i))) {
                System.out.println("Major ID contains 1 character and 3 digit!");
                return false;
            }
        }
        return true;
    }

    public static boolean courseIdValidator(String id) {
        if (id.length() != 4) {
            System.out.println("Course ID should be 4 long");
            return false;
        }

        if (!id.startsWith("x")) {
            System.out.println("Course ID should begin with 'x'");
            return false;
        }

        for (int i = 1; i < id.length(); i++) {
            if (!Character.isDigit(id.charAt(i))) {
                System.out.println("Course ID contains 1 character and 3 digit!");
                return false;
            }
        }
        return true;
    }

    public static boolean departmentIdValidator(String id) {
        if (id.length() != 3) {
            System.out.println("Department ID should be 3 long!");
            return false;
        }

        if (!id.startsWith("d")) {
            System.out.println("Department ID should begin with 'd'");
            return false;
        }

        for (int i = 1; i < id.length(); i++) {
            if (!Character.isDigit(id.charAt(i))) {
                System.out.println("Department ID contains 1 character and 2 digit!");
                return false;
            }
        }

        return true;
    }
}

