package com.airtribe.learntrack.service;

import java.util.ArrayList;

import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.repository.CourseRepository;
import com.airtribe.learntrack.util.IdGenerator;
import java.util.List;

public class CourseService {

    private CourseRepository repository = new CourseRepository();

    public void addCourse(String name, String description, int durationInWeeks) {
        int id = IdGenerator.getNextCourseId();
        Course course = new Course(id, name, description, durationInWeeks);
        repository.save(course);
    }

    public List<Course> getAllCourses() {
        return repository.findAll();
    }

    public Course findCourseById(int id) {
        Course course = repository.findById(id);
        if (course == null) {
            throw new EntityNotFoundException("Course not found with id: " + id);
        }
        return course;
    }

    public void toggleCourseActive(int id) {
        Course course = findCourseById(id);
        course.setActive(!course.isActive());
    }
}
