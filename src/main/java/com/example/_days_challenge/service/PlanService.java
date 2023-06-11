package com.example._days_challenge.service;

import com.example._days_challenge.dto.plan.PlanRequestDto;
import com.example._days_challenge.dto.plan.PlanResponseDto;
import com.example._days_challenge.entity.Challenge;
import com.example._days_challenge.entity.Plan;
import com.example._days_challenge.entity.Task;
import com.example._days_challenge.repository.ChallengeRepository;
import com.example._days_challenge.repository.PlanRepository;
import com.example._days_challenge.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class PlanService {
    private final PlanRepository planRepository;
    private final ChallengeRepository challengeRepository;
    private final TaskRepository taskRepository;

    // 등록
    @Transactional
    public void save(Long challengeId, PlanRequestDto requestDto) {
        Challenge challenge = challengeRepository.findById(challengeId).orElseThrow(() -> new IllegalArgumentException("해당 챌린지가 없습니다."));
        Long planId = planRepository.save(Plan.toEntity(challenge, requestDto)).getId();
        Plan plan = planRepository.findById(planId).orElseThrow(() -> new IllegalArgumentException("해당 플랜이 없습니다."));
        for (Task task : requestDto.getTasks()) {
            taskRepository.save(Task.toEntity(plan, task));
        }
    }

    @Transactional
    public PlanResponseDto findById (Long id) {
        Plan plan = planRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("해당 플랜이 없습니다."));
        return new PlanResponseDto(plan);
    }

    @Transactional
    public void delete(Long id) {
        planRepository.deleteById(id);
    }

    @Transactional
    public void update(Long id, PlanRequestDto requestDto) {
        Plan plan = planRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다."));
        plan.update(requestDto);

        HashMap<Long, Integer> map = new HashMap<>();
        for (Task task : plan.getTasks()) map.put(task.getId(), 0);
        for (Task requestedTask : requestDto.getTasks()) {
            Task task = taskRepository.findById(requestedTask.getId()).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다."));
            task.update(requestedTask);
            map.put(requestedTask.getId(), 1);
        }
        for (Task task : plan.getTasks()) {
            if (map.get(task.getId()) != 1) {
                taskRepository.deleteById(task.getId());
            }
        }
    }
}
