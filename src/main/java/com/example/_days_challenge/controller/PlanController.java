package com.example._days_challenge.controller;

import com.example._days_challenge.dto.PlanRequestDto;
import com.example._days_challenge.dto.PlanResponseDto;
import com.example._days_challenge.entity.Challenge;
import com.example._days_challenge.entity.Plan;
import com.example._days_challenge.service.PlanService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/plan")
public class PlanController {

    private final PlanService planService;

    @PostMapping("")
    public void save(@RequestParam Long challengeId, @RequestBody PlanRequestDto requestDto) {
        planService.save(challengeId, requestDto);
    }

    // plan 조회
    @GetMapping("/{id}")
    public PlanResponseDto findById(@PathVariable Long id) {
        return planService.findById(id);
    }

    // 모든 plan 조회
}
