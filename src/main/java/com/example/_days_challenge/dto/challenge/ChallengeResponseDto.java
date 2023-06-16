package com.example._days_challenge.dto.challenge;

import com.example._days_challenge.entity.Challenge;
import lombok.Getter;

@Getter
public class ChallengeResponseDto {
    private Long id;

    private String title;

    private String goal;

    private Boolean isDone;

    public ChallengeResponseDto(Challenge entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.goal = entity.getGoal();
        this.isDone = entity.getIsDone();
    }
}
