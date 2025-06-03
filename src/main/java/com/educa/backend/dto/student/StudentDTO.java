package com.educa.backend.dto.student;

import com.educa.backend.domain.model.FelderSilvermanStyle;
import com.educa.backend.domain.model.AcademicPerformance;
import com.educa.backend.domain.model.Gender;
import com.educa.backend.domain.model.KolbStyle;
import lombok.*;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentDTO {
    private Long id;
    private Long userId;
    private String fullName;
    private LocalDate birthDate;
    private Gender gender;
    private String ethnicity;
    private String avatar;
    private KolbStyle kolbLearningStyle;
    private FelderSilvermanStyle felderStyle;
    private List<String> careerPreferences;
    private AcademicPerformance academicPerformance;
}
