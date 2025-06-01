package com.educa.backend.service.impl.student.StudentServiceImpl;

package com.educa.backend.service.impl;

import com.educa.backend.domain.model.Student;
import com.educa.backend.domain.repository.StudentRepository;
import com.educa.backend.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student getStudent(Long id) {
        return studentRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student updateStudent(Long id, Student student) {
        return studentRepository.findById(id).map(existing -> {
            existing.setFullName(student.getFullName());
            existing.setBirthDate(student.getBirthDate());
            existing.setGender(student.getGender());
            existing.setKolbLearningStyle(student.getKolbLearningStyle());
            existing.setFelderStyle(student.getFelderStyle());
            existing.setAcademicPerformance(student.getAcademicPerformance());
            return studentRepository.save(existing);
        }).orElseThrow();
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}