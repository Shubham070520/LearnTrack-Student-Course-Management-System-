package com.airtribe.learntrack.service;

import java.util.ArrayList;

import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.util.IdGenerator;

public class CourseService {

    private ArrayList<Course> courses = new ArrayList<>();

    public void addCourse(String name, String desc, int weeks) {
        int id = IdGenerator.getNextCourseId();
        courses.add(new Course(id, name, desc, weeks));
    }

    public ArrayList<Course> listCourses() {
        return courses;
    }

    public Course findById(int id) {
        for(Course c : courses) {
            if(c.getId() == id)
                return c;
        }
        throw new EntityNotFoundException("Course not found");
    }
}
