package com.example._days_challenge.dto.challenge;

import com.example._days_challenge.entity.Challenge;
import lombok.Getter;

@Getter
public class ChallengeListResponseDto {
    private Long id;

    private String title;

    private String goal;

    private Boolean isDone;

    public ChallengeListResponseDto(Challenge challenge) {
        this.id = challenge.getId();
        this.title = challenge.getTitle();
        this.goal = challenge.getGoal();
        this.isDone = challenge.getIsDone();
    }
}