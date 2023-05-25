package com.example._days_challenge.dto;

import com.example._days_challenge.entity.Challenge;
import lombok.Getter;

@Getter
public class ChallengeResponseDto {
    private Long id;

    private String title;

    private String goal;

    public ChallengeResponseDto(Challenge entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.goal = entity.getGoal();
    }
}
