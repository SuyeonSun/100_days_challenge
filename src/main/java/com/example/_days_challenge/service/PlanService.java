package com.example._days_challenge.service;

import com.example._days_challenge.dto.PlanRequestDto;
import com.example._days_challenge.repository.PlanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PlanService {
    private final PlanRepository planRepository;

    @Transactional
    public void save(PlanRequestDto requestDto) {
        planRepository.save(requestDto.toEntity());
    }
}
