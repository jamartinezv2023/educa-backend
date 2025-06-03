package com.educa.backend.domain.repository;

import com.educa.backend.domain.model.Student;
import com.educa.backend.domain.model.KolbStyle;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByKolbLearningStyle(KolbStyle style);
}
