package com.rohith.OneToOne.repository;

import com.rohith.OneToOne.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {
    public Student findByRollNo(String rollNo);
}
