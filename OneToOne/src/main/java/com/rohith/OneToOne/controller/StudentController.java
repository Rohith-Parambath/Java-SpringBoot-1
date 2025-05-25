package com.rohith.OneToOne.controller;

import com.rohith.OneToOne.dto.StudentCreationDTO;
import com.rohith.OneToOne.dto.StudentResponseDTO;
import com.rohith.OneToOne.model.Student;
import com.rohith.OneToOne.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService service;

    @PostMapping
    public Student createStudent(@RequestBody StudentCreationDTO dto) {
        return service.createStudent(dto);
    }

    @GetMapping("/{id}")
    public StudentResponseDTO getStudentById(@PathVariable Long id) {
        return service.getStudentById(id);
    }
}
