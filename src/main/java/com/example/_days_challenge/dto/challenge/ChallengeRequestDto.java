package com.example._days_challenge.dto.challenge;

import com.example._days_challenge.entity.Challenge;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class ChallengeRequestDto {
    private String title;

    private String goal;

    private Boolean isDone;

    public Challenge toEntity() {
        return Challenge.builder()
                .title(title)
                .goal(goal)
                .isDone(isDone)
                .build();
    }

}
