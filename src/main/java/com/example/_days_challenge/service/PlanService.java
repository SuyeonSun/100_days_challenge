package com.example._days_challenge.service;

import com.example._days_challenge.dto.PlanRequestDto;
import com.example._days_challenge.dto.PlanResponseDto;
import com.example._days_challenge.entity.Challenge;
import com.example._days_challenge.entity.Plan;
import com.example._days_challenge.repository.ChallengeRepository;
import com.example._days_challenge.repository.PlanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PlanService {
    private final PlanRepository planRepository;
    private final ChallengeRepository challengeRepository;

    @Transactional
    public void save(Long id, PlanRequestDto requestDto) {
        Challenge challenge = challengeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 챌린지가 없습니다."));
        planRepository.save(Plan.toEntity(challenge, requestDto));
    }

    @Transactional
    public PlanResponseDto findById (Long id) {
        Plan plan = planRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("해당 플랜이 없습니다."));
        return new PlanResponseDto(plan);
    }
}
