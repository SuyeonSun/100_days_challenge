package com.example._days_challenge.dto.plan;

import com.example._days_challenge.entity.Plan;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class PlanResponseDto {
    private Long id;

    private LocalDate date;

    private String memo;

    public PlanResponseDto(Plan entity) {
        this.id = entity.getId();
        this.date = entity.getDate();
        this.memo = entity.getMemo();
    }
}
