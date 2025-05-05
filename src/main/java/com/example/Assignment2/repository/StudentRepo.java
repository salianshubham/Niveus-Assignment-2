package com.example.Assignment2.repository;

import com.example.Assignment2.model.StudentModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<StudentModel,Integer> {
}
