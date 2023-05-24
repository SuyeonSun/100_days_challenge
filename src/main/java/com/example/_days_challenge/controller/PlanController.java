package com.example._days_challenge.controller;

import com.example._days_challenge.dto.PlanRequestDto;
import com.example._days_challenge.entity.Challenge;
import com.example._days_challenge.service.PlanService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/plan")
public class PlanController {

    private final PlanService planService;

    @PostMapping("/{id}")
    public void save(@PathVariable Long id, @RequestBody PlanRequestDto requestDto) {
        planService.save(id, requestDto);
    }
}
