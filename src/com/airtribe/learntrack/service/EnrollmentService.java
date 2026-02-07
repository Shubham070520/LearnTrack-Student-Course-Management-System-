package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Enrollment;
import com.airtribe.learntrack.enums.EnrollmentStatus;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.repository.EnrollmentRepository;
import com.airtribe.learntrack.util.IdGenerator;

import java.util.ArrayList;
import java.util.List;

public class EnrollmentService {

    private EnrollmentRepository repository = new EnrollmentRepository();

    public void enrollStudent(int studentId, int courseId) {
        int id = IdGenerator.getNextEnrollmentId();
        Enrollment enrollment = new Enrollment(id, studentId, courseId, "2026-02-07");
        repository.save(enrollment);
    }

    public List<Enrollment> getEnrollmentsByStudentId(int studentId) {
        List<Enrollment> result = new ArrayList<>();

        for (Enrollment e : repository.findAll()) {
            if (e.getStudentId() == studentId) {
                result.add(e);
            }
        }

        if (result.isEmpty()) {
            throw new EntityNotFoundException(
                    "No enrollments found for student id: " + studentId
            );
        }

        return result;
    }

    public void markCompleted(int enrollmentId) {
        Enrollment enrollment = findById(enrollmentId);
        enrollment.setStatus(EnrollmentStatus.COMPLETED);
    }

    public void markCancelled(int enrollmentId) {
        Enrollment enrollment = findById(enrollmentId);
        enrollment.setStatus(EnrollmentStatus.CANCELLED);
    }

    private Enrollment findById(int id) {
        Enrollment enrollment = repository.findById(id);
        if (enrollment == null) {
            throw new EntityNotFoundException("Enrollment not found with id: " + id);
        }
        return enrollment;
    }
}
