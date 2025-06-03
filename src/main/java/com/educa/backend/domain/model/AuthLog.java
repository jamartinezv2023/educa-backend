package com.educa.backend.domain.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthLog {
    private LocalDateTime timestamp;
    private String method;
    private String ip;
    private boolean success;
    private String failureReason;
}
