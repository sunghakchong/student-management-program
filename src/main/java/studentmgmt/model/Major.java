package main.java.studentmgmt.model;

public class Major {
    private String majorName;
    private String majorId;
    private String majorProf;

    public Major(String majorName, String majorId, String majorProf) {
        this.majorName = majorName;
        this.majorId = majorId;
        this.majorProf = majorProf;
    }

    public String getMajorName() {
        return majorName;
    }

    public String getMajorId() {
        return majorId;
    }

    @Override
    public String toString() {
        return "Major Name: " + majorName + " Major ID: " + majorId + " Major Professor: " + majorProf;
    }
}
