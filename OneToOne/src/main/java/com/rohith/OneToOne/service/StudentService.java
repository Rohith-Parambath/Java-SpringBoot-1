package com.rohith.OneToOne.service;

import com.rohith.OneToOne.dto.StudentCreationDTO;
import com.rohith.OneToOne.dto.StudentIdCreationDTO;
import com.rohith.OneToOne.dto.StudentIdResponseDTO;
import com.rohith.OneToOne.dto.StudentResponseDTO;
import com.rohith.OneToOne.model.Student;
import com.rohith.OneToOne.model.StudentId;
import com.rohith.OneToOne.repository.StudentIdRepo;
import com.rohith.OneToOne.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    private StudentRepo studentRepo;
    @Autowired
    private StudentIdRepo studentIdRepo;

    public Student createStudent(StudentCreationDTO std) {
        Student student = new Student();
        student.setRollNo(std.getRollNo());
        student.setCreationDate(std.getCreationDate());

        StudentIdCreationDTO studentIdCreationDTO = std.getStudentId();
        StudentId studentId = new StudentId();
        studentId.setName(studentIdCreationDTO.getName());
        studentId.setDob(studentIdCreationDTO.getDob());
        studentId.setBloodGroup(studentIdCreationDTO.getBloodGroup());
        studentId.setAddress(studentIdCreationDTO.getAddress());

        studentId.setStudent(student);
        student.setStudentId(studentId);

        return studentRepo.save(student);

    }

    public StudentResponseDTO getStudentById(Long id){
        Student student = studentRepo.findById(id).orElseThrow(() -> new RuntimeException("No Student found"));
        StudentResponseDTO studentResponseDTO = new StudentResponseDTO();
        studentResponseDTO.setRollno(student.getRollNo());
        studentResponseDTO.setCreationDate(student.getCreationDate());

        StudentIdResponseDTO studentIdResponseDTO =new StudentIdResponseDTO();
        studentIdResponseDTO.setName(student.getStudentId().getName());
        studentIdResponseDTO.setDob(student.getStudentId().getDob());
        studentIdResponseDTO.setBloodGroup(student.getStudentId().getBloodGroup());
        studentIdResponseDTO.setAddress(student.getStudentId().getAddress());

        studentResponseDTO.setStudentIdResponseDTO(studentIdResponseDTO);

        return studentResponseDTO;
    }
}
