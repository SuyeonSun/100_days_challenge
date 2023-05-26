package com.example._days_challenge.entity;

import com.example._days_challenge.dto.plan.PlanRequestDto;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Getter
public class Plan {
    @Id @GeneratedValue
    @Column(name = "plan_id")
    private Long id;

    private LocalDate date;

    private String memo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "challenge_id")
    private Challenge challenge;

    @Builder
    public Plan(LocalDate date, String memo, Challenge challenge) {
        this.challenge = challenge;
        this.date = date;
        this.memo = memo;
    }

    public static Plan toEntity(Challenge challenge, PlanRequestDto requestDto) {
        return Plan.builder()
                .challenge(challenge)
                .date(requestDto.getDate())
                .memo(requestDto.getMemo())
                .build();
    }
}
