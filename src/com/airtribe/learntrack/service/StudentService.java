package com.airtribe.learntrack.service;
import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.util.IdGenerator;
import java.util.ArrayList;

public class StudentService {

    private ArrayList<Student> students = new ArrayList<>();

    public void addStudent(String fn, String ln, String batch) {
        int id = IdGenerator.getNextStudentId();
        students.add(new Student(id, fn, ln, batch));
    }

    // Overloaded
    public void addStudent(String fn, String ln, String email, String batch) {
        int id = IdGenerator.getNextStudentId();
        students.add(new Student(id, fn, ln, email, batch));
    }

    public ArrayList<Student> listStudents() {
        return students;
    }

    public Student findById(int id) {
        for(Student s : students) {
            if(s.getId() == id)
                return s;
        }
        throw new EntityNotFoundException("Student not found");
    }

    public void deactivateStudent(int id) {
        Student s = findById(id);
        s.setActive(false);
    }
}
