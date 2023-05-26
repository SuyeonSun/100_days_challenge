package com.example._days_challenge.dto.plan;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@Getter
public class PlanRequestDto {
    private LocalDate date;

    private String memo;

    private List<String> tasks;
}
