package com.educa.backend.service.impl;

import com.educa.backend.domain.model.Student;
import com.educa.backend.domain.repository.StudentRepository;
import com.educa.backend.service.StudentService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Optional<Student> getStudent(Long id) {
        return studentRepository.findById(id);
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
            existing.setEthnicity(student.getEthnicity());
            existing.setAvatar(student.getAvatar());
            existing.setKolbLearningStyle(student.getKolbLearningStyle());
            existing.setFelderStyle(student.getFelderStyle());
            existing.setAcademicPerformance(student.getAcademicPerformance());
            existing.setCareerPreferences(student.getCareerPreferences());
            return studentRepository.save(existing);
        }).orElseThrow(() -> new EntityNotFoundException("Student not found with id: " + id));
    }

    @Override
    public void deleteStudent(Long id) {
        if (!studentRepository.existsById(id)) {
            throw new EntityNotFoundException("Student not found with id: " + id);
        }
        studentRepository.deleteById(id);
    }
}
