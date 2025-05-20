package com.rohith.jpaMapping.service;

import com.rohith.jpaMapping.model.Course;
import com.rohith.jpaMapping.repository.CourseRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    private CourseRepo courseRepo;

    public CourseService(CourseRepo courseRepo) {
        this.courseRepo = courseRepo;
    }

    public void createCourse(String courseName) {
        Course course = new Course();
        course.setName(courseName);

        courseRepo.save(course);
    }

    public Course getCourseById(Long courseID) {
        return courseRepo.findById(courseID).orElse(new Course());
    }

    public List<Course> getAllCourse() {
        return courseRepo.findAll();
    }
}
