package com.example._days_challenge.dto;

import com.example._days_challenge.entity.Plan;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
public class PlanRequestDto {
    private Long challengeId;

    private LocalDate date;

    private String memo;

    public Plan toEntity() {
        return Plan.builder()
                .date(date)
                .memo(memo)
                .build();
    }
}
