package com.example._days_challenge.entity;

import com.example._days_challenge.dto.challenge.ChallengeRequestDto;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
public class Challenge {
    @Id @GeneratedValue
    @Column(name = "challenge_id")
    private Long id;

    private String title;

    private String goal;

    private Boolean isDone;

    @OneToMany(mappedBy = "challenge", fetch = FetchType.LAZY)
    private List<Plan> plans = new ArrayList<>();

    @Builder
    public Challenge(String title, String goal, Boolean isDone) {
        this.title = title;
        this.goal = goal;
        this.isDone = isDone;
    }

    public void update (ChallengeRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.goal = requestDto.getGoal();
        this.isDone = requestDto.getIsDone();
    }
}
