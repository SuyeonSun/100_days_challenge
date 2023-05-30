package com.example._days_challenge.dto.plan;

import com.example._days_challenge.entity.Plan;
import com.example._days_challenge.entity.Task;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@Getter
public class PlanResponseDto {
    private Long id;

    private LocalDate date;

    private String memo;

    @JsonIgnoreProperties("plan")
    private List<Task> tasks;

    public PlanResponseDto(Plan entity) {
        this.id = entity.getId();
        this.date = entity.getDate();
        this.memo = entity.getMemo();
        this.tasks = entity.getTasks();
    }
}
