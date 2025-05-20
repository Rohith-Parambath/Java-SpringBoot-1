package com.rohith.jpaMapping.controller;

import com.rohith.jpaMapping.dto.StudentDTO;
import com.rohith.jpaMapping.model.Student;
import com.rohith.jpaMapping.service.StudentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {
    private StudentService studentService;


    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/student")
    public void registerStudent(@RequestBody StudentDTO request) {
        studentService.registerStudentWithCourses(request.getStudentName(), request.getCourseIds());
    }

    @GetMapping("/student")
    public List<Student> getStudents() {
        return studentService.getAllStudents();
    }
}
