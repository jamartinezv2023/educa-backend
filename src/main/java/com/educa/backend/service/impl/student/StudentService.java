package com.educa.backend.service;

import com.educa.backend.domain.model.Student;
import java.util.List;
import java.util.Optional;

public interface StudentService {
    Student createStudent(Student student);
    Optional<Student> getStudent(Long id);  // Optional para manejo seguro
    List<Student> getAllStudents();
    Student updateStudent(Long id, Student student);
    void deleteStudent(Long id);
}

