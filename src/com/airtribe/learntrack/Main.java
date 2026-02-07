package com.airtribe.learntrack;

import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.entity.Enrollment;
import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.service.CourseService;
import com.airtribe.learntrack.service.EnrollmentService;
import com.airtribe.learntrack.service.StudentService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        StudentService studentService = new StudentService();
        CourseService courseService = new CourseService();
        EnrollmentService enrollmentService = new EnrollmentService();

        while (true) {

            System.out.println("\n====== LearnTrack Menu ======");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Deactivate Student");
            System.out.println("5. Add Course");
            System.out.println("6. View All Courses");
            System.out.println("7. Activate / Deactivate Course");
            System.out.println("8. Enroll Student in Course");
            System.out.println("9. View Enrollments by Student");
            System.out.println("10. Mark Enrollment as Completed");
            System.out.println("11. Mark Enrollment as Cancelled");
            System.out.println("0. Exit");
            System.out.print("Choose option: ");

            try {
                int choice = Integer.parseInt(sc.nextLine());

                if (choice < 0 || choice > 11) {
                    System.out.println("Invalid menu option.");
                    continue;
                }

                switch (choice) {

                    case 1 -> {
                        System.out.print("First Name: ");
                        String fn = sc.nextLine().trim();

                        System.out.print("Last Name: ");
                        String ln = sc.nextLine().trim();

                        System.out.print("Email: ");
                        String email = sc.nextLine().trim();

                        System.out.print("Batch: ");
                        String batch = sc.nextLine().trim();

                        if (fn.isEmpty() || ln.isEmpty()) {
                            System.out.println("First name and last name cannot be empty.");
                            continue;
                        }

                        studentService.addStudent(fn, ln, email, batch);
                        System.out.println("Student added successfully.");
                    }

                    case 2 -> {
                        for (Student s : studentService.getAllStudents()) {
                            System.out.println(
                                    s.getId() + " | " +
                                            s.getDisplayName() +
                                            " | Active: " + s.isActive()
                            );
                        }
                    }

                    case 3 -> {
                        System.out.print("Student ID: ");
                        int id = Integer.parseInt(sc.nextLine());

                        if (id <= 0) {
                            System.out.println("Invalid student ID.");
                            continue;
                        }

                        Student s = studentService.findStudentById(id);
                        System.out.println(
                                s.getId() + " | " +
                                        s.getDisplayName() +
                                        " | Active: " + s.isActive()
                        );
                    }

                    case 4 -> {
                        System.out.print("Student ID: ");
                        int id = Integer.parseInt(sc.nextLine());

                        studentService.deactivateStudent(id);
                        System.out.println("Student deactivated.");
                    }

                    case 5 -> {
                        System.out.print("Course Name: ");
                        String name = sc.nextLine().trim();

                        System.out.print("Description: ");
                        String desc = sc.nextLine().trim();

                        System.out.print("Duration (weeks): ");
                        int duration = Integer.parseInt(sc.nextLine());

                        if (name.isEmpty() || duration <= 0) {
                            System.out.println("Invalid course details.");
                            continue;
                        }

                        courseService.addCourse(name, desc, duration);
                        System.out.println("Course added successfully.");
                    }

                    case 6 -> {
                        for (Course c : courseService.getAllCourses()) {
                            System.out.println(
                                    c.getId() + " | " +
                                            c.getCourseName() +
                                            " | Active: " + c.isActive()
                            );
                        }
                    }

                    case 7 -> {
                        System.out.print("Course ID: ");
                        int id = Integer.parseInt(sc.nextLine());

                        courseService.toggleCourseActive(id);
                        System.out.println("Course status updated.");
                    }

                    case 8 -> {
                        System.out.print("Student ID: ");
                        int studentId = Integer.parseInt(sc.nextLine());

                        System.out.print("Course ID: ");
                        int courseId = Integer.parseInt(sc.nextLine());

                        enrollmentService.enrollStudent(studentId, courseId);
                        System.out.println("Enrollment successful.");
                    }

                    case 9 -> {
                        System.out.print("Student ID: ");
                        int studentId = Integer.parseInt(sc.nextLine());

                        for (Enrollment e :
                                enrollmentService.getEnrollmentsByStudentId(studentId)) {
                            System.out.println(
                                    "Enrollment ID: " + e.getId() +
                                            " | Course ID: " + e.getCourseId() +
                                            " | Status: " + e.getStatus()
                            );
                        }
                    }

                    case 10 -> {
                        System.out.print("Enrollment ID: ");
                        int id = Integer.parseInt(sc.nextLine());

                        enrollmentService.markCompleted(id);
                        System.out.println("Enrollment marked as COMPLETED.");
                    }

                    case 11 -> {
                        System.out.print("Enrollment ID: ");
                        int id = Integer.parseInt(sc.nextLine());

                        enrollmentService.markCancelled(id);
                        System.out.println("Enrollment marked as CANCELLED.");
                    }

                    case 0 -> {
                        System.out.println("Exiting LearnTrack.");
                        return;
                    }
                }

            } catch (EntityNotFoundException e) {
                System.out.println(e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Please enter valid numeric input.");
            } catch (Exception e) {
                System.out.println("Something went wrong.");
            }
        }
    }
}
