package com.example._days_challenge.dto.plan;

import com.example._days_challenge.entity.Task;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@Getter
public class PlanRequestDto {
    private LocalDate date;

    private String memo;

    private List<Task> tasks;
}
