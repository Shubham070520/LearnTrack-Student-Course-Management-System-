package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Enrollment;
import com.airtribe.learntrack.enums.EnrollmentStatus;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.util.IdGenerator;

import java.util.ArrayList;
import java.util.List;

public class EnrollmentService {

    private List<Enrollment> enrollments = new ArrayList<>();

    // Enroll student into course
    public void enrollStudent(int studentId, int courseId) {
        int id = IdGenerator.getNextEnrollmentId();
        Enrollment enrollment = new Enrollment(
                id,
                studentId,
                courseId,
                "2026-02-04"
        );
        enrollments.add(enrollment);
        System.out.println("Student enrolled successfully.");
    }

    // Get all enrollments of a student
    public List<Enrollment> getEnrollmentsByStudentId(int studentId) {
        List<Enrollment> result = new ArrayList<>();

        for (Enrollment e : enrollments) {
            if (e.getStudentId() == studentId) {
                result.add(e);
            }
        }

        if (result.isEmpty()) {
            throw new EntityNotFoundException("No enrollments found for student id: " + studentId);
        }

        return result;
    }

    // Mark enrollment as COMPLETED
    public void markCompleted(int enrollmentId) {
        Enrollment enrollment = findById(enrollmentId);
        enrollment.setStatus(EnrollmentStatus.COMPLETED);
        System.out.println("Enrollment marked as COMPLETED.");
    }

    // Mark enrollment as CANCELLED
    public void markCancelled(int enrollmentId) {
        Enrollment enrollment = findById(enrollmentId);
        enrollment.setStatus(EnrollmentStatus.CANCELLED);
        System.out.println("Enrollment marked as CANCELLED.");
    }

    // Find enrollment by id
    private Enrollment findById(int id) {
        for (Enrollment e : enrollments) {
            if (e.getId() == id) {
                return e;
            }
        }
        throw new EntityNotFoundException("Enrollment not found with id: " + id);
    }
}
