package com.example._days_challenge.dto.plan;

import com.example._days_challenge.entity.Plan;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
public class PlanRequestDto {
    private LocalDate date;

    private String memo;

}
