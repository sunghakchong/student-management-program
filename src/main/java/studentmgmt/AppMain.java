package main.java.studentmgmt;

import main.java.studentmgmt.manager.UniversityManager;

import java.util.Scanner;

public class AppMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UniversityManager universityManager = new UniversityManager();  //TODO: major change

        while (true) {
            UniversityManager.theBasicList();
            System.out.print("Enter(press 0 to end): ");
            int selectionFromUser = scanner.nextInt();
            scanner.nextLine();

            if (selectionFromUser == 1) {
                UniversityManager.theRegistrationList();

                System.out.print("Enter(press 0 to go back): ");
                int selectTwo = scanner.nextInt();
                scanner.nextLine();

                if (selectTwo == 1) {
                    System.out.print("Enter Student Name: ");
                    String studentName = scanner.nextLine().strip();

                    System.out.print("Enter Student Age: ");
                    int studentAge = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter Student ID: ");
                    String studentId = scanner.next();
                    scanner.nextLine();

                    System.out.print("Enter Student Major: ");
                    String studentMajor = scanner.nextLine().strip();

                    System.out.print("Enter Student GPA: ");
                    double studentGpa = scanner.nextDouble();
                    scanner.nextLine();

                    System.out.print("Enter Student Credit: ");
                    int studentCredit = scanner.nextInt();
                    scanner.nextLine();

                    universityManager.addStudentToTheArray(studentName, studentAge, studentId, studentMajor, studentGpa, studentCredit);
                } else if (selectTwo == 0) {
                    continue;
                } else if (selectTwo == 2) {
                    System.out.print("Enter Professor Name: ");
                    String profName = scanner.nextLine().strip();

                    System.out.print("Enter Professor Age: ");
                    int profAge = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter Professor ID: ");
                    String profId = scanner.next();
                    scanner.nextLine();

                    System.out.print("Enter Department: ");
                    String department = scanner.nextLine().strip();

                    System.out.print("Enter Professor Salary: ");
                    double profSalary = scanner.nextDouble();
                    scanner.nextLine();

                    universityManager.addProfessorToTheArray(profName, profAge, profId, department, profSalary);
                } else if (selectTwo == 3) {
                    System.out.print("Enter Major Name: ");
                    String majorName = scanner.nextLine().strip();

                    System.out.print("Enter Major ID: ");
                    String majorId = scanner.next();
                    scanner.nextLine();

                    System.out.print("Enter Professor Name: ");
                    String profName = scanner.next();
                    scanner.nextLine();

                    System.out.print("Enter Professor ID: ");
                    String profId = scanner.next();
                    scanner.nextLine();

                    universityManager.registerMajor(majorName, majorId, profName, profId);
                } else if (selectTwo == 4) {
                    System.out.print("Enter Department Name: ");
                    String departmentName = scanner.nextLine().strip();

                    System.out.print("Enter Department ID: ");
                    String departmentId = scanner.next();
                    scanner.nextLine();

                    universityManager.registerDepartment(departmentName, departmentId);
                }
            } else if (selectionFromUser == 0) {
                return;
            } else if (selectionFromUser == 2) {
                UniversityManager.theSearchingList();

                System.out.print("Enter(press 0 to go back): ");
                int selectThree = scanner.nextInt();
                scanner.nextLine();

                if (selectThree == 0) {
                    continue;
                } else if (selectThree == 1) {
                    UniversityManager.studentSearchingList();

                    System.out.print("Enter(press 0 to go back): ");
                    int selectThreeToOne = scanner.nextInt();
                    scanner.nextLine();

                    if (selectThreeToOne == 0) {
                        continue;
                    } else if (selectThreeToOne == 1) {
                        System.out.print("Enter Student ID: ");
                        String studentId = scanner.next();
                        scanner.nextLine();

                        universityManager.searchingStudentById(studentId.toLowerCase().strip());
                    } else if (selectThreeToOne == 2) {
                        System.out.print("Enter Student Name: ");
                        String studentName = scanner.next();
                        scanner.nextLine();

                        universityManager.searchingStudentByName(studentName);
                    } else if (selectThreeToOne == 3) {
                        System.out.print("Enter Student GPA: ");
                        double studentGpa = scanner.nextDouble();
                        scanner.nextLine();

                        universityManager.searchStudentByGpa(studentGpa);
                    } else if (selectThreeToOne == 4) {
                        universityManager.topGpaStudentFind();
                    } else if (selectThreeToOne == 5) {
                        universityManager.printAllStudent();
                    } else {
                        System.out.println("Wrong Number!");
                    }
                } else if (selectThree == 2) {
                    UniversityManager.professorSearchingList();

                    System.out.print("Enter(press 0 to go back): ");
                    int selectThreeToTwo = scanner.nextInt();
                    scanner.nextLine();

                    if (selectThreeToTwo == 0) {
                        continue;
                    } else if (selectThreeToTwo == 1) {
                        System.out.print("Enter Professor ID: ");
                        String profId = scanner.next();
                        scanner.nextLine();

                        universityManager.searchingProfessorById(profId);
                    } else if (selectThreeToTwo == 2) {
                        System.out.print("Enter Professor Name: ");
                        String profName = scanner.next();
                        scanner.nextLine();

                        universityManager.searchingProfessorByName(profName);
                    } else if (selectThreeToTwo == 3) {
                        System.out.print("Enter Department Name: ");
                        String department = scanner.nextLine().strip();

                        universityManager.searchingProfessorDepartment(department);
                    } else if (selectThreeToTwo == 4) {
                        System.out.print("Enter Major Name: ");
                        String major = scanner.nextLine().strip();

                        universityManager.searchingProfessorByMajor(major);
                    } else if (selectThreeToTwo == 5) {
                        universityManager.printAllProfessor();
                    } else {
                        System.out.println("Wrong Number!");
                    }
                } else if (selectThree == 3) {
                    UniversityManager.majorSearchingList();

                    System.out.print("Enter(press 0 to go back): ");
                    int selectThreeToThree = scanner.nextInt();
                    scanner.nextLine();

                    if (selectThreeToThree == 1) {
                        System.out.print("Enter Major ID: ");
                        String majorId = scanner.next();
                        scanner.nextLine();

                        universityManager.searchingMajorById(majorId);
                    } else if (selectThreeToThree == 2) {
                        System.out.print("Enter Major Name: ");
                        String majorName = scanner.next();
                        scanner.nextLine();

                        universityManager.searchingMajorByName(majorName);
                    } else if (selectThreeToThree == 0) {
                        continue;
                    } else {
                        System.out.println("Wrong Number!");
                    }
                } else if (selectThree == 4) {
                    UniversityManager.departmentSearchingList();

                    System.out.print("Enter(press 0 to go back): ");
                    int selectThreeToFive = scanner.nextInt();
                    scanner.nextLine();

                    if (selectThreeToFive == 0) {
                        continue;
                    } else if (selectThreeToFive == 1) {
                        System.out.print("Enter Department ID: ");
                        String departmentId = scanner.nextLine().strip();

                        universityManager.searchingDepartmentById(departmentId);
                    } else if (selectThreeToFive == 2) {
                        System.out.print("Enter Department Name: ");
                        String departmentName = scanner.nextLine().strip();

                        universityManager.searchingDepartmentByName(departmentName);
                    }
                } else {
                    continue;
                }
            } else if (selectionFromUser == 3) {
                UniversityManager.etcList();

                System.out.print("Enter(press 0 to go back): ");
                int selectFour = scanner.nextInt();
                scanner.nextLine();

                if (selectFour == 0) {
                    continue;
                } else if (selectFour == 1) {
                    System.out.print("Enter New GPA: ");
                    double newGpa = scanner.nextDouble();
                    scanner.nextLine();

                    System.out.print("Enter Student ID: ");
                    String studentId = scanner.next();
                    scanner.nextLine();

                    universityManager.updateStudentGpa(newGpa, studentId);
                } else if (selectFour == 2) {
                    System.out.print("Enter Student ID: ");
                    String studentId = scanner.next();
                    scanner.nextLine();

                    System.out.print("Enter New Major: ");
                    String newMajor = scanner.nextLine().strip();

                    universityManager.changeStudentMajor(studentId, newMajor);
                } else {
                    System.out.println("Wrong Number!");
                }
            }
        }
    }
}
