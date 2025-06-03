package com.educa.backend.domain.model;

import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FelderSilvermanStyle {
    private int activoReflexivo;
    private int sensorialIntuitivo;
    private int visualVerbal;
    private int secuencialGlobal;
}