package com.example._days_challenge.dto;

import com.example._days_challenge.entity.Challenge;
import lombok.Getter;

@Getter
public class ChallengeListResponseDto {
    private Long id;

    private String title;

    private String goal;

    public ChallengeListResponseDto(Challenge challenge) {
        this.id = challenge.getId();
        this.title = challenge.getTitle();
        this.goal = challenge.getGoal();
    }
}