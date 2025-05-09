//package com.example.Assignment2.services;
//
//import com.example.Assignment2.model.StudentModel;
//import com.example.Assignment2.repository.StudentRepo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//@Service
//public class StudentService {
//
//    @Autowired
//    StudentRepo studentRepo;
//
//    public StudentModel saveStudent(StudentModel studentModel){
//        return studentRepo.save(studentModel);
//    }
//
//    // Update
//    public StudentModel updateStudent(StudentModel studentModel){
//        return studentRepo.save(studentModel); // `save()` works for both insert and update if ID exists
//    }
//
//    // Get by ID
//    public Optional<StudentModel> getStudentById(int id){
//        return studentRepo.findById(id);
//    }
//
//
//    public void deleteStudent(int id) {
//        studentRepo.deleteById(id);
//    }
//}

package com.example.Assignment2.services;

import com.example.Assignment2.model.StudentModel;
import com.example.Assignment2.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRepo studentRepo;

    public StudentModel saveStudent(StudentModel studentModel){
        return studentRepo.saveStudent(studentModel.getName(), studentModel.getAge(), studentModel.getEmail());
    }

    public StudentModel updateStudent(StudentModel studentModel){
        return studentRepo.updateStudent(studentModel.getId(), studentModel.getName(), studentModel.getAge(), studentModel.getEmail());
    }

    public Optional<StudentModel> getStudentById(int id){
        return Optional.ofNullable(studentRepo.findStudentById(id));
    }

    public void deleteStudent(int id) {
        studentRepo.deleteStudentById(id);
    }
}
