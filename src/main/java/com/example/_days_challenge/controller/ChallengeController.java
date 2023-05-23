package com.example._days_challenge.controller;

import com.example._days_challenge.ChallengeSaveRequestDto;
import com.example._days_challenge.service.ChallengeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ChallengeController {

    private final ChallengeService challengeService;

    @PostMapping("/")
    public void save(@RequestBody ChallengeSaveRequestDto requestDto) {
        challengeService.save(requestDto);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody ChallengeSaveRequestDto requestDto) {
        challengeService.update(id, requestDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        challengeService.delete(id);
    }
}
