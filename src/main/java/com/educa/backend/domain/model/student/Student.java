package com.educa.backend.domain.model;

import com.educa.backend.domain.model.user.User; // <-- IMPORT CORRECTO

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "students")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @NotBlank
    private String fullName;

    @Past
    private LocalDate birthDate;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String ethnicity;
    private String avatar;

    @Enumerated(EnumType.STRING)
    private KolbStyle kolbLearningStyle;

    @Embedded
    private FelderSilvermanStyle felderStyle;

    @ElementCollection
    private List<String> careerPreferences;

    @Embedded
    private AcademicPerformance academicPerformance;
}
