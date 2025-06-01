package com.educa.backend.domain.model.AcademicPerformance;

package com.educa.backend.domain.model;

import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AcademicPerformance {
    private double gpa;
    private double attendanceRate;
    private String studyHabits;
    private int participationLevel;
}

