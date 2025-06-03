package com.educa.backend.dto.student;

import com.educa.backend.domain.model.Student;

public class StudentMapper {
    public static StudentDTO toDto(Student student) {
        return StudentDTO.builder()
                .id(student.getId())
                .userId(student.getUser().getId())
                .fullName(student.getFullName())
                .birthDate(student.getBirthDate())
                .gender(student.getGender())
                .ethnicity(student.getEthnicity())
                .avatar(student.getAvatar())
                .kolbLearningStyle(student.getKolbLearningStyle())
                .felderStyle(student.getFelderStyle())
                .careerPreferences(student.getCareerPreferences())
                .academicPerformance(student.getAcademicPerformance())
                .build();
    }
}
