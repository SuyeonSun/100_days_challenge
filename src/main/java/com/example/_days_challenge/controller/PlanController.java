package com.example._days_challenge.controller;

import com.example._days_challenge.dto.PlanRequestDto;
import com.example._days_challenge.service.PlanService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/plan")
public class PlanController {

    private final PlanService planService;

    @PostMapping("")
    public void save(@RequestBody PlanRequestDto requestDto) {
        planService.save(requestDto);
    }
}
