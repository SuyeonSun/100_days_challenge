package com.example._days_challenge.controller;

import com.example._days_challenge.dto.plan.PlanRequestDto;
import com.example._days_challenge.dto.plan.PlanResponseDto;
import com.example._days_challenge.service.PlanService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/plan")
public class PlanController {

    private final PlanService planService;

    // 등록
    @PostMapping("")
    public void save(@RequestParam Long challengeId, @RequestBody PlanRequestDto requestDto) {
        planService.save(challengeId, requestDto);
    }

    // 조회
    @GetMapping("/{id}")
    public PlanResponseDto findById(@PathVariable Long id) {
        return planService.findById(id);
    }

    // 삭제
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        planService.delete(id);
    }

    // 수정
    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody PlanRequestDto requestDto) {
        planService.update(id, requestDto);
    }
}
