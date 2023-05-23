package com.example._days_challenge.service;

import com.example._days_challenge.ChallengeSaveRequestDto;
import com.example._days_challenge.entity.Challenge;
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

    @Transactional
    public void update(Long id, ChallengeSaveRequestDto requestDto) {
        Challenge challenge = challengeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다."));
        challenge.update(requestDto);
    }

    @Transactional
    public void delete(Long id) {
        Challenge challenge = challengeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다."));
        challengeRepository.delete(challenge);
    }
}
