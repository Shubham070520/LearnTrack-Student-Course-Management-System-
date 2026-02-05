package com.airtribe.learntrack.entity;
import com.airtribe.learntrack.enums.EnrollmentStatus;

public class Enrollment {

    private int id;
    private int studentId;
    private int courseId;
    private String enrollmentDate;
    private EnrollmentStatus status;

    public Enrollment(int id, int studentId, int courseId, String date) {
        this.id = id;
        this.studentId = studentId;
        this.courseId = courseId;
        this.enrollmentDate = date;
        this.status = EnrollmentStatus.ACTIVE;
    }

    public int getStudentId() { return studentId; }
    public int getCourseId() { return courseId; }
    public EnrollmentStatus getStatus() { return status; }

    public void setStatus(EnrollmentStatus status) {
        this.status = status;
    }
}
