package com.example._days_challenge.controller;

import com.example._days_challenge.ChallengeSaveRequestDto;
import com.example._days_challenge.service.ChallengeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ChallengeController {

    private final ChallengeService challengeService;

    @PostMapping("/")
    public void save(@RequestBody ChallengeSaveRequestDto requestDto) {
        challengeService.save(requestDto);
    }
}
