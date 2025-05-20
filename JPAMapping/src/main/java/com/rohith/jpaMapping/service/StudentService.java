package com.rohith.jpaMapping.service;

import com.rohith.jpaMapping.model.Course;
import com.rohith.jpaMapping.model.Enrollment;
import com.rohith.jpaMapping.model.Student;
import com.rohith.jpaMapping.repository.CourseRepo;
import com.rohith.jpaMapping.repository.EnrollmentRepo;
import com.rohith.jpaMapping.repository.StudentRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    private StudentRepo studentRepo;
    private CourseRepo courseRepo;
    private EnrollmentRepo enrollmentRepo;

    public StudentService(StudentRepo studentRepo, CourseRepo courseRepo, EnrollmentRepo enrollmentRepo) {
        this.studentRepo = studentRepo;
        this.courseRepo = courseRepo;
        this.enrollmentRepo = enrollmentRepo;
    }

    public Student registerStudentWithCourses(String studentName, List<Long> coursesId) {
        Student student = new Student();
        student.setName(studentName);

        List<Enrollment> enrollments = new ArrayList<>();

        for (Long courseId : coursesId) {
            Course course = courseRepo.findById(courseId)
                    .orElseThrow(() -> new RuntimeException("Course not found" + courseId));

            Enrollment enrollment = new Enrollment();
            enrollment.setStudent(student);
            enrollment.setCourse(course);
            enrollment.setEnrolled_date(LocalDate.now());

            enrollments.add(enrollment);
        }

        student.setEnrollment(enrollments);

        return studentRepo.save(student);

    }

    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }


}
