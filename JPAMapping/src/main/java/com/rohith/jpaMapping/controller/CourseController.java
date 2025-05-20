package com.rohith.jpaMapping.controller;

import com.rohith.jpaMapping.dto.CourseDTO;
import com.rohith.jpaMapping.model.Course;
import com.rohith.jpaMapping.service.CourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {
    private CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping("/course")
    public void setCourse(@RequestBody CourseDTO courseDTO) {
        courseService.createCourse(courseDTO.getName());
    }

    @GetMapping("/course/{courseId}")
    public Course getCourseById(@PathVariable Long courseId) {
        return courseService.getCourseById(courseId);
    }

    @GetMapping("/course")
    public List<Course> getAllCourses() {
        return courseService.getAllCourse();
    }
}
