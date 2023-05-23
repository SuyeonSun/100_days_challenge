package com.example._days_challenge;

import com.example._days_challenge.entity.Challenge;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter // TODO: 왜 필요?
public class ChallengeSaveRequestDto {
    private String title;

    private String goal;

    public Challenge toEntity() {
        return Challenge.builder()
                .title(title)
                .goal(goal)
                .build();
    }

}
