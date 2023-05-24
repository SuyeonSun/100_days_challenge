package com.example._days_challenge.entity;

import com.example._days_challenge.dto.ChallengeRequestDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class Challenge {
    @Id @GeneratedValue
    @Column(name = "challenge_id")
    private Long id;

    private String title;

    private String goal;

    @Builder
    public Challenge(String title, String goal) {
        this.title = title;
        this.goal = goal;
    }

    public void update (ChallengeRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.goal = requestDto.getGoal();
    }
}
