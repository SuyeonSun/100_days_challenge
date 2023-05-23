package com.example._days_challenge.service;

import com.example._days_challenge.ChallengeSaveRequestDto;
import com.example._days_challenge.repository.ChallengeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ChallengeService {
    public final ChallengeRepository challengeRepository;

    @Transactional
    public void save(ChallengeSaveRequestDto requestDto) {
        challengeRepository.save(requestDto.toEntity());
    }
}
