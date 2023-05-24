package com.example._days_challenge.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
public class Plan {
    @Id @GeneratedValue
    @Column(name = "plan_id")
    private Long id;

    private LocalDate date;

    private String memo;

    // task
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "challenge_id")
    private Challenge challenge;

    @Builder
    public Plan(LocalDate date, String memo) {
        this.date = date;
        this.memo = memo;
    }
}
