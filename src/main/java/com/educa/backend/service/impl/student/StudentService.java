package com.educa.backend.service.impl.student.StudentService;

package com.educa.backend.service.impl;

import com.educa.backend.domain.model.Student;
import java.util.List;

public interface StudentService {
    Student createStudent(Student student);
    Student getStudent(Long id);
    List<Student> getAllStudents();
    Student updateStudent(Long id, Student student);
    void deleteStudent(Long id);
}
