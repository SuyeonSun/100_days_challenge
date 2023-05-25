package com.example._days_challenge.controller;

import com.example._days_challenge.dto.ChallengeListResponseDto;
import com.example._days_challenge.dto.ChallengeRequestDto;
import com.example._days_challenge.dto.ChallengeResponseDto;
import com.example._days_challenge.service.ChallengeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/challenge")
public class ChallengeController {

    private final ChallengeService challengeService;

    @PostMapping("")
    public void save(@RequestBody ChallengeRequestDto requestDto) {
        challengeService.save(requestDto);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody ChallengeRequestDto requestDto) {
        challengeService.update(id, requestDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        challengeService.delete(id);
    }

    // challenge 조회
    @GetMapping("/{id}")
    public ChallengeResponseDto findById(@PathVariable Long id) {
        return challengeService.findById(id);
    }

    // challengeList 조회
    @GetMapping("/list")
    public List<ChallengeListResponseDto> findList() {
        return challengeService.findList();
    }
}
