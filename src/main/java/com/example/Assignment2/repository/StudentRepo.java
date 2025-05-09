package com.example.Assignment2.repository;

import com.example.Assignment2.model.StudentModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepo extends CrudRepository<StudentModel, Integer> {

    @Query(value = "INSERT INTO student_model (name, age, email) VALUES (:name, :age, :email) RETURNING *", nativeQuery = true)
    StudentModel saveStudent(@Param("name") String name, @Param("age") Integer age, @Param("email") String email);

    @Query("SELECT s FROM StudentModel s WHERE s.id = :id")
    StudentModel findStudentById(@Param("id") int id);

    @Query(value = "UPDATE student_model SET name = :name, age = :age, email = :email WHERE id = :id RETURNING *", nativeQuery = true)
    StudentModel updateStudent(@Param("id") int id, @Param("name") String name, @Param("age") Integer age, @Param("email") String email);

    @Query(value = "DELETE FROM student_model WHERE id = :id", nativeQuery = true)
    void deleteStudentById(@Param("id") int id);
}
