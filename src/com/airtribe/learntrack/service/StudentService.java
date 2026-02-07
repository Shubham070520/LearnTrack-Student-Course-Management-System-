package com.airtribe.learntrack.service;
import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.util.IdGenerator;
import com.airtribe.learntrack.repository.StudentRepository;

import java.util.List;

public class StudentService {

    private StudentRepository repository = new StudentRepository();

    public void addStudent(String firstName, String lastName, String email, String batch) {
        Student student = new Student(
                IdGenerator.getNextStudentId(),
                firstName,
                lastName,
                email,
                batch
        );
        repository.save(student);
    }

    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    public Student findStudentById(int id) {
        Student student = repository.findById(id);
        if (student == null) {
            throw new EntityNotFoundException("Student not found with id: " + id);
        }
        return student;
    }
}