package com.rohith.OneToOne.repository;

import com.rohith.OneToOne.model.StudentId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentIdRepo extends JpaRepository<StudentId, Long> {
}
