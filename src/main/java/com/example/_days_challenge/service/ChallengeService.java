package com.example._days_challenge.service;

import com.example._days_challenge.dto.ChallengeListResponseDto;
import com.example._days_challenge.dto.ChallengeRequestDto;
import com.example._days_challenge.dto.ChallengeResponseDto;
import com.example._days_challenge.entity.Challenge;
import com.example._days_challenge.repository.ChallengeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ChallengeService {
    public final ChallengeRepository challengeRepository;

    @Transactional
    public void save(ChallengeRequestDto requestDto) {
        challengeRepository.save(requestDto.toEntity());
    }

    @Transactional
    public void update(Long id, ChallengeRequestDto requestDto) {
        Challenge challenge = challengeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다."));
        challenge.update(requestDto);
    }

    @Transactional
    public void delete(Long id) {
        Challenge challenge = challengeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다."));
        challengeRepository.delete(challenge);
    }

    @Transactional
    public ChallengeResponseDto findById(Long id) {
        Challenge challenge = challengeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다."));
        return new ChallengeResponseDto(challenge);
    }

    @Transactional
    public List<ChallengeListResponseDto> findList() {
        ArrayList<ChallengeListResponseDto> challengeList = new ArrayList<>();
        List<Challenge> challengeListTemp = challengeRepository.findAll();
        for (Challenge challenge : challengeListTemp) {
            challengeList.add(new ChallengeListResponseDto(challenge));
        }
        return challengeList;
    }
}
