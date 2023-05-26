package com.example._days_challenge.entity;

import com.example._days_challenge.dto.plan.PlanRequestDto;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
public class Plan {
    @Id @GeneratedValue
    @Column(name = "plan_id")
    private Long id;

    private LocalDate date;

    private String memo;

    @ElementCollection
    private List<String> tasks;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "challenge_id")
    private Challenge challenge;

    @Builder
    public Plan(LocalDate date, String memo, List<String> tasks, Challenge challenge) {
        this.challenge = challenge;
        this.date = date;
        this.memo = memo;
        this.tasks = tasks;
    }

    public static Plan toEntity(Challenge challenge, PlanRequestDto requestDto) {
        return Plan.builder()
                .challenge(challenge)
                .date(requestDto.getDate())
                .memo(requestDto.getMemo())
                .tasks(requestDto.getTasks())
                .build();
    }

    public void update(PlanRequestDto requestDto) {
        this.date = requestDto.getDate();
        this.memo = requestDto.getMemo();
        this.tasks = requestDto.getTasks();
    }
}
